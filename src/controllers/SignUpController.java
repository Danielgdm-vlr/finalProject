package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Clients;
import model.Ex;
import model.Users;
import services.ClientService;
import services.UserService;

import java.io.IOException;

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

    public void initialize(){
        buttonSignUp.setDisable(true);
    }

    public void keyReleasedProperty(){
        String fN = fName.getText();
        String lN = lName.getText();
        String em = email.getText();
        String tN = telNo.getText();
        String ag = age.getText();
        String un = username.getText();
        String pw = password.getText();
        String cpw = confirmPassword.getText();
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
        logInStage.setTitle("RAW POWER GYM - Log In");
        logInStage.setScene(new Scene(root));
        logInStage.show();
    }

    public void onClickButtonSignUp() throws Exception {
        buttonSignUp.getScene().getWindow().hide();
        Clients client = new Clients();
        ClientService clientService = new ClientService();
        client.setfNameC(fName.getText());
        client.setlNameC(lName.getText());
        clientService.addClient(client);

        Clients client1 = clientService.findClient(fName.getText());
        System.out.println(client1);

        UserService userService = new UserService();
        Users user = new Users();
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setTrainerId(client1.getClientId());

        try {
            userService.addUser(user);
            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardClient.fxml"));
            Stage dMStage = new Stage();
            dMStage.setTitle("RAW POWER GYM - Client`s Dashboard");
            dMStage.setScene(new Scene(root));
            dMStage.show();
        }catch (Exception e){
            System.out.println("SDasD");
        }

    }
}
