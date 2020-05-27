package dao;

import model.Gyms;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
}
