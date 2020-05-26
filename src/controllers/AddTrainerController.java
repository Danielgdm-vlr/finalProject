package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Trainers;
import model.Users;
import services.TrainerService;
import services.UserService;


public class AddTrainerController {
    @FXML
    private Button buttonSignTrainerIn;
    @FXML
    private Hyperlink hyperlinkBackToDashboard;
    @FXML
    private CheckBox checkBoxVerifyHuman;
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
        boolean vH = checkBoxVerifyHuman.isSelected();
        boolean bln = (fn.isEmpty() || fn.trim().isEmpty() || ln.isEmpty() || ln.trim().isEmpty()
                || em.isEmpty() || em.trim().isEmpty() || no.isEmpty() || no.trim().isEmpty()
                || ag.trim().isEmpty() || ag.isEmpty() || un.trim().isEmpty() || un.isEmpty()
                || pw.isEmpty() || pw.trim().isEmpty() || cpw.isEmpty() || cpw.trim().isEmpty()
                || !pw.equals(cpw) || !vH);
        buttonSignTrainerIn.setDisable(bln);
    }

    public void onClickGoBackToMainDashboard() throws Exception {
        hyperlinkBackToDashboard.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
        Stage dashboardManager = new Stage();
        dashboardManager.setScene(new Scene(root));
        dashboardManager.setTitle("RAW POWER GYM - Manager`s Dashboard");
        dashboardManager.show();
    }

    public void onClickSignTrainerIn() throws Exception {
        buttonSignTrainerIn.getScene().getWindow().hide();
        Trainers trainer = new Trainers();
        TrainerService trainerService = new TrainerService();
        trainer.setfNameT(fName.getText());
        trainer.setlNameT(lName.getText());
        trainerService.addTrainer(trainer);

        Trainers trainers1 = trainerService.findTrainer(fName.getText());
        System.out.println(trainer);

        UserService userService = new UserService();
        Users user = new Users();
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setTrainerId(trainers1.getTrainerId());

        try {
            userService.addUser(user);
            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
            Stage dMStage = new Stage();
            dMStage.setTitle("RAW POWER GYM - Manager`s Dashboard");
            dMStage.setScene(new Scene(root));
            dMStage.show();
        }catch (Exception e){
            System.out.println("SDasD");
        }
    }
}
