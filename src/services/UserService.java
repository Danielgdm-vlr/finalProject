package services;

import dao.UserDao;
import javafx.scene.control.Alert;
import model.Ex;
import model.Users;

import javax.persistence.Persistence;
import java.util.List;

public class UserService {
    private UserDao userDao;

    public UserService(){
        try{
            userDao = new UserDao(Persistence.createEntityManagerFactory("finalProject"));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addUser(Users user){
        userDao.create(user);
    }

    public List<Users> getAllUsers(){
        return userDao.findAll();
    }
    public Users findUser(String username, String password) throws Exception{
        List<Users> usersList = userDao.find(username);
        boolean found = true;
        if(usersList.size() == 0) {
            System.out.println("User not found!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username was not found in the database. Check the spelling or click the button to sign up!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            found = false;
        }
        Users user = new Users();
        boolean logIn = true;
        if(found) {
            user = usersList.get(0);
            if (password.compareTo(user.getPassword()) != 0) {
                System.out.println("Password does not match!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Passwords do not match. Check the spelling!");
                alert.setTitle("opsie dopsie :S");
                alert.setHeaderText(null);
                alert.show();
                logIn = false;
                return null;
            }
        }
        //if(logIn)
          //  return user;
      //  else
           // return null;
        return user;
    }

    public int findUserId(String username) throws Exception{
        List<Users> usersList = userDao.find(username);
        boolean found = true;
        if(usersList.size() == 0) {
            found = false;
        }
        if(found) {
            Users user = usersList.get(0);
            if (user.getManagerId() != null)
                return 1;
            if (user.getTrainerId() != null)
                return 2;
            if (user.getClientId() != null)
                return 3;
        }
        return 0;
    }

}
