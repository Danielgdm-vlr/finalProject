package services;

import dao.UserDao;
import javafx.scene.control.Alert;
import model.Trainers;
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

    public Users findUser(String username, String password){
        List<Users> usersList = userDao.find(username);
        if(usersList.size() == 0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username or password is not correct! Check the spelling or click the button to sign up!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            return null;
        }
        Users user = usersList.get(0);
        if (password.compareTo(user.getPassword()) != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username or password is not correct! Check the spelling or click the button to sign up!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            return null;
        }
        return user;
    }

    public int findUserId(String username){
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

    /*public Users findU(String fName) throws Exception {
        List<Users> userList = userDao.find(fName);
        if (userList.size() == 0)
            throw new Exception("User not Found");
        Users user = userList.get(0);
        return user;
    }*/

}
