package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.ClientDao;
import es.upm.miw.apaw_ep_themes.daos.InstrumentDao;
import es.upm.miw.apaw_ep_themes.daos.SaleDao;
import es.upm.miw.apaw_ep_themes.documents.Client;
import es.upm.miw.apaw_ep_themes.documents.Instrument;
import es.upm.miw.apaw_ep_themes.documents.Sale;
import es.upm.miw.apaw_ep_themes.dtos.SaleBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.SaleDto;
import es.upm.miw.apaw_ep_themes.dtos.SalePatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.EmitterProcessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class SaleBusinessController {
    private SaleDao saleDao;
    private ClientDao clientDao;
    private InstrumentDao instrumentDao;
    private EmitterProcessor<String> emitter;



    @Autowired
    public SaleBusinessController(SaleDao saleDao, ClientDao clientDao, InstrumentDao instrumentDao){
        this.saleDao = saleDao;
        this.clientDao = clientDao;
        this.instrumentDao = instrumentDao;
        this.emitter = EmitterProcessor.create();
    }

    public SaleBasicDto create (SaleDto saleDto){
        Client client = this.clientDao.findById(saleDto.getClientId()).orElseThrow(() -> new NotFoundException("Client not found "));
        Sale sale = new Sale(saleDto.getNumelements(),client);
        saleDto.getInstrumentsIds().stream().forEach(i->{
            Instrument ins = this.instrumentDao.findById(i).orElseThrow(()->new NotFoundException("Instrument not found"));
            sale.getInstruments().add(ins);
        });
        this.saleDao.save(sale);
        this.emitter.onNext("New Sale is created");
        return new SaleBasicDto(sale);
    }

    public void patch(String id, SalePatchDto salePatchDto){
        Sale sale = this.saleDao.findById(id).orElseThrow(()-> new NotFoundException("Sale not found"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        switch (salePatchDto.getPath()){
            case "numelements":
                sale.setNumelements(Integer.parseInt(salePatchDto.getNewValue()));
                break;
            case "date":
                sale.setDate(LocalDateTime.parse(salePatchDto.getNewValue(), formatter));
                break;
            default:
                throw new BadRequestException("SalePatchDto is invalid");
        }
    }

    public List<SaleBasicDto> findbyQuantityofElements (int value){
        return this.saleDao.findAll().stream()
                .filter(sale -> sale.getNumelements() == value)
                .map(SaleBasicDto::new)
                .collect(Collectors.toList());
    }

    public EmitterProcessor<String> publisher() {
        return this.emitter;
    }
}
