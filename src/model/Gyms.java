package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Gyms {
    private int gymId;
    private String gymLoc;

    @Id
    @Column(name = "gymId")
    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    @Basic
    @Column(name = "gymLoc")
    public String getGymLoc() {
        return gymLoc;
    }

    public void setGymLoc(String gymLoc) {
        this.gymLoc = gymLoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gyms gyms = (Gyms) o;
        return gymId == gyms.gymId &&
                Objects.equals(gymLoc, gyms.gymLoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymId, gymLoc);
    }
}
