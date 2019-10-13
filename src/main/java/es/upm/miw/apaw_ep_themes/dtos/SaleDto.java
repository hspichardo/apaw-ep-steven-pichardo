package es.upm.miw.apaw_ep_themes.dtos;
import es.upm.miw.apaw_ep_themes.documents.Sale;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.util.List;

public class SaleDto {
    private int numelements;
    private List<String> instrumentsIds;
    private String clientId;

    public SaleDto(){
        //empty for framework
    }

    public SaleDto(int numelements, List<String>instrumentsIds, String clientId){
        this.numelements = numelements;
        this.instrumentsIds = instrumentsIds;
        this.clientId = clientId;
    }

    public int getNumelements() {
        return numelements;
    }

    public void setNumelements(int numelements) {
        this.numelements = numelements;
    }

    public List<String> getInstrumentsIds() {
        return instrumentsIds;
    }

    public void setInstrumentsIds(List<String> instrumentsIds) {
        this.instrumentsIds = instrumentsIds;
    }

    public String getClientId() {
        return clientId;
    }

    public void validate(){
        if(this.numelements == 0 || this.instrumentsIds.isEmpty() ){
            throw new BadRequestException(("Incomplete Sales DTO"));
        }
    }
}
