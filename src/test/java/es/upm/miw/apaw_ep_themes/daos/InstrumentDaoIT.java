package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.TestConfig;
import es.upm.miw.apaw_ep_themes.documents.Instrument;
import es.upm.miw.apaw_ep_themes.documents.InstrumentType;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class InstrumentDaoIT {
    @Autowired
    private InstrumentDao instrumentDao;

    @Test

    void testCreate(){
        Instrument instrument = new Instrument("Gibson Les Paul Guitar","1969",new InstrumentType("Electric Guitar", true));
        this.instrumentDao.save(instrument);
        Instrument databaseInstrument = this.instrumentDao.findById(instrument.getId()).orElseGet(Assertions::fail);
        assertEquals("Gibson Les Paul Guitar", databaseInstrument.getName());
    }
}
