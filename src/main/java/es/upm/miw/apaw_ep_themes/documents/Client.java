package es.upm.miw.apaw_ep_themes.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
    @Id
    private String id;
    private String name;
    private String dni;
    private String lastname;
    private String email;

    public Client(String name, String dni, String lastname, String email) {
        this.name = name;
        this.dni = dni;
        this.lastname = lastname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
}
