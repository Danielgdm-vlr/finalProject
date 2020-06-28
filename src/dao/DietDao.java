package dao;

import model.Diets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class DietDao extends GenericDao<Diets> {
    private final EntityManagerFactory factory;

    public DietDao(EntityManagerFactory factory){
        super(Diets.class);
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

    public List<Diets> findId(int id) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Diets> cq = cb.createQuery(model.Diets.class);
        Root<Diets> r = cq.from(model.Diets.class);
        ParameterExpression<Integer> idd = cb.parameter(int.class);
        cq.select(r).where(cb.equal(r.get("idDiet"), idd));
        TypedQuery<Diets> query = em.createQuery(cq);
        query.setParameter(idd, id);
        return query.getResultList();
    }
}
