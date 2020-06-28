package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Managers;
import model.Users;
import services.ManagerService;
import services.UserService;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DashboardManagerController {
    @FXML
    private Button buttonSeeGyms, buttonAddTrainer, buttonSeeClientsFeedback, buttonTotalWorkingHours;
    @FXML
    private Hyperlink hyperlinkSignOut;
    @FXML
    private Label managerName;


    public void initialize() throws Exception {
        Managers managers = getManager();
        managerName.setText(" " + managers.getFirstNameManager() + " " + managers.getLastNameManager());
        buttonTotalWorkingHours.setDisable(true);
    }

    public void onClickButtonSeeGyms() throws IOException {
        buttonSeeGyms.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/GymHalls.fxml"));
        Stage seeGymsStage = new Stage();
        Scene sceneSeeGyms = new Scene(root);
        sceneSeeGyms.getStylesheets().add(getClass().getResource("/resources/css/GymHallsStyleSheet.css").toExternalForm());
        seeGymsStage.setTitle("RAW POWER GYM - Manager`s Dashboard / See all the gym halls!");
        seeGymsStage.setScene(sceneSeeGyms);
        seeGymsStage.show();
    }

    public void onClickButtonAddTrainer() throws IOException {
        buttonAddTrainer.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/AddTrainer.fxml"));
        Stage addTrainerStage = new Stage();
        Scene sceneAddTrainer = new Scene(root);
        sceneAddTrainer.getStylesheets().add(getClass().getResource("/resources/css/AddTrainerStyleSheet.css").toExternalForm());
        addTrainerStage.setTitle("RAW POWER GYM - Manager`s Dashboard / Add a new trainer to the gym!");
        addTrainerStage.setScene(sceneAddTrainer);
        addTrainerStage.show();
    }

    public void onClickButtonSeeClientsFeedback(){
        //'future update'
    }

    public void onClickButtonSeeTotalWorkingHours(){
        //'future update'
    }

    public void onClickHyperlinkSignOut() throws IOException {
        hyperlinkSignOut.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/LogIn.fxml"));
        Stage logInStage = new Stage();
        Scene logInScene = new Scene(root);
        logInScene.getStylesheets().add(getClass().getResource("/resources/css/LogInStylesheet.css").toExternalForm());
        logInStage.setTitle("RAW POWER GYM - Log In");
        logInStage.setScene(logInScene);
        logInStage.show();
    }

    public void onClickHyperlinkMe(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {}
    }

    public String getUsername(){
        String username = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/login/SessionUsername.txt"))){
            String usernameTmp;
            while((usernameTmp = br.readLine()) != null)
                username = usernameTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return username;
    }

    public Users getUser() throws Exception{
        String username = getUsername();
        UserService userService = new UserService();
        Users user = userService.findUserDashboard(username);
        return user;
    }
    public Managers getManager() throws Exception{
        Users user = getUser();
        ManagerService managerService = new ManagerService();
        Managers managers = managerService.findManagers(user.getIdManager());
        return managers;
    }
}
