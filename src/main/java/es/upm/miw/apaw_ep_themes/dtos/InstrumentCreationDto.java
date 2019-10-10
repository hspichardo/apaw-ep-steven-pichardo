package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class InstrumentCreationDto {
    private String name;
    private String yearmanufactory;
    private String type;
    private boolean hasstrings;

    public InstrumentCreationDto(){

    }
    public InstrumentCreationDto(String name, String yearmanufactory, String type, boolean hasstrings) {
        this.name = name;
        this.yearmanufactory = yearmanufactory;
        this.type = type;
        this.hasstrings = hasstrings;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHasstrings() {
        return hasstrings;
    }

    public void setHasstrings(boolean hasstrings) {
        this.hasstrings = hasstrings;
    }

    public void validate(){
        if(this.name == null || this.name.isEmpty() || this.type == null || this.type.isEmpty() || this.yearmanufactory == null || this.yearmanufactory.isEmpty()){
            throw new BadRequestException(("Incomplete InstrumentCreationDto"));
        }
    }
}
