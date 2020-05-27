package dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class GenericDao<T>{
    private Class<T> modelClass;

    public GenericDao(Class<T> mClass){
        this.modelClass = mClass;
    }

    public abstract EntityManager getEntityManager();

    public void create(T model){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(model);
            em.getTransaction().commit();
        }catch (RuntimeException e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void remove(T model, int modelId){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.remove((T)em.find(this.modelClass, modelId));
            em.getTransaction().commit();
        }catch (RuntimeException e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public void update(T model){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(model);
            em.getTransaction().commit();
        }catch (RuntimeException e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    public List<T> findAll(){
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(modelClass));
            List<T> returnValues = (List<T>) em.createQuery(cq).getResultList();
            return returnValues;
        }catch (RuntimeException e){
            em.getTransaction().rollback();
        }finally {
             em.close();
        }
        return null;
    }
}