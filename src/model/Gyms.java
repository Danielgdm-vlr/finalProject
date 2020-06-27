package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Gyms {
    private int idGym;
    private String gymLocation;

    @Id
    @Column(name = "IdGym")
    public int getIdGym() {
        return idGym;
    }

    public void setIdGym(int idGym) {
        this.idGym = idGym;
    }

    @Basic
    @Column(name = "gymLocation")
    public String getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gyms gyms = (Gyms) o;
        return idGym == gyms.idGym &&
                Objects.equals(gymLocation, gyms.gymLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGym, gymLocation);
    }

    @Override
    public String toString() {
        return "Gyms{" + " " + gymLocation + '}';
    }
}
