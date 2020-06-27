package services;

import dao.TrainerDao;
import model.Trainers;

import javax.persistence.Persistence;
import java.util.List;

public class TrainerService {
    private TrainerDao trainerDao;

    public TrainerService(){
        try{
            trainerDao = new TrainerDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addTrainer(Trainers trainer){
        trainerDao.create(trainer);
    }

    public List<Trainers> getAllTrainers(){
        return trainerDao.findAll();
    }

    public Trainers findTrainer(String fName) throws Exception{
        List<Trainers> trainersList = trainerDao.find(fName);
        if(trainersList.size() == 0)
            throw new Exception("User not Found");
        Trainers trainer = trainersList.get(0);
        return trainer;
    }

    public Trainers findTrainerId(int id) throws Exception{
        List<Trainers> trainersList = trainerDao.findId(id);
        if(trainersList.size() == 0)
            throw new Exception("Trainer not Found");
        Trainers trainer = trainersList.get(0);
        return trainer;
    }
}
