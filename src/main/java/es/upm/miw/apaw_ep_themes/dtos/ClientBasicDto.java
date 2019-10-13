package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Client;

public class ClientBasicDto {
    private String id;
    private String name;

    public ClientBasicDto(){

    }

    public ClientBasicDto(Client client){
        this.id = client.getId();
        this.name = client.getName();
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



    @Override
    public String toString() {
        return "ClientBasicDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
