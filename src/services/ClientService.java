package services;

import dao.ClientDao;
import model.Clients;

import javax.persistence.Persistence;
import java.util.List;

public class ClientService {
    private ClientDao clientDao;

    public ClientService(){
        try{
            clientDao = new ClientDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addClient(Clients client){
        clientDao.create(client);
    }

    //'future update;
    //public void updateClient(Clients client){
        //clientDao.update(client);
    //}

    public Clients findClient(String fName) throws Exception {
        List<Clients> clientList = clientDao.find(fName);
        if (clientList.size() == 0)
            throw new Exception("Client not found");
        return clientList.get(0);
    }

    public Clients findClientId(int id) throws Exception{
        List<Clients> clientList = clientDao.findId(id);
        if(clientList.size() == 0)
            throw new Exception("Client not Found");
        return clientList.get(0);
    }

    public List<Clients> getAllClients(){
        return clientDao.findAll();
    }
}
