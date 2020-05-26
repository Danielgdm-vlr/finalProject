package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Mex {
    private int mExId;
    private String monday;
    private int mReps;
    private String tuesday;
    private int tReps;
    private String wednesday;
    private int wReps;
    private String thursday;
    private int thReps;
    private String friday;
    private int fReps;
    private Integer mId;

    @Id
    @Column(name = "mExId")
    public int getmExId() {
        return mExId;
    }

    public void setmExId(int mExId) {
        this.mExId = mExId;
    }

    @Basic
    @Column(name = "monday")
    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    @Basic
    @Column(name = "mReps")
    public int getmReps() {
        return mReps;
    }

    public void setmReps(int mReps) {
        this.mReps = mReps;
    }

    @Basic
    @Column(name = "tuesday")
    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    @Basic
    @Column(name = "tReps")
    public int gettReps() {
        return tReps;
    }

    public void settReps(int tReps) {
        this.tReps = tReps;
    }

    @Basic
    @Column(name = "wednesday")
    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    @Basic
    @Column(name = "wReps")
    public int getwReps() {
        return wReps;
    }

    public void setwReps(int wReps) {
        this.wReps = wReps;
    }

    @Basic
    @Column(name = "thursday")
    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    @Basic
    @Column(name = "thReps")
    public int getThReps() {
        return thReps;
    }

    public void setThReps(int thReps) {
        this.thReps = thReps;
    }

    @Basic
    @Column(name = "friday")
    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    @Basic
    @Column(name = "fReps")
    public int getfReps() {
        return fReps;
    }

    public void setfReps(int fReps) {
        this.fReps = fReps;
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
        Mex mex = (Mex) o;
        return mExId == mex.mExId &&
                mReps == mex.mReps &&
                tReps == mex.tReps &&
                wReps == mex.wReps &&
                thReps == mex.thReps &&
                fReps == mex.fReps &&
                Objects.equals(monday, mex.monday) &&
                Objects.equals(tuesday, mex.tuesday) &&
                Objects.equals(wednesday, mex.wednesday) &&
                Objects.equals(thursday, mex.thursday) &&
                Objects.equals(friday, mex.friday) &&
                Objects.equals(mId, mex.mId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mExId, monday, mReps, tuesday, tReps, wednesday, wReps, thursday, thReps, friday, fReps, mId);
    }
}
