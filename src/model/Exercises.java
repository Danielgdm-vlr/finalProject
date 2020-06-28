package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Exercises {
    private int idExercise;
    private String exerciseName;

    @Id
    @Column(name = "idExercise")
    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    @Basic
    @Column(name = "exerciseName")
    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercises exercises = (Exercises) o;
        return idExercise == exercises.idExercise &&
                Objects.equals(exerciseName, exercises.exerciseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExercise, exerciseName);
    }

    @Override
    public String toString() {
        return exerciseName;
    }
}
