package services;

import dao.DietDao;
import model.Diets;

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
}
