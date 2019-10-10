package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Instrument;

public class InstrumentBasicDto {
    private String id;
    private String name;

    public InstrumentBasicDto(){

    }

    public InstrumentBasicDto(Instrument instrument) {
        this.id = instrument.getId();
        this.name = instrument.getName();
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

    @Override
    public String toString() {
        return "InstrumentBasicDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
