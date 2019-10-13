package es.upm.miw.apaw_ep_themes.daos;


import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Client;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class ClientDaoIT {
    @Autowired
    private ClientDao clientDao;

    @Test
    void create(){
        Client client = new Client("Harlyn","0930342282","Pichardo","hspichardo@gmail.com");
        this.clientDao.save(client);
        Client clientDatabase = this.clientDao.findById(client.getId()).orElseThrow(()->new NotFoundException("Client not found"));
        assertEquals("Harlyn",clientDatabase.getName());
        assertEquals("Pichardo",clientDatabase.getLastname());
        assertEquals("0930342282",clientDatabase.getDni());
        assertEquals("hspichardo@gmail.com",clientDatabase.getEmail());

    }
}
