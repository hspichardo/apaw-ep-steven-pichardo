package es.upm.miw.apaw_ep_themes.api_controllers;


import es.upm.miw.apaw_ep_themes.business_controllers.InstrumentBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentCreationDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



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

    @GetMapping(value = ID_ID)
    public InstrumentCreationDto readById(@PathVariable String id){
        return this.instrumentBusinessController.readbyId(id);
    }

    @PutMapping(value = ID_ID)

    public void update(@PathVariable String id,@RequestBody InstrumentCreationDto instrumentCreationDto){
        instrumentCreationDto.validate();
        this.instrumentBusinessController.update(id,instrumentCreationDto);
    }

    @DeleteMapping(value = ID_ID)

    public void delete(@PathVariable String id){
        this.instrumentBusinessController.delete(id);
    }
}
