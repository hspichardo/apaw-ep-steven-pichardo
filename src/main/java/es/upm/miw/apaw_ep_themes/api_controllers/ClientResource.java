package es.upm.miw.apaw_ep_themes.api_controllers;


import es.upm.miw.apaw_ep_themes.business_controllers.ClientBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.ClientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.ClientCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClientResource.CLIENTS)
public class ClientResource {
    public static final String CLIENTS = "/clients";

    private ClientBusinessController clientBusinessController;

    @Autowired
    public ClientResource(ClientBusinessController clientBusinessController){
        this.clientBusinessController = clientBusinessController;
    }

    @PostMapping

    public ClientBasicDto create(@RequestBody ClientCreationDto clientCreationDto){
        clientCreationDto.validate();
        return this.clientBusinessController.create(clientCreationDto);
    }
}
