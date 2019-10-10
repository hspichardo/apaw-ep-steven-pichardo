package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class Instrument {
    @Id
    private String id;

    private String name;

    private String yearmanufactory;

    private InstrumentType instrumenttype;

    public Instrument(String id, String name, String yearmanufactory, InstrumentType instrumenttype) {
        this.id = id;
        this.name = name;
        this.yearmanufactory = yearmanufactory;
        this.instrumenttype = instrumenttype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearmanufactory() {
        return yearmanufactory;
    }

    public void setYearmanufactory(String yearmanufactory) {
        this.yearmanufactory = yearmanufactory;
    }

    public InstrumentType getInstrumenttype() {
        return instrumenttype;
    }

    public void setInstrumenttype(InstrumentType instrumenttype) {
        this.instrumenttype = instrumenttype;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yearmanufactory='" + yearmanufactory + '\'' +
                ", instrumenttype=" + instrumenttype +
                '}';
    }
}