package services;

import dao.ExesDao;
import model.Exes;

import javax.persistence.Persistence;
import java.util.List;

public class ExesService {
    private ExesDao exesDao;

    public ExesService(){
        try{
            exesDao = new ExesDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Exes> getAllEx(){
        return exesDao.findAll();
    }
}
