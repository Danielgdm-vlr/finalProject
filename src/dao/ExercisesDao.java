package dao;

import model.Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ExercisesDao extends GenericDao<Exercises> {
    private EntityManagerFactory factory;

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
}
