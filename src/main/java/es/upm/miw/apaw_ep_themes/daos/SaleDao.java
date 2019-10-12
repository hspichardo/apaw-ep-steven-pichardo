package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaleDao extends MongoRepository<Sale,String> {
}
