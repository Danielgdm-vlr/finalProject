package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Clients;
import model.Users;
import services.ClientService;
import services.UserService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DashboardClientController {
    @FXML
    private Hyperlink hyperlinkSignOut;
    @FXML
    private Label clientName;

    public void initialize() throws Exception {
        //get the user
        String username = getUsername();
        UserService userService = new UserService();
        Users user = userService.findU(username);
        System.out.println(user);
        //get the client
        String name = getFName();
        ClientService clientService = new ClientService();
        Clients client = clientService.findClient(name);
        System.out.println(client);
        //show details about them
        clientName.setText(client.getfNameC());
    }

    public void onClickHyperlinkSignOut() throws IOException {
        hyperlinkSignOut.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/LogIn.fxml"));
        Stage logInStage = new Stage();
        logInStage.setTitle("RAW POWER GYM - Log In");
        logInStage.setScene(new Scene(root));
        logInStage.show();
    }

    public String getUsername(){
        String username = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionUsername.txt"))){
            String usernameTmp;
            while((usernameTmp = br.readLine()) != null)
                username = usernameTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return username;
    }

    public String getFName() {
        String fn = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionSignUpFirstName.txt"))) {
            String usernameTmp;
            while ((usernameTmp = br.readLine()) != null)
                fn = usernameTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fn;
    }

}
