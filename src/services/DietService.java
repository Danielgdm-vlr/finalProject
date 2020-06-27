package services;

import dao.DietDao;
import model.Diets;
import model.Trainers;

import javax.persistence.Persistence;
import java.util.List;

public class DietService {
    private DietDao dietDao;

    public DietService(){
        try {
            dietDao = new DietDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Diets> getAllDiets(){
        return dietDao.findAll();
    }

    public Diets findDietId(int id) throws Exception{
        List<Diets> dietList = dietDao.findId(id);
        if(dietList.size() == 0)
            throw new Exception("Diet not Found");
        Diets diet = dietList.get(0);
        return diet;
    }
}
