package dao;

import model.Managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ManagerDao extends GenericDao<Managers> {
    private EntityManagerFactory factory;

    public ManagerDao(EntityManagerFactory factory){
        super(Managers.class);
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
