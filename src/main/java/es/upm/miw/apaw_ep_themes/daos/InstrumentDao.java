package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Instrument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstrumentDao extends MongoRepository<Instrument, String> {
}
