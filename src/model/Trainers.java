package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Trainers {
    private int idTrainer;
    private String firstNameTrainer;
    private String lastNameTrainer;
    private String emailTrainer;
    private String telephoneNumberTrainer;
    private String ageTrainer;
    private Integer ratingTrainer;
    private String ratingComments;

    @Id
    @Column(name = "IdTrainer")
    public int getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(int idTrainer) {
        this.idTrainer = idTrainer;
    }

    @Basic
    @Column(name = "firstNameTrainer")
    public String getFirstNameTrainer() {
        return firstNameTrainer;
    }

    public void setFirstNameTrainer(String firstNameTrainer) {
        this.firstNameTrainer = firstNameTrainer;
    }

    @Basic
    @Column(name = "lastNameTrainer")
    public String getLastNameTrainer() {
        return lastNameTrainer;
    }

    public void setLastNameTrainer(String lastNameTrainer) {
        this.lastNameTrainer = lastNameTrainer;
    }

    @Basic
    @Column(name = "emailTrainer")
    public String getEmailTrainer() {
        return emailTrainer;
    }

    public void setEmailTrainer(String emailTrainer) {
        this.emailTrainer = emailTrainer;
    }

    @Basic
    @Column(name = "telephoneNumberTrainer")
    public String getTelephoneNumberTrainer() {
        return telephoneNumberTrainer;
    }

    public void setTelephoneNumberTrainer(String telephoneNumberTrainer) {
        this.telephoneNumberTrainer = telephoneNumberTrainer;
    }

    @Basic
    @Column(name = "ageTrainer")
    public String getAgeTrainer() {
        return ageTrainer;
    }

    public void setAgeTrainer(String ageTrainer) {
        this.ageTrainer = ageTrainer;
    }

    @Basic
    @Column(name = "ratingTrainer")
    public Integer getRatingTrainer() {
        return ratingTrainer;
    }

    public void setRatingTrainer(Integer ratingTrainer) {
        this.ratingTrainer = ratingTrainer;
    }

    @Basic
    @Column(name = "ratingComments")
    public String getRatingComments() {
        return ratingComments;
    }

    public void setRatingComments(String ratingComments) {
        this.ratingComments = ratingComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainers trainers = (Trainers) o;
        return idTrainer == trainers.idTrainer &&
                Objects.equals(firstNameTrainer, trainers.firstNameTrainer) &&
                Objects.equals(lastNameTrainer, trainers.lastNameTrainer) &&
                Objects.equals(emailTrainer, trainers.emailTrainer) &&
                Objects.equals(telephoneNumberTrainer, trainers.telephoneNumberTrainer) &&
                Objects.equals(ageTrainer, trainers.ageTrainer) &&
                Objects.equals(ratingTrainer, trainers.ratingTrainer) &&
                Objects.equals(ratingComments, trainers.ratingComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrainer, firstNameTrainer, lastNameTrainer, emailTrainer, telephoneNumberTrainer, ageTrainer, ratingTrainer, ratingComments);
    }

    @Override
    public String toString() {
        return "Trainers{" + firstNameTrainer + ' ' + " " + lastNameTrainer + " " + emailTrainer + " " + telephoneNumberTrainer + " " + ageTrainer + " " + ratingTrainer +
                " " + ratingComments + '}';
    }
}
