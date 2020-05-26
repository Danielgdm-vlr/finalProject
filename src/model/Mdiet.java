package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Mdiet {
    private int mDietId;
    private String breakfast;
    private int breakfastCal;
    private String lunch;
    private int lunchCal;
    private String dinner;
    private int dinnerCal;
    private int totalCal;
    private Integer mId;

    @Id
    @Column(name = "mDietId")
    public int getmDietId() {
        return mDietId;
    }

    public void setmDietId(int mDietId) {
        this.mDietId = mDietId;
    }

    @Basic
    @Column(name = "breakfast")
    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    @Basic
    @Column(name = "breakfastCal")
    public int getBreakfastCal() {
        return breakfastCal;
    }

    public void setBreakfastCal(int breakfastCal) {
        this.breakfastCal = breakfastCal;
    }

    @Basic
    @Column(name = "lunch")
    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    @Basic
    @Column(name = "lunchCal")
    public int getLunchCal() {
        return lunchCal;
    }

    public void setLunchCal(int lunchCal) {
        this.lunchCal = lunchCal;
    }

    @Basic
    @Column(name = "dinner")
    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    @Basic
    @Column(name = "dinnerCal")
    public int getDinnerCal() {
        return dinnerCal;
    }

    public void setDinnerCal(int dinnerCal) {
        this.dinnerCal = dinnerCal;
    }

    @Basic
    @Column(name = "totalCal")
    public int getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(int totalCal) {
        this.totalCal = totalCal;
    }

    @Basic
    @Column(name = "mId")
    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mdiet mdiet = (Mdiet) o;
        return mDietId == mdiet.mDietId &&
                breakfastCal == mdiet.breakfastCal &&
                lunchCal == mdiet.lunchCal &&
                dinnerCal == mdiet.dinnerCal &&
                totalCal == mdiet.totalCal &&
                Objects.equals(breakfast, mdiet.breakfast) &&
                Objects.equals(lunch, mdiet.lunch) &&
                Objects.equals(dinner, mdiet.dinner) &&
                Objects.equals(mId, mdiet.mId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mDietId, breakfast, breakfastCal, lunch, lunchCal, dinner, dinnerCal, totalCal, mId);
    }
}
