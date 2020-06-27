package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Membership {
    private int idMembership;
    private Integer idGym;
    private Integer idTrainer;
    private Integer idDiet;
    private Integer idExercise;

    @Id
    @Column(name = "idMembership")
    public int getIdMembership() {
        return idMembership;
    }

    public void setIdMembership(int idMembership) {
        this.idMembership = idMembership;
    }

    @Basic
    @Column(name = "idGym")
    public Integer getIdGym() {
        return idGym;
    }

    public void setIdGym(Integer idGym) {
        this.idGym = idGym;
    }

    @Basic
    @Column(name = "idTrainer")
    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    @Basic
    @Column(name = "idDiet")
    public Integer getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(Integer idDiet) {
        this.idDiet = idDiet;
    }

    @Basic
    @Column(name = "idExercise")
    public Integer getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(Integer idExercise) {
        this.idExercise = idExercise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return idMembership == that.idMembership &&
                Objects.equals(idGym, that.idGym) &&
                Objects.equals(idTrainer, that.idTrainer) &&
                Objects.equals(idDiet, that.idDiet) &&
                Objects.equals(idExercise, that.idExercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembership, idGym, idTrainer, idDiet, idExercise);
    }

}
