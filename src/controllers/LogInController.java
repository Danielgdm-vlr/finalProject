package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Users;
import services.UserService;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

public class LogInController {
    @FXML
    private Button buttonLogIn;
    @FXML
    private Hyperlink hyperlinkSignUp;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private CheckBox checkBoxVerifyHuman;

    public String un, pw;

    public void initialize(){
        buttonLogIn.setDisable(true);
    }

    public void keyReleasedProperty(){
        un = username.getText();
        pw = password.getText();
        boolean buttonDisable = (un.isEmpty() || un.trim().isEmpty() || pw.isEmpty() || pw.trim().isEmpty() ||
                                  !checkBoxVerifyHuman.isSelected());
        buttonLogIn.setDisable(buttonDisable);
    }

    public void onClickButtonLogIn(){
        UserService userService = new UserService();
        un = username.getText();
        pw = password.getText();
        try{
            if(userService.findUser(un, pw) != null){
                buttonLogIn.getScene().getWindow().hide();
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
                // incearca sa schimbi ifurile cu un HashMap ceva, in care value = userService.findUserId(un)
                    if (userService.findUserId(un) == 1) {
                            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
                            Stage dMStage = new Stage();
                            Scene sceneDM = new Scene(root);
                            sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardManagerStylesheet.css").toExternalForm());
                            dMStage.setTitle("RAW POWER GYM - Manager`s Dashboard");
                            dMStage.setScene(sceneDM);
                            dMStage.show();
                    }
                    if (userService.findUserId(un) == 2) {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardTrainer.fxml"));
                        Stage dTStage = new Stage();
                        Scene sceneDT = new Scene(root);
                        sceneDT.getStylesheets().add(getClass().getResource("/resources/css/DashboardTrainerStylesheet.css").toExternalForm());
                        dTStage.setTitle("RAW POWER GYM - Trainer`s Dashboard");
                        dTStage.setScene(sceneDT);
                        dTStage.show();
                    }
                    if (userService.findUserId(un) == 3) {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardClient.fxml"));
                        Stage dCStage = new Stage();
                        Scene sceneDC = new Scene(root);
                        sceneDC.getStylesheets().add(getClass().getResource("/resources/css/DashboardClientStylesheet.css").toExternalForm());
                        dCStage.setScene(sceneDC);
                        dCStage.setTitle("RAW POWER GYM - Client`s Dashboard");
                        dCStage.show();
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void onClickHyperlinkSignUp() throws IOException {
        hyperlinkSignUp.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/SignUp.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setTitle("RAW POWER GYM - Sign Up");
        Scene signUpScene = new Scene(root);
        signUpScene.getStylesheets().add(getClass().getResource("/resources/css/SignUpStylesheet.css").toExternalForm());
        signUpStage.setScene(signUpScene);
        signUpStage.show();
    }

    public void onClickHyperlinkMe(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {}
    }

}

