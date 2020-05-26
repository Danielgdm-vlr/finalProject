package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Membership {
    private int membershipId;
    private Integer trainerId;
    private Integer dietId;
    private Integer gymId;
    private Integer exesId;

    @Id
    @Column(name = "membershipId")
    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    @Basic
    @Column(name = "trainerId")
    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    @Basic
    @Column(name = "dietId")
    public Integer getDietId() {
        return dietId;
    }

    public void setDietId(Integer dietId) {
        this.dietId = dietId;
    }

    @Basic
    @Column(name = "gymId")
    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    @Basic
    @Column(name = "exesId")
    public Integer getExesId() {
        return exesId;
    }

    public void setExesId(Integer exesId) {
        this.exesId = exesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return membershipId == that.membershipId &&
                Objects.equals(trainerId, that.trainerId) &&
                Objects.equals(dietId, that.dietId) &&
                Objects.equals(gymId, that.gymId) &&
                Objects.equals(exesId, that.exesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipId, trainerId, dietId, gymId, exesId);
    }
}
