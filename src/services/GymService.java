package services;

import dao.GymDao;
import model.Gyms;

import javax.persistence.Persistence;
import java.util.List;

public class GymService {
    private GymDao gymDao;

    public GymService() {
        try{
            gymDao = new GymDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Gyms> getAllGyms(){
        return gymDao.findAll();
    }
}
