package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Managers {
    private int idManager;
    private String firstNameManager;
    private String lastNameManager;
    private String emailManager;
    private String telephoneNumberManager;

    @Id
    @Column(name = "idManager")
    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    @Basic
    @Column(name = "firstNameManager")
    public String getFirstNameManager() {
        return firstNameManager;
    }

    public void setFirstNameManager(String firstNameManager) {
        this.firstNameManager = firstNameManager;
    }

    @Basic
    @Column(name = "lastNameManager")
    public String getLastNameManager() {
        return lastNameManager;
    }

    @Override
    public String toString() {
        return firstNameManager + " " + lastNameManager + " " + emailManager + " " + telephoneNumberManager;
    }

    public void setLastNameManager(String lastNameManager) {
        this.lastNameManager = lastNameManager;
    }

    @Basic
    @Column(name = "emailManager")
    public String getEmailManager() {
        return emailManager;
    }

    public void setEmailManager(String emailManager) {
        this.emailManager = emailManager;
    }

    @Basic
    @Column(name = "telephoneNumberManager")
    public String getTelephoneNumberManager() {
        return telephoneNumberManager;
    }

    public void setTelephoneNumberManager(String telephoneNumberManager) {
        this.telephoneNumberManager = telephoneNumberManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Managers managers = (Managers) o;
        return idManager == managers.idManager &&
                Objects.equals(firstNameManager, managers.firstNameManager) &&
                Objects.equals(lastNameManager, managers.lastNameManager) &&
                Objects.equals(emailManager, managers.emailManager) &&
                Objects.equals(telephoneNumberManager, managers.telephoneNumberManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idManager, firstNameManager, lastNameManager, emailManager, telephoneNumberManager);
    }
}
