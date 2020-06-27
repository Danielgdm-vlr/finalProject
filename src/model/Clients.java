package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Clients {
    private int idClient;
    private String firstNameClient;
    private String lastNameClient;
    private String emailClient;
    private String telephoneNumberClient;
    private String ageClient;
    private Integer idMembership;

    @Id
    @Column(name = "IdClient")
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "firstNameClient")
    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    @Basic
    @Column(name = "lastNameClient")
    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    @Basic
    @Column(name = "emailClient")
    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Basic
    @Column(name = "telephoneNumberClient")
    public String getTelephoneNumberClient() {
        return telephoneNumberClient;
    }

    public void setTelephoneNumberClient(String telephoneNumberClient) {
        this.telephoneNumberClient = telephoneNumberClient;
    }

    @Basic
    @Column(name = "ageClient")
    public String getAgeClient() {
        return ageClient;
    }

    public void setAgeClient(String ageClient) {
        this.ageClient = ageClient;
    }

    @Basic
    @Column(name = "IdMembership")
    public Integer getIdMembership() {
        return idMembership;
    }

    public void setIdMembership(Integer idMembership) {
        this.idMembership = idMembership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return idClient == clients.idClient &&
                Objects.equals(firstNameClient, clients.firstNameClient) &&
                Objects.equals(lastNameClient, clients.lastNameClient) &&
                Objects.equals(emailClient, clients.emailClient) &&
                Objects.equals(telephoneNumberClient, clients.telephoneNumberClient) &&
                Objects.equals(ageClient, clients.ageClient) &&
                Objects.equals(idMembership, clients.idMembership);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, firstNameClient, lastNameClient, emailClient, telephoneNumberClient, ageClient, idMembership);
    }

    @Override
    public String toString() {
        return "Clients{" + firstNameClient + " " + lastNameClient + " " + emailClient + " " + telephoneNumberClient + " " + ageClient + " " + idMembership + '}';
    }
}
