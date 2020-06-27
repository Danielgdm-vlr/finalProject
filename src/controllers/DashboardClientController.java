package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class DashboardClientController {
    @FXML
    private Hyperlink hyperlinkSignOut;
    @FXML
    private Label firstNameClient, lNameC, email, telNo, age, clientName;
    @FXML
    private Label username, password, gym, trainerC, dietP, exP;
    @FXML
    private Button buttonGiveFeedback;

    public void initialize() throws Exception {
        //tabPane
        //firstTab: "Your account"
        //so I need to get the gym where the client goes to, his trainer, his diet and exercisePlan. Bon; and his acc details
        clientName.setText(" " + getUsername());
        username.setText(" " + getUsername());
        password.setText(" " + getPassword()); // "option available in the nest update!" + de facut css label special
        gym.setText("a");
        trainerC.setText("b");
        dietP.setText("c ");
        exP.setText("d ");


        //secondTab, getting funkier: "Give feedback"
        //here it`s easier cuz i dont need to do anything
        //cred ca o sa la future updates

        //thirdTab: "Personal info"
        //so here boi, i gotta get the clients name, lname, email, telNo, and age. Bon++
        firstNameClient.setText(getFName());
        lNameC.setText(getLName());
        email.setText(getEmail());
        telNo.setText(getTelNo());
        age.setText(getAge());
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

    public String getFName() {
        String fn = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signup/SessionSignUpFirstName.txt"))) {
            String usernameTmp;
            while ((usernameTmp = br.readLine()) != null)
                fn = usernameTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fn;
    }

    public String getLName() {
        String ln = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signup/SessionSignUpLastName.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                ln = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ln;
    }

    public String getEmail() {
        String em = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signup/SessionSignUpEmail.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                em = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em;
    }

    public String getTelNo() {
        String tn = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signup/SessionSignUpTelNo.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                tn = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tn;
    }

    public String getAge() {
        String ag = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signup/SessionSignUpAge.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                ag = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ag;
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

    public String getPassword(){
        String password = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/login/SessionPassword.txt"))){
            String passwordTmp;
            while((passwordTmp = br.readLine()) != null)
                password = passwordTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return password;
    }
}
