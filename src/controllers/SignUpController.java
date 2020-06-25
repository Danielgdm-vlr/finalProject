package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class SignUpController {
    @FXML
    private Button buttonSignUp;
    @FXML
    private Hyperlink hyperlinkLogIn;
    @FXML
    private TextField fName, lName, email, telNo, age, username, password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private CheckBox checkBoxVerifyHuman;

    private String fN, lN, em, tN, ag, un, pw, cpw;

    public void initialize(){
        buttonSignUp.setDisable(true);
    }

    public void keyReleasedProperty(){
        fN = fName.getText();
        lN = lName.getText();
        em = email.getText();
        tN = telNo.getText();
        ag = age.getText();
        un = username.getText();
        pw = password.getText();
        cpw = confirmPassword.getText();
        boolean buttonDisable = (fN.isEmpty() || fN.trim().isEmpty() || lN.isEmpty() || lN.trim().isEmpty() ||
                                 em.isEmpty() || em.trim().isEmpty() || tN.isEmpty() || tN.trim().isEmpty() ||
                                 ag.isEmpty() || ag.trim().isEmpty() || un.isEmpty() || un.trim().isEmpty() ||
                                 pw.isEmpty() || pw.trim().isEmpty() || cpw.isEmpty() || cpw.trim().isEmpty() ||
                                 !pw.equals(cpw) || !checkBoxVerifyHuman.isSelected());
        buttonSignUp.setDisable(buttonDisable);
    }

    public void onClickHyperlinkLogIn() throws IOException {
        hyperlinkLogIn.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/LogIn.fxml"));
        Stage logInStage = new Stage();
        Scene logInScene = new Scene(root);
        logInScene.getStylesheets().add(getClass().getResource("/resources/css/LogInStylesheet.css").toExternalForm());
        logInStage.setTitle("RAW POWER GYM - Log In");
        logInStage.setScene(logInScene);
        logInStage.show();
    }

    public void onClickButtonSignUp() throws Exception {
        buttonSignUp.getScene().getWindow().hide();
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signup/SessionSignUpFirstName.txt"))){
            writer.println(fN);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signup/SessionSignUpLastName.txt"))){
            writer.println(fN);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signup/SessionSignUpEmail.txt"))){
            writer.println(em);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signup/SessionSignUpTelNo.txt"))){
            writer.println(tN);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signup/SessionSignUpAge.txt"))){
            writer.println(ag);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/login/SessionUsername.txt"))){
            writer.println(un);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/login/SessionPassword.txt"))){
            writer.println(pw);
        }catch (Exception e){
            e.printStackTrace();
        }
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/Membership.fxml"));
        Stage dMmStage = new Stage();
        Scene sceneDMm = new Scene(root);
        sceneDMm.getStylesheets().add(getClass().getResource("/resources/css/MembershipStylesheet.css").toExternalForm());
        dMmStage.setTitle("RAW POWER GYM - Create YOUR Membership!");
        dMmStage.setScene(sceneDMm);
        dMmStage.show();
    }

    public void onClickHyperlinkMe(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {}
    }
}
