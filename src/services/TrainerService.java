package services;

import dao.TrainerDao;
import model.Clients;
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

    public Trainers findTrainer(String fName) throws Exception {
        List<Trainers> trainerList = trainerDao.find(fName);
        if (trainerList.size() == 0)
            throw new Exception("Client not found");
        Trainers trainer = trainerList.get(0);
        return trainer;
    }
}
