package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class ClientCreationDto {
    private String name;
    private String dni;
    private String lastname;
    private String email;

    public ClientCreationDto(){
        // empty for framework
    }

    public ClientCreationDto(String name, String dni, String lastname, String email) {
        this.name = name;
        this.dni = dni;
        this.lastname = lastname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClientCreationDto{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void validate(){
        if(this.name == null || this.name.isEmpty() || this.dni == null || this.dni.isEmpty() || this.lastname == null || this.lastname.isEmpty() || this.email == null || this.email.isEmpty())
            throw new BadRequestException(("Incomplete ClientCreationDto"));
    }
}
