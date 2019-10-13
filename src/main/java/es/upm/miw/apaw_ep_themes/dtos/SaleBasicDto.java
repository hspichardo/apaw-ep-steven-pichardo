package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Sale;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleBasicDto {
    private String id;
    private int numelements;
    private List<String> instrumentsIds;
    private String clientId;
    private LocalDateTime date;

    public SaleBasicDto(){
        // empty for framework
    }

    public SaleBasicDto(Sale sale){
        List<String> instrumentIds = new ArrayList<>();
        this.id = sale.getId();
        this.clientId = sale.getClient().getId();
        sale.getInstruments().stream().forEach(i->
            instrumentIds.add(i.getId())
        );
        this.instrumentsIds = instrumentIds;
        this.numelements = sale.getNumelements();
        this.date = sale.getDate();
    }

    public String getId() {
        return id;
    }

    public int getNumelements() {
        return numelements;
    }

    public List<String> getInstrumentsIds() {
        return instrumentsIds;
    }

    public String getClientId() {
        return clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "SaleBasicDto{" +
                "id='" + id + '\'' +
                ", numelements=" + numelements +
                ", instrumentsIds=" + instrumentsIds +
                ", clientId='" + clientId + '\'' +
                ", date=" + date +
                '}';
    }
}
