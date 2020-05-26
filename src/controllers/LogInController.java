package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Users;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import services.UserService;

import java.io.IOException;
import java.util.List;

public class LogInController {
    @FXML
    private Button buttonLogIn;
    @FXML
    private Button buttonSignUp;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox checkBoxVerifyHuman;

    public void initialize(){
        buttonLogIn.setDisable(true);
    }

    public void keyReleasedProperty(){
        String un = username.getText();
        String pw = password.getText();
        boolean buttonDisable = (un.isEmpty() || un.trim().isEmpty() || pw.isEmpty() || pw.trim().isEmpty() ||
                                  !checkBoxVerifyHuman.isSelected());
        buttonLogIn.setDisable(buttonDisable);
    }

    public void onClickButtonLogIn(){
        UserService userService = new UserService();
        String un = username.getText();
        String pw = password.getText();
        try{
           //System.out.println(userService.findUser(un, pw));
            if(userService.findUser(un, pw) != null){
                buttonLogIn.getScene().getWindow().hide();
                    if (userService.findUserId(un) == 1) {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
                        Stage dMStage = new Stage();
                        dMStage.setTitle("RAW POWER GYM - Manager`s Dashboard");
                        dMStage.setScene(new Scene(root));
                        dMStage.show();
                    }
                    if (userService.findUserId(un) == 2) {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardTrainer.fxml"));
                        Stage dTStage = new Stage();
                        dTStage.setTitle("RAW POWER GYM - Trainer`s Dashboard");
                        dTStage.setScene(new Scene(root));
                        dTStage.show();
                    }
                    if (userService.findUserId(un) == 3) {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardClient.fxml"));
                        Stage dCStage = new Stage();
                        dCStage.setTitle("RAW POWER GYM - Client`s Dashboard");
                        dCStage.setScene(new Scene(root));
                        dCStage.show();
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void onClickButtonSignUp() throws IOException {
        buttonSignUp.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/SignUp.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setTitle("RAW POWER GYM - Sign Up");
        signUpStage.setScene(new Scene(root));
        signUpStage.show();
    }
}

