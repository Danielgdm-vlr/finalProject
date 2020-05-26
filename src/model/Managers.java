package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Managers {
    private int managerId;
    private String fNameM;
    private String lNameM;
    private String emailM;
    private String telNoM;

    @Id
    @Column(name = "managerId")
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "fNameM")
    public String getfNameM() {
        return fNameM;
    }

    public void setfNameM(String fNameM) {
        this.fNameM = fNameM;
    }

    @Basic
    @Column(name = "lNameM")
    public String getlNameM() {
        return lNameM;
    }

    public void setlNameM(String lNameM) {
        this.lNameM = lNameM;
    }

    @Basic
    @Column(name = "emailM")
    public String getEmailM() {
        return emailM;
    }

    public void setEmailM(String emailM) {
        this.emailM = emailM;
    }

    @Basic
    @Column(name = "telNoM")
    public String getTelNoM() {
        return telNoM;
    }

    public void setTelNoM(String telNoM) {
        this.telNoM = telNoM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Managers managers = (Managers) o;
        return managerId == managers.managerId &&
                Objects.equals(fNameM, managers.fNameM) &&
                Objects.equals(lNameM, managers.lNameM) &&
                Objects.equals(emailM, managers.emailM) &&
                Objects.equals(telNoM, managers.telNoM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, fNameM, lNameM, emailM, telNoM);
    }
}
