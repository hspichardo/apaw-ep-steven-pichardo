package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.ClientDao;
import es.upm.miw.apaw_ep_themes.daos.InstrumentDao;
import es.upm.miw.apaw_ep_themes.documents.Client;
import es.upm.miw.apaw_ep_themes.documents.Sale;
import es.upm.miw.apaw_ep_themes.dtos.*;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

@ApiTestConfig
public class SaleResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private InstrumentDao instrumentDao;

    @Autowired
    private ClientDao clientDao;

    private Client client;

    @Test

    void TestCreate(){
        List<String> instrumentIds = new ArrayList<>();

        InstrumentCreationDto instrumentCreationDto = new InstrumentCreationDto("Fender Tellecaster","1980","Electrical Guitar", true);
        InstrumentCreationDto instrumentCreationDto2 = new InstrumentCreationDto("Gibson Les Paul Guitar","1969","Electric Guitar",true);
        String id1 = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto2))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody().getId();
        String id2 = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody().getId();
        instrumentIds.add(id1);
        instrumentIds.add(id2);
        Client client = new Client("Harlyn","0930342292","Pichardo","hspichardo@gmail.com");
        this.clientDao.save(client);
        Client clientdatabase = this.clientDao.findById(client.getId()).orElseThrow(()->new NotFoundException("Client not found"));
        SaleDto saleDto = new SaleDto(2,instrumentIds,clientdatabase.getId());
        SaleBasicDto saleBasicDto = this.webTestClient
                .post().uri(SaleResource.SALES)
                .body(BodyInserters.fromObject(saleDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SaleBasicDto.class)
                .returnResult().getResponseBody();
        assertEquals(2,saleBasicDto.getNumelements());

    }

    @Test

    void testPatch(){
        List<String> instrumentIds = new ArrayList<>();

        InstrumentCreationDto instrumentCreationDto = new InstrumentCreationDto("Fender Tellecaster","1980","Electrical Guitar", true);
        InstrumentCreationDto instrumentCreationDto2 = new InstrumentCreationDto("Gibson Les Paul Guitar","1969","Electric Guitar",true);
        String id1 = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto2))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody().getId();
        String id2 = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody().getId();
        instrumentIds.add(id1);
        instrumentIds.add(id2);
        Client client = new Client("Harlyn","0930342292","Pichardo","hspichardo@gmail.com");
        this.clientDao.save(client);
        Client clientdatabase = this.clientDao.findById(client.getId()).orElseThrow(()->new NotFoundException("Client not found"));
        SaleDto saleDto = new SaleDto(2,instrumentIds,clientdatabase.getId());
        String idSale = this.webTestClient
                .post().uri(SaleResource.SALES)
                .body(BodyInserters.fromObject(saleDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SaleBasicDto.class)
                .returnResult().getResponseBody().getId();
        this.webTestClient
                .patch().uri(SaleResource.SALES + SaleResource.ID_ID,idSale)
                .body(BodyInserters.fromObject(new SalePatchDto("numelements","1")))
                .exchange()
                .expectStatus().isOk();

    }

    @Test

    void TestSearch(){
        List<String> instrumentIds = new ArrayList<>();

        InstrumentCreationDto instrumentCreationDto = new InstrumentCreationDto("Fender Tellecaster","1980","Electrical Guitar", true);
        InstrumentCreationDto instrumentCreationDto2 = new InstrumentCreationDto("Gibson Les Paul Guitar","1969","Electric Guitar",true);
        InstrumentCreationDto instrumentCreationDto3 = new InstrumentCreationDto("Gibson Les Paul Guitar GOLD","1980","Electric Guitar",true);
        String id1 = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto2))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody().getId();
        String id2 = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody().getId();
        String id3 = this.webTestClient
                .post().uri(InstrumentResource.INSTRUMENTS)
                .body(BodyInserters.fromObject(instrumentCreationDto3))
                .exchange()
                .expectStatus().isOk()
                .expectBody(InstrumentBasicDto.class)
                .returnResult().getResponseBody().getId();
        instrumentIds.add(id1);
        instrumentIds.add(id2);
        instrumentIds.add(id3);
        Client client = new Client("Harlyn","0930342292","Pichardo","hspichardo@gmail.com");
        this.clientDao.save(client);
        Client clientdatabase = this.clientDao.findById(client.getId()).orElseThrow(()->new NotFoundException("Client not found"));
        SaleDto saleDto = new SaleDto(3,instrumentIds,clientdatabase.getId());
        SaleBasicDto saleBasicDto = this.webTestClient
                .post().uri(SaleResource.SALES)
                .body(BodyInserters.fromObject(saleDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SaleBasicDto.class)
                .returnResult().getResponseBody();
        List<SaleBasicDto> sales = this.webTestClient
                .get().uri(uriBuilder ->
                uriBuilder.path(SaleResource.SALES + SaleResource.SEARCH)
                    .queryParam("q","numelements:3")
                    .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SaleBasicDto.class)
                .returnResult().getResponseBody();
        assertFalse(sales.isEmpty());
    }

}
