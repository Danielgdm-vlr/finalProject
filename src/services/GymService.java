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
            e.printStackTrace();
        }
    }

    public List<Gyms> getAllGyms(){
        return gymDao.findAll();
    }

    public Gyms findGymId(int id) throws Exception {
        List<Gyms> gymList = gymDao.findId(id);
        if(gymList.size() == 0)
            throw new Exception("Gym not Found");
        return gymList.get(0);
    }
}
