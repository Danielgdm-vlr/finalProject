package dao;

import model.Trainers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class TrainerDao extends GenericDao<Trainers> {
    private EntityManagerFactory factory;

    public TrainerDao(EntityManagerFactory factory){
        super(Trainers.class);
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() {
        try{
            return factory.createEntityManager();
        }catch (Exception e){
            System.out.println("The entity cannot be created!");
            return null;
        }
    }

    public List<Trainers> find(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trainers> cq = cb.createQuery(model.Trainers.class);
        Root<Trainers> r = cq.from(model.Trainers.class);
        ParameterExpression<String> pName = cb.parameter(String.class);
        cq.select(r).where(cb.equal(r.get("firstNameTrainer"), pName));
        TypedQuery<Trainers> query = em.createQuery(cq);
        query.setParameter(pName, name);
        java.util.List<model.Trainers> results = query.getResultList();
        return results;
    }

    public List<Trainers> findId(int id) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trainers> cq = cb.createQuery(model.Trainers.class);
        Root<Trainers> r = cq.from(model.Trainers.class);
        ParameterExpression<Integer> idd = cb.parameter(int.class);
        cq.select(r).where(cb.equal(r.get("idTrainer"), idd));
        TypedQuery<Trainers> query = em.createQuery(cq);
        query.setParameter(idd, id);
        java.util.List<model.Trainers> results = query.getResultList();
        return results;
    }
}
