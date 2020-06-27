package dao;

import model.Gyms;
import model.Trainers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class GymDao extends GenericDao<Gyms> {
    private EntityManagerFactory factory;

    public GymDao(EntityManagerFactory factory){
        super(Gyms.class);
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() {
        try{
            return factory.createEntityManager();
        }catch (Exception e){
            System.out.println("The entity cannot be created");
            return null;
        }
    }

    public List<Gyms> findId(int id) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Gyms> cq = cb.createQuery(model.Gyms.class);
        Root<Gyms> r = cq.from(model.Gyms.class);
        ParameterExpression<Integer> idd = cb.parameter(int.class);
        cq.select(r).where(cb.equal(r.get("idGym"), idd));
        TypedQuery<Gyms> query = em.createQuery(cq);
        query.setParameter(idd, id);
        java.util.List<model.Gyms> results = query.getResultList();
        return results;
    }
}
