package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentCreationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ApiTestConfig
public class InstrumentResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test

    void testCreate(){
        InstrumentCreationDto instrumentCreationDto = new InstrumentCreationDto("Gibson Les Paul Guitar","1969","Electric Guitar",true);
        InstrumentBasicDto instrumentBasicDto = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals("Gibson Les Paul Guitar",instrumentBasicDto.getName());
    }
}
