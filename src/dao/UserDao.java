package dao;

import model.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao extends GenericDao<Users>{
    private EntityManagerFactory factory;

    public UserDao(EntityManagerFactory factory){
        super(Users.class);
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

    //login
    public List<Users> find(String name){
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> cq = cb.createQuery(Users.class);
        Root<Users> r = cq.from(Users.class);
        ParameterExpression<String> pName = cb.parameter(String.class);
        cq.select(r).where(cb.equal(r.get("username"), pName));
        TypedQuery<Users> query = em.createQuery(cq);
        query.setParameter(pName, name);
        List<Users> results = query.getResultList();
        return results;
    }
}
