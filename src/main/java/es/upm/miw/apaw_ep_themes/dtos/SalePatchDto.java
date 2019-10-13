package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class SalePatchDto {
    private String path;
    private String newValue;

    public SalePatchDto(){
        // empty for framework
    }

    public SalePatchDto(String path, String newValue){
        this.path = path;
        this.newValue = newValue;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public void validate() {
        if (this.path == null || this.path.isEmpty()) {
            throw new BadRequestException("Incomplete SalePatchDto");
        }
    }

    @Override
    public String toString() {
        return "SalePatchDto{" +
                "path='" + path + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }
}
