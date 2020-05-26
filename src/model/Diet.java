package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Diet {
    private int dietId;
    private String meal;
    private int mealCal;

    @Id
    @Column(name = "dietId")
    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

    @Basic
    @Column(name = "meal")
    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    @Basic
    @Column(name = "mealCal")
    public int getMealCal() {
        return mealCal;
    }

    public void setMealCal(int mealCal) {
        this.mealCal = mealCal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diet diet = (Diet) o;
        return dietId == diet.dietId &&
                mealCal == diet.mealCal &&
                Objects.equals(meal, diet.meal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dietId, meal, mealCal);
    }
}
