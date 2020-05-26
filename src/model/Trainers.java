package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Trainers {
    private int trainerId;
    private String fNameT;
    private String lNameT;
    private String emailT;
    private String telNoT;
    private String ageT;
    private Integer ratingT;
    private String ratingCom;

    @Id
    @Column(name = "trainerId")
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "fNameT")
    public String getfNameT() {
        return fNameT;
    }

    public void setfNameT(String fNameT) {
        this.fNameT = fNameT;
    }

    @Basic
    @Column(name = "lNameT")
    public String getlNameT() {
        return lNameT;
    }

    public void setlNameT(String lNameT) {
        this.lNameT = lNameT;
    }

    @Basic
    @Column(name = "emailT")
    public String getEmailT() {
        return emailT;
    }

    public void setEmailT(String emailT) {
        this.emailT = emailT;
    }

    @Basic
    @Column(name = "telNoT")
    public String getTelNoT() {
        return telNoT;
    }

    public void setTelNoT(String telNoT) {
        this.telNoT = telNoT;
    }

    @Basic
    @Column(name = "ageT")
    public String getAgeT() {
        return ageT;
    }

    public void setAgeT(String ageT) {
        this.ageT = ageT;
    }

    @Basic
    @Column(name = "ratingT")
    public Integer getRatingT() {
        return ratingT;
    }

    public void setRatingT(Integer ratingT) {
        this.ratingT = ratingT;
    }

    @Basic
    @Column(name = "ratingCom")
    public String getRatingCom() {
        return ratingCom;
    }

    public void setRatingCom(String ratingCom) {
        this.ratingCom = ratingCom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainers trainers = (Trainers) o;
        return trainerId == trainers.trainerId &&
                Objects.equals(fNameT, trainers.fNameT) &&
                Objects.equals(lNameT, trainers.lNameT) &&
                Objects.equals(emailT, trainers.emailT) &&
                Objects.equals(telNoT, trainers.telNoT) &&
                Objects.equals(ageT, trainers.ageT) &&
                Objects.equals(ratingT, trainers.ratingT) &&
                Objects.equals(ratingCom, trainers.ratingCom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, fNameT, lNameT, emailT, telNoT, ageT, ratingT, ratingCom);
    }
}
