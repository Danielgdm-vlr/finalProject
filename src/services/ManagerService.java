package services;

import dao.GymDao;
import dao.ManagerDao;
import model.Managers;

import javax.persistence.Persistence;
import java.util.List;

public class ManagerService {
    private ManagerDao managerDao;

    public ManagerService(){
        try{
            managerDao = new ManagerDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Managers findManagers(int id) throws Exception {
        List<Managers> managersList = managerDao.findManager(id);
        if(managersList.size() == 0){
            throw new Exception("Manager not found");
        }
        Managers managers = managersList.get(0);
        return managers;
    }
}
