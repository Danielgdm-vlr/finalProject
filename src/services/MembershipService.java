package services;

import dao.MembershipDao;
import model.Membership;

import javax.persistence.Persistence;
import java.util.List;

public class MembershipService {
    private MembershipDao membershipDao;

    public MembershipService(){
        try {
            membershipDao = new MembershipDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addMembership(Membership membership){
        membershipDao.create(membership);
    }

    public List<Membership> getAllMemberships(){
        return membershipDao.findAll();
    }
}
