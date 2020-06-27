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
    private TextField fName, lName, email, telNo, age, username, password;
    @FXML
    private PasswordField confirmPassword;

    public void initialize(){

    }

    public void keyReleasedProperty()  {
        String un = username.getText();
        String pw = password.getText();
        String fn = fName.getText();
        String ln = lName.getText();
        String cpw = confirmPassword.getText();
        String em = email.getText();
        String no = telNo.getText();
        String ag = age.getText();
        boolean bln = (fn.isEmpty() || fn.trim().isEmpty() || ln.isEmpty() || ln.trim().isEmpty()
                || em.isEmpty() || em.trim().isEmpty() || no.isEmpty() || no.trim().isEmpty()
                || ag.trim().isEmpty() || ag.isEmpty() || un.trim().isEmpty() || un.isEmpty()
                || pw.isEmpty() || pw.trim().isEmpty() || cpw.isEmpty() || cpw.trim().isEmpty()
                || !pw.equals(cpw));
        buttonSignTrainerIn.setDisable(bln);
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
        trainer.setFirstNameTrainer(fName.getText());
        trainer.setLastNameTrainer(lName.getText());
        trainerService.addTrainer(trainer);

        Trainers trainers1 = trainerService.findTrainer(fName.getText());
        System.out.println(trainer);

        UserService userService = new UserService();
        Users user = new Users();
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setIdTrainer(trainers1.getIdTrainer());

        try {
            userService.addUser(user);
            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
            Stage dMStage = new Stage();
            Scene sceneDM = new Scene(root);
            sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardManagerStylesheet.css").toExternalForm());
            dMStage.setTitle("RAW POWER GYM - Manager`s Dashboard");
            dMStage.setScene(sceneDM);
            dMStage.show();
            //schimba doar cu un mesaj care apare pe ecran
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The trainer was successfully added up!");
            alert.setTitle("Hurray!");
            alert.setHeaderText(null);
            alert.show();
        }catch (Exception e){
            System.out.println("The trainer wasn`t added up!");
        }
    }

    public void onClickHyperlinkMe(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {}
    }
}
