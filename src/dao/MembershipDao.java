package dao;

import model.Clients;
import model.Membership;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.lang.reflect.Member;
import java.util.List;

public class MembershipDao extends GenericDao<Membership> {
        private EntityManagerFactory factory;

        public MembershipDao(EntityManagerFactory factory){
            super(Membership.class);
            this.factory = factory;
        }

        public EntityManager getEntityManager(){
            try{
                return factory.createEntityManager();
            }catch (Exception e){
                System.out.println("The entity cannot be created!");
                return null;
            }
        }

    public List<Membership> find(int id) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Membership> cq = cb.createQuery(model.Membership.class);
        Root<Membership> r = cq.from(model.Membership.class);
        ParameterExpression<Integer> idd = cb.parameter(int.class);
        cq.select(r).where(cb.equal(r.get("idMembership"), idd));
        TypedQuery<Membership> query = em.createQuery(cq);
        query.setParameter(idd, id);
        java.util.List<model.Membership> results = query.getResultList();
        return results;
    }
}
