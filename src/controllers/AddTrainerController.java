package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Trainers;
import model.Users;
import services.TrainerService;
import services.UserService;

import java.awt.*;
import java.net.URL;


public class AddTrainerController {
    @FXML
    private Button buttonSignTrainerIn;
    @FXML
    private Hyperlink hyperlinkBackToDashboard;
    @FXML
    private TextField firstNameTrainer, lastNameTrainer, emailTrainer, telephoneNumberTrainer, ageTrainer, usernameTrainer, passwordTrainer;
    @FXML
    private PasswordField confirmPassword;


    public void keyReleasedProperty()  {
        String usernameTrainerText = usernameTrainer.getText();
        String passwordTrainerText = passwordTrainer.getText();
        String firstNameTrainerText = firstNameTrainer.getText();
        String lastNameTrainerText = lastNameTrainer.getText();
        String confirmPasswordText = confirmPassword.getText();
        String emailTrainerText = emailTrainer.getText();
        String telephoneNumberTrainerText = telephoneNumberTrainer.getText();
        String ageTrainerText = ageTrainer.getText();
        boolean bln = (isNullOrEmpty(usernameTrainerText, passwordTrainerText, firstNameTrainerText, lastNameTrainerText,
                        confirmPasswordText, emailTrainerText, telephoneNumberTrainerText, ageTrainerText)
                       || !passwordTrainerText.equals(confirmPasswordText));
        buttonSignTrainerIn.setDisable(bln);
    }

    //method to check if there is text in every textfield, so the button for different task may be setDisable("false")
    public static boolean isNullOrEmpty(String... strArr) {
        for (String st : strArr) {
            if  (st==null || st.equals(""))
                return true;

        }
        return false;
    }

    public void onClickGoBackToMainDashboard() throws Exception {
        hyperlinkBackToDashboard.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
        Stage dashboardManager = new Stage();
        Scene sceneDM = new Scene(root);
        sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardManagerStylesheet.css").toExternalForm());
        dashboardManager.setScene(sceneDM);
        dashboardManager.setTitle("RAW POWER GYM - Manager`s Dashboard");
        dashboardManager.show();
    }

    public void onClickSignTrainerIn() throws Exception {
        buttonSignTrainerIn.getScene().getWindow().hide();
        Trainers trainer = new Trainers();
        TrainerService trainerService = new TrainerService();
        trainer.setFirstNameTrainer(firstNameTrainer.getText());
        trainer.setLastNameTrainer(lastNameTrainer.getText());
        trainer.setEmailTrainer(emailTrainer.getText());
        trainer.setTelephoneNumberTrainer(telephoneNumberTrainer.getText());
        trainer.setAgeTrainer(ageTrainer.getText());
        trainerService.addTrainer(trainer);

        Trainers trainersUser = trainerService.findTrainer(firstNameTrainer.getText());

        UserService userService = new UserService();
        Users user = new Users();
        user.setUsername(usernameTrainer.getText());
        user.setPassword(passwordTrainer.getText());
        user.setIdTrainer(trainersUser.getIdTrainer());
        try {
            userService.addUser(user);
            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
            Stage dMStage = new Stage();
            Scene sceneDM = new Scene(root);
            sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardManagerStylesheet.css").toExternalForm());
            dMStage.setTitle("RAW POWER GYM - Manager`s Dashboard");
            dMStage.setScene(sceneDM);
            dMStage.show();
            //change with a message on screen
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The trainer was successfully added up!");
            alert.setTitle("Hurray!");
            alert.setHeaderText(null);
            alert.show();
        }catch (Exception e){
            System.out.println("The trainer wasn`t added up!");
        }
    }

    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
    }
}
