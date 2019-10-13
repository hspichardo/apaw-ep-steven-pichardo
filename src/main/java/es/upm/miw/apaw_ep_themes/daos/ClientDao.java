package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientDao extends MongoRepository<Client,String> {
}
