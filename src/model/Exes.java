package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Exes {
    private int exesId;
    private String exesNames;

    @Id
    @Column(name = "exesId")
    public int getExesId() {
        return exesId;
    }

    public void setExesId(int exesId) {
        this.exesId = exesId;
    }

    @Basic
    @Column(name = "exesNames")
    public String getExesNames() {
        return exesNames;
    }

    public void setExesNames(String exesNames) {
        this.exesNames = exesNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exes exes = (Exes) o;
        return exesId == exes.exesId &&
                Objects.equals(exesNames, exes.exesNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exesId, exesNames);
    }

    @Override
    public String toString() {
        return exesNames;
    }
}
