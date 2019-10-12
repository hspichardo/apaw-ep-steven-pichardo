package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.InstrumentDao;
import es.upm.miw.apaw_ep_themes.documents.Instrument;
import es.upm.miw.apaw_ep_themes.documents.InstrumentType;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentCreationDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;


@Controller
public class InstrumentBusinessController {
    private InstrumentDao instrumentDao;

    @Autowired
    public InstrumentBusinessController(InstrumentDao instrumentDao){
        this.instrumentDao = instrumentDao;
    }
    public InstrumentBasicDto create(InstrumentCreationDto instrumentCreationDto){
        Instrument instrument = new Instrument (instrumentCreationDto.getName(),
                                    instrumentCreationDto.getYearmanufactory(),
                                    new InstrumentType(instrumentCreationDto.getType(),instrumentCreationDto.isHasstrings()));
        this.instrumentDao.save(instrument);
        return new InstrumentBasicDto(instrument);
}

public InstrumentCreationDto readbyId(String id){
        Instrument instrument = findInstrumentByIdAssured(id);
        return new InstrumentCreationDto(instrument);
}

public void update(String id, InstrumentCreationDto instrumentCreationDto){
    Instrument instrument = findInstrumentByIdAssured(id);
    instrument.setName(instrumentCreationDto.getName());
    instrument.setYearmanufactory(instrumentCreationDto.getYearmanufactory());
    instrument.setInstrumenttype(new InstrumentType(instrumentCreationDto.getType(),instrumentCreationDto.isHasstrings()));
    this.instrumentDao.save(instrument);
}

public Instrument findInstrumentByIdAssured(String id){
        return this.instrumentDao.findById(id).orElseThrow(() -> new NotFoundException("Instrument id: " + id));
}

public void delete(String id){
        Instrument instrument = findInstrumentByIdAssured(id);
        this.instrumentDao.delete(instrument);
}
}
