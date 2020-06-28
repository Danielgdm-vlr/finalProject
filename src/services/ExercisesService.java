package services;

import dao.ExercisesDao;
import model.Diets;
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

    public Exercises findExerciseId(int id) throws Exception{
        List<Exercises> exercisesList = exercisesDao.findId(id);
        if(exercisesList.size() == 0)
            throw new Exception("Exercise not Found");
        Exercises exercises = exercisesList.get(0);
        return exercises;
    }
}
