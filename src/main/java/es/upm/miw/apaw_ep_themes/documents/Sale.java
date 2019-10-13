package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Sale {
    @Id
    private String id;
    private LocalDateTime date;
    private int numelements;
    @DBRef
    private Client client;
    @DBRef
    List<Instrument> instrumentsIds;

    public Sale( int numelements, Client client) {
        this.date = LocalDateTime.now();
        this.numelements = numelements;
        this.client = client;
        this.instrumentsIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getNumelements() {
        return numelements;
    }

    public Client getClient() {
        return client;
    }

    public List<Instrument> getInstruments() {
        return instrumentsIds;
    }

    public void setNumelements(int numelements) {
        this.numelements = numelements;
    }
}
