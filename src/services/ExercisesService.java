package services;

import dao.ExercisesDao;
import model.Exercises;
import model.Exercises;

import javax.persistence.Persistence;
import java.util.List;

public class ExercisesService {
    private ExercisesDao exercisesDao;

    public ExercisesService(){
        try{
            exercisesDao = new ExercisesDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Exercises> getAllExercises(){
        return exercisesDao.findAll();
    }
}
