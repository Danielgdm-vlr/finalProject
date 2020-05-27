package dao;

import model.Exes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ExesDao extends GenericDao<Exes> {
    private EntityManagerFactory factory;

    public ExesDao(EntityManagerFactory factory){
        super(Exes.class);
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
