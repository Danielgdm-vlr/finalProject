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
            System.out.println(e);
        }
    }

    public void addClient(Clients client){
        clientDao.create(client);
    }

    public void updateClient(Clients client){
        clientDao.update(client);
    }

    public Clients findClient(String fName) throws Exception {
        List<Clients> clientList = clientDao.find(fName);
        if (clientList.size() == 0)
            throw new Exception("Client not found");
        Clients client = clientList.get(0);
        return client;
    }
}
