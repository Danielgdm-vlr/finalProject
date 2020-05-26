package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Membership {
    private int membershipId;
    private Integer clientId;
    private Integer trainerId;
    private Integer mdiet;
    private Integer mex;
    private Integer gym;

    @Id
    @Column(name = "membershipId")
    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    @Basic
    @Column(name = "clientId")
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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
    @Column(name = "mdiet")
    public Integer getMdiet() {
        return mdiet;
    }

    public void setMdiet(Integer mdiet) {
        this.mdiet = mdiet;
    }

    @Basic
    @Column(name = "mex")
    public Integer getMex() {
        return mex;
    }

    public void setMex(Integer mex) {
        this.mex = mex;
    }

    @Basic
    @Column(name = "gym")
    public Integer getGym() {
        return gym;
    }

    public void setGym(Integer gym) {
        this.gym = gym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return membershipId == that.membershipId &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(trainerId, that.trainerId) &&
                Objects.equals(mdiet, that.mdiet) &&
                Objects.equals(mex, that.mex) &&
                Objects.equals(gym, that.gym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipId, clientId, trainerId, mdiet, mex, gym);
    }
}
