package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.UserService;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

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

    public String usernameString, passwordString;

    public void initialize(){
        buttonLogIn.setDisable(true);
    }

    public void keyReleasedProperty(){
        usernameString = username.getText();
        passwordString = password.getText();
        boolean buttonDisable = (usernameString.isEmpty() || usernameString.trim().isEmpty() || passwordString.isEmpty() || passwordString.trim().isEmpty() ||
                                  !checkBoxVerifyHuman.isSelected());
        buttonLogIn.setDisable(buttonDisable);
    }

    public void onClickButtonLogIn(){
        UserService userService = new UserService();
        usernameString = username.getText();
        passwordString = password.getText();
        try{
            if(userService.findUser(usernameString, passwordString) != null){
                buttonLogIn.getScene().getWindow().hide();
                try(PrintWriter writer = new PrintWriter(new File("src/resources/session/login/SessionUsername.txt"))){
                    writer.println(usernameString);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                try(PrintWriter writer = new PrintWriter(new File("src/resources/session/login/SessionPassword.txt"))){
                        writer.println(passwordString);
                }catch (Exception e){
                        e.printStackTrace();
                }
                //try to change to 3 ifs to a HaspMap or something
                    if (userService.findUserId(usernameString) == 1) {
                            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
                            Stage dMStage = new Stage();
                            Scene sceneDM = new Scene(root);
                            sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardManagerStylesheet.css").toExternalForm());
                            dMStage.setTitle("RAW POWER GYM - Manager`s Dashboard");
                            dMStage.setScene(sceneDM);
                            dMStage.show();
                    }
                    if (userService.findUserId(usernameString) == 2) {
                        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardTrainer.fxml"));
                        Stage dTStage = new Stage();
                        Scene sceneDT = new Scene(root);
                        sceneDT.getStylesheets().add(getClass().getResource("/resources/css/DashboardTrainerStylesheet.css").toExternalForm());
                        dTStage.setTitle("RAW POWER GYM - Trainer`s Dashboard");
                        dTStage.setScene(sceneDT);
                        dTStage.show();
                    }
                    if (userService.findUserId(usernameString) == 3) {
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

    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
    }

}

