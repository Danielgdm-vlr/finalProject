package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ex {
    private int exId;
    private String exName;
    private int exReps;

    @Id
    @Column(name = "exId")
    public int getExId() {
        return exId;
    }

    public void setExId(int exId) {
        this.exId = exId;
    }

    @Basic
    @Column(name = "exName")
    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    @Basic
    @Column(name = "exReps")
    public int getExReps() {
        return exReps;
    }

    public void setExReps(int exReps) {
        this.exReps = exReps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ex ex = (Ex) o;
        return exId == ex.exId &&
                exReps == ex.exReps &&
                Objects.equals(exName, ex.exName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exId, exName, exReps);
    }
}
