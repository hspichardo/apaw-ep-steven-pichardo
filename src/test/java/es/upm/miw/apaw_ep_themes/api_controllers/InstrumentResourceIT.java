package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.InstrumentDao;
import es.upm.miw.apaw_ep_themes.documents.Instrument;
import es.upm.miw.apaw_ep_themes.documents.InstrumentType;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.InstrumentCreationDto;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ApiTestConfig
public class InstrumentResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private InstrumentDao instrumentDao;

    private Instrument instrument;


    @BeforeEach

    void before(){
        InstrumentType instrumentType = new InstrumentType("Electric Guitar",true);
        Instrument instrument = new Instrument("Gibson Les Paul GOLD","1970",instrumentType);
        this.instrument =instrument;
        this.instrumentDao.save(instrument);
    }

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
        assertEquals("1969",instrumentCreationDto.getYearmanufactory());
        assertEquals("Electric Guitar",instrumentCreationDto.getType());
    }


    @Test
    void testRead(){
        String id = this.instrumentDao.findById(this.instrument.getId()).get().getId();
        InstrumentBasicDto instrumentCreationDto = this.webTestClient
                .get().uri(InstrumentResource.INSTRUMENTS + InstrumentResource.ID_ID,id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals("Gibson Les Paul GOLD", instrumentCreationDto.getName());

    }

    @Test

    void testException(){
        InstrumentCreationDto instrumentCreationDto = new InstrumentCreationDto(null,null,null,true);
        this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testUpdate(){
        String id = this.instrumentDao.findById(this.instrument.getId()).get().getId();
        InstrumentCreationDto instrumentCreationDto = new InstrumentCreationDto("Fender Tellecaster","1980","Electrical Guitar", true);
        this.webTestClient
                .put().uri(InstrumentResource.INSTRUMENTS + InstrumentResource.ID_ID,id)
                .body(BodyInserters.fromObject(instrumentCreationDto))
                .exchange()
                .expectStatus().isOk();
    }
}
