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

    private String firstNameClient, lastNameClient, emailClient, telephoneNumberClient, ageClient, usernameClient, passwordClient, confirmPasswordClient;

    public void initialize(){
        buttonSignUp.setDisable(true);
    }

    public void keyReleasedProperty(){
        firstNameClient = fName.getText();
        lastNameClient = lName.getText();
        emailClient = email.getText();
        telephoneNumberClient = telNo.getText();
        ageClient = age.getText();
        usernameClient = username.getText();
        passwordClient = password.getText();
        confirmPasswordClient = confirmPassword.getText();
        boolean buttonDisable = (firstNameClient.isEmpty() || firstNameClient.trim().isEmpty() || lastNameClient.isEmpty() || lastNameClient.trim().isEmpty() ||
                                 emailClient.isEmpty() || emailClient.trim().isEmpty() || telephoneNumberClient.isEmpty() || telephoneNumberClient.trim().isEmpty() ||
                                 ageClient.isEmpty() || ageClient.trim().isEmpty() || usernameClient.isEmpty() || usernameClient.trim().isEmpty() ||
                                 passwordClient.isEmpty() || passwordClient.trim().isEmpty() || confirmPasswordClient.isEmpty() || confirmPasswordClient.trim().isEmpty() ||
                                 !passwordClient.equals(confirmPasswordClient) || !checkBoxVerifyHuman.isSelected());
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
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signUp/SessionSignUpFirstName.txt"))){
            writer.println(firstNameClient);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signUp/SessionSignUpLastName.txt"))){
            writer.println(lastNameClient);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signUp/SessionSignUpEmail.txt"))){
            writer.println(emailClient);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signUp/SessionSignUpTelNo.txt"))){
            writer.println(telephoneNumberClient);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/signUp/SessionSignUpAge.txt"))){
            writer.println(ageClient);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/logIn/SessionUsername.txt"))){
            writer.println(usernameClient);
        }catch (Exception e) {
            e.printStackTrace();
        }
        try(PrintWriter writer = new PrintWriter(new File("src/resources/session/logIn/SessionPassword.txt"))){
            writer.println(passwordClient);
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
