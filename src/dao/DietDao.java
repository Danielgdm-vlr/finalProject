package dao;

import model.Diets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DietDao extends GenericDao<Diets> {
    private EntityManagerFactory factory;

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
}
