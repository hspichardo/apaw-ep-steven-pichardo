package es.upm.miw.apaw_ep_themes.api_controllers;


import es.upm.miw.apaw_ep_themes.business_controllers.InstrumentBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentCreationDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(InstrumentResource.INSTRUMENTS)
public class InstrumentResource {
    public static final String INSTRUMENTS = "/instruments";
    static final String ID_ID = "/{id}";
    static final String NAME = "/name";

    private InstrumentBusinessController instrumentBusinessController;

    @Autowired
    public InstrumentResource(InstrumentBusinessController instrumentBusinessController){
        this.instrumentBusinessController = instrumentBusinessController;
    }

    @PostMapping

    public InstrumentBasicDto create(@RequestBody InstrumentCreationDto instrumentCreationDto){
        instrumentCreationDto.validate();
        return this.instrumentBusinessController.create(instrumentCreationDto);
    }
}
