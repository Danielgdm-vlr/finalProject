package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Clients {
    private int clientId;
    private String fNameC;
    private String lNameC;
    private String emailC;
    private String telNoC;
    private String ageC;

    @Id
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "fNameC")
    public String getfNameC() {
        return fNameC;
    }

    public void setfNameC(String fNameC) {
        this.fNameC = fNameC;
    }

    @Basic
    @Column(name = "lNameC")
    public String getlNameC() {
        return lNameC;
    }

    public void setlNameC(String lNameC) {
        this.lNameC = lNameC;
    }

    @Basic
    @Column(name = "emailC")
    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    @Basic
    @Column(name = "telNoC")
    public String getTelNoC() {
        return telNoC;
    }

    public void setTelNoC(String telNoC) {
        this.telNoC = telNoC;
    }

    @Basic
    @Column(name = "ageC")
    public String getAgeC() {
        return ageC;
    }

    public void setAgeC(String ageC) {
        this.ageC = ageC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return clientId == clients.clientId &&
                Objects.equals(fNameC, clients.fNameC) &&
                Objects.equals(lNameC, clients.lNameC) &&
                Objects.equals(emailC, clients.emailC) &&
                Objects.equals(telNoC, clients.telNoC) &&
                Objects.equals(ageC, clients.ageC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, fNameC, lNameC, emailC, telNoC, ageC);
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientId=" + clientId +
                ", fNameC='" + fNameC + '\'' +
                ", lNameC='" + lNameC + '\'' +
                '}';
    }
}
