package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Exercises {
    private int idExercises;
    private String exercisesNames;

    @Id
    @Column(name = "Id_Exercises")
    public int getIdExercises() {
        return idExercises;
    }

    public void setIdExercises(int idExercises) {
        this.idExercises = idExercises;
    }

    @Basic
    @Column(name = "exercisesNames")
    public String getExercisesNames() {
        return exercisesNames;
    }

    public void setExercisesNames(String exercisesNames) {
        this.exercisesNames = exercisesNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercises exercises = (Exercises) o;
        return idExercises == exercises.idExercises &&
                Objects.equals(exercisesNames, exercises.exercisesNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExercises, exercisesNames);
    }

    @Override
    public String toString() {
        return "Exercises{" + " " + exercisesNames + '}';
    }
}
