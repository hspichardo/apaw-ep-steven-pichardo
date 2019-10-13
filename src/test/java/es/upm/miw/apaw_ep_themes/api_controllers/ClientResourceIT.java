package es.upm.miw.apaw_ep_themes.api_controllers;


import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.ClientDao;

import es.upm.miw.apaw_ep_themes.dtos.ClientBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.ClientCreationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
public class ClientResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ClientDao clientDao;

    @Test

    void TestCreate(){
        ClientCreationDto clientCreationDto = new ClientCreationDto("Harlyn","0930342282","Pichardo","hspichardo@gmail.com");
        ClientBasicDto clientBasicDto = this.webTestClient
                .post().uri(ClientResource.CLIENTS)
                .body(BodyInserters.fromObject(clientCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ClientBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals("Harlyn", clientBasicDto.getName());

    }
}
