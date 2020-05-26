package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Diets {
    private int dietId;
    private String dietMeals;
    private String dietCal;

    @Id
    @Column(name = "dietId")
    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
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
    @Column(name = "dietCal")
    public String getDietCal() {
        return dietCal;
    }

    public void setDietCal(String dietCal) {
        this.dietCal = dietCal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diets diets = (Diets) o;
        return dietId == diets.dietId &&
                Objects.equals(dietMeals, diets.dietMeals) &&
                Objects.equals(dietCal, diets.dietCal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dietId, dietMeals, dietCal);
    }
}
