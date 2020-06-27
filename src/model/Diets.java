package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Diets {
    private int idDiet;
    private String dietMeals;
    private String dietCalories;

    @Id
    @Column(name = "IdDiet")
    public int getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(int idDiet) {
        this.idDiet = idDiet;
    }

    @Basic
    @Column(name = "dietMeals")
    public String getDietMeals() {
        return dietMeals;
    }

    public void setDietMeals(String dietMeals) {
        this.dietMeals = dietMeals;
    }

    @Basic
    @Column(name = "dietCalories")
    public String getDietCalories() {
        return dietCalories;
    }

    public void setDietCalories(String dietCalories) {
        this.dietCalories = dietCalories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diets diets = (Diets) o;
        return idDiet == diets.idDiet &&
                Objects.equals(dietMeals, diets.dietMeals) &&
                Objects.equals(dietCalories, diets.dietCalories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiet, dietMeals, dietCalories);
    }

    @Override
    public String toString() {
        return "Diets{" + " " + dietMeals + " " + dietCalories  + '}';
    }
}
