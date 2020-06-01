package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import model.Users;
import services.UserService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DashboardManagerController {
    @FXML
    private Button buttonSeeGyms, buttonAddTrainer, buttonSeeClientsFeedback, buttonTotalWorkingHours;
    @FXML
    private Hyperlink hyperlinkSignOut;


    public void initialize(){
        String username = getUsername();
        String password = getPassword();
        UserService userService = new UserService();
        Users user = userService.findUser(username, password);
        System.out.println(user);
    }

    public void onClickButtonSeeGyms(){
    }

    public void onClickButtonAddTrainer() throws IOException {
        buttonAddTrainer.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/AddTrainer.fxml"));
        Stage addTrainerStage = new Stage();
        addTrainerStage.setTitle("RAW POWER GYM - Manager`s Dashboard / Add a new trainer to the gym!");
        addTrainerStage.setScene(new Scene(root));
        addTrainerStage.setFullScreen(true);
        addTrainerStage.show();
    }

    public void onClickButtonSeeClientsFeedback(){

    }

    public void onClickButtonSeeTotalWorkingHours(){

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

    public String getUsername(){
        String username = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionUsername.txt"))){
            String usernameTmp;
            while((usernameTmp = br.readLine()) != null)
                username = usernameTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return username;
    }
    public String getPassword(){
        String password = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionPassword.txt"))){
            String passwordTmp;
            while((passwordTmp = br.readLine()) != null)
                password = passwordTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return password;
    }
}
