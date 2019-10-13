package es.upm.miw.apaw_ep_themes.business_controllers;


import es.upm.miw.apaw_ep_themes.daos.ClientDao;
import es.upm.miw.apaw_ep_themes.documents.Client;
import es.upm.miw.apaw_ep_themes.dtos.ClientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.ClientCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class ClientBusinessController {
    private ClientDao clientDao;

    @Autowired
    public ClientBusinessController(ClientDao clientDao){
        this.clientDao = clientDao;
    }


    public ClientBasicDto create(ClientCreationDto clientCreationDto){
        Client client = new Client(clientCreationDto.getName(),clientCreationDto.getDni(),clientCreationDto.getLastname(),clientCreationDto.getEmail());
        this.clientDao.save(client);
        return new ClientBasicDto(client);
    }
}
