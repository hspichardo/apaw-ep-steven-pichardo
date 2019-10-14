package es.upm.miw.apaw_ep_themes.documents;

public class InstrumentBuilder {
    private String name;

    private String yearmanufactory;

    private InstrumentType instrumenttype;

    public InstrumentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public InstrumentBuilder setYearManufactury (String yearmanufactory){
        this.yearmanufactory = yearmanufactory;
        return this;
    }

    public InstrumentBuilder setInstrumentType(InstrumentType instrumentType){
        this.instrumenttype = instrumentType;
        return this;
    }

    public Instrument build(){
        return new Instrument(name,yearmanufactory,instrumenttype);
    }

}
