package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.InstrumentDao;
import es.upm.miw.apaw_ep_themes.documents.Instrument;
import es.upm.miw.apaw_ep_themes.documents.InstrumentType;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentCreationDto;
import org.springframework.beans.factory.annotation.Autowired;

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
}
