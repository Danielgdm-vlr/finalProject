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
    private TextField firstNameTextField, lastNameTextField, emailTextField, telephoneNumberTextField, ageTextField, usernameTextField, passwordTextField;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private CheckBox checkBoxVerifyHuman;

    private String firstNameClient;
    private String lastNameClient;
    private String emailClient;
    private String telephoneNumberClient;
    private String ageClient;
    private String usernameClient;
    private String passwordClient;

    public void initialize(){
        buttonSignUp.setDisable(true);
    }

    public void keyReleasedProperty(){
        firstNameClient = firstNameTextField.getText();
        lastNameClient = lastNameTextField.getText();
        emailClient = emailTextField.getText();
        telephoneNumberClient = telephoneNumberTextField.getText();
        ageClient = ageTextField.getText();
        usernameClient = usernameTextField.getText();
        passwordClient = passwordTextField.getText();
        String confirmPasswordClient = confirmPassword.getText();
        boolean buttonDisable = (isNullOrEmpty(firstNameClient, lastNameClient, emailClient, telephoneNumberClient, ageClient, usernameClient,
                                 passwordClient, confirmPasswordClient) ||
                                 !passwordClient.equals(confirmPasswordClient) || !checkBoxVerifyHuman.isSelected());
        buttonSignUp.setDisable(buttonDisable);
    }

    //method to check if there is text in every textfield, so the button for different task may be setDisable("false")
    public static boolean isNullOrEmpty(String... strArr) {
        for (String st : strArr) {
            if  (st==null || st.equals(""))
                return true;

        }
        return false;
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

    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
    }
}
