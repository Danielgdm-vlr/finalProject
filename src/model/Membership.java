package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Membership {
    private int idMembership;
    private Integer idTrainer;
    private Integer idDiet;
    private Integer idGym;
    private Integer idExercises;

    @Id
    @Column(name = "IdMembership")
    public int getIdMembership() {
        return idMembership;
    }

    public void setIdMembership(int idMembership) {
        this.idMembership = idMembership;
    }

    @Basic
    @Column(name = "IdTrainer")
    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    @Basic
    @Column(name = "IdDiet")
    public Integer getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(Integer idDiet) {
        this.idDiet = idDiet;
    }

    @Basic
    @Column(name = "IdGym")
    public Integer getIdGym() {
        return idGym;
    }

    public void setIdGym(Integer idGym) {
        this.idGym = idGym;
    }

    @Basic
    @Column(name = "IdExercises")
    public Integer getIdExercises() {
        return idExercises;
    }

    public void setIdExercises(Integer idExercises) {
        this.idExercises = idExercises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return idMembership == that.idMembership &&
                Objects.equals(idTrainer, that.idTrainer) &&
                Objects.equals(idDiet, that.idDiet) &&
                Objects.equals(idGym, that.idGym) &&
                Objects.equals(idExercises, that.idExercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembership, idTrainer, idDiet, idGym, idExercises);
    }

    @Override
    public String toString() {
        return "Membership{" + " " + idTrainer + " " + idDiet + " " + idGym + " " + idExercises + '}';
    }
}
