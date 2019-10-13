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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class SaleBusinessController {
    private SaleDao saleDao;
    private ClientDao clientDao;
    private InstrumentDao instrumentDao;

    @Autowired
    public SaleBusinessController(SaleDao saleDao, ClientDao clientDao, InstrumentDao instrumentDao){
        this.saleDao = saleDao;
        this.clientDao = clientDao;
        this.instrumentDao = instrumentDao;
    }

    public SaleBasicDto create (SaleDto saleDto){
        Client client = this.clientDao.findById(saleDto.getClientId()).orElseThrow(() -> new NotFoundException("Client not found "));
        Sale sale = new Sale(saleDto.getNumelements(),client);
        saleDto.getInstrumentsIds().stream().forEach(i->{
            Instrument ins = this.instrumentDao.findById(i).orElseThrow(()->new NotFoundException("Instrument not found"));
            sale.getInstruments().add(ins);
        });
        this.saleDao.save(sale);
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
}
