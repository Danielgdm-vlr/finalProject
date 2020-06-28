package dao;

import model.Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class ExercisesDao extends GenericDao<Exercises> {
    private final EntityManagerFactory factory;

    public ExercisesDao(EntityManagerFactory factory){
        super(Exercises.class);
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

    public List<Exercises> findId(int id) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Exercises> cq = cb.createQuery(model.Exercises.class);
        Root<Exercises> r = cq.from(model.Exercises.class);
        ParameterExpression<Integer> idd = cb.parameter(int.class);
        cq.select(r).where(cb.equal(r.get("idExercise"), idd));
        TypedQuery<Exercises> query = em.createQuery(cq);
        query.setParameter(idd, id);
        return query.getResultList();
    }
}
