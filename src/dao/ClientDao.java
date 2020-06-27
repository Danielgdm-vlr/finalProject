package dao;

import model.Clients;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClientDao extends GenericDao<Clients> {
    private EntityManagerFactory factory;

    public ClientDao(EntityManagerFactory factory){
        super(Clients.class);
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() {
        try {
            return factory.createEntityManager();
        }catch (Exception e){
            System.out.println("The entity cannot be created!");
            return null;
        }
    }

    public List<Clients> find(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<model.Clients> cq = cb.createQuery(model.Clients.class);
        Root<model.Clients> r = cq.from(model.Clients.class);
        ParameterExpression<String> pName = cb.parameter(String.class);
        cq.select(r).where(cb.equal(r.get("firstNameClient"), pName));
        TypedQuery<model.Clients> query = em.createQuery(cq);
        query.setParameter(pName, name);
        java.util.List<model.Clients> results = query.getResultList();
        return results;
    }

    public List<Clients> findId(int id) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<model.Clients> cq = cb.createQuery(model.Clients.class);
        Root<model.Clients> r = cq.from(model.Clients.class);
        ParameterExpression<Integer> idd = cb.parameter(int.class);
        cq.select(r).where(cb.equal(r.get("idMembership"), idd));
        TypedQuery<model.Clients> query = em.createQuery(cq);
        query.setParameter(idd, id);
        java.util.List<model.Clients> results = query.getResultList();
        return results;
    }
}
