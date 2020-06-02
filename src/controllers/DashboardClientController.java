package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Clients;
import model.Users;
import services.ClientService;
import services.UserService;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DashboardClientController {
    @FXML
    private Hyperlink hyperlinkSignOut;
    @FXML
    private Label fNameC, lNameC, email, telNo, age;
    @FXML
    private Label username, password, gym, trainerC, dietP, exP;
    @FXML
    private Button buttonGiveFeedback;

    public void initialize() throws Exception {
        //tabPane
        //firstTab: "Your account"
        //so I need to get the gym where the client goes to, his trainer, his diet and exercisePlan. Bon

        //secondTab, getting funkier: "Give feedback"
        //here it`s easier cuz i dont need to do anything

        //thirdTab: "Personal info"
        //so here boi, i gotta get the clients name, lname, email, telNo, and age. Bon++
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

    public void onClickButtonGiveFeedback(){

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
}
