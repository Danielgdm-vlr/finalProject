package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Clients;
import model.Membership;
import model.Trainers;
import model.Users;
import services.ClientService;
import services.MembershipService;
import services.TrainerService;
import services.UserService;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DashboardTrainerController {
    @FXML
    private Hyperlink hyperlinkSignOut;
    @FXML
    private Hyperlink hyperlinkChangeDietAndExercisePlan;
    @FXML
    private ListView<Clients> clientsListView;
    @FXML
    private Label trainerName;

    public void initialize() throws Exception {
        Trainers trainers = getTrainer();
        trainerName.setText(" " + trainers.getFirstNameTrainer() + " " + trainers.getLastNameTrainer());
        List<Clients> clientsList = getSpecificClients();
        if(clientsList.size() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no clients registered at the gyms!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            clientsListView.setItems(null);
        }
        else {
            clientsListView.setItems(FXCollections.observableArrayList(new ArrayList<>(clientsList)));
        }
    }

    public void onClickHyperlinkSignOut() throws IOException {
        hyperlinkSignOut.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/LogIn.fxml"));
        Stage logInStage = new Stage();
        Scene logInScene = new Scene(root);
        logInScene.getStylesheets().add(getClass().getResource("/resources/css/LogInStylesheet.css").toExternalForm());
        logInStage.setTitle("RAW POWER GYM - Log In");
        logInStage.setScene(logInScene);
        logInStage.show();
    }

    public void onClickHyperlinkChangeDietAndExercisePlan() throws IOException {
        hyperlinkChangeDietAndExercisePlan.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/ChangeDietAndExercises.fxml"));
        Stage changeStage = new Stage();
        Scene changeScene = new Scene(root);
        changeScene.getStylesheets().add(getClass().getResource("/resources/css/ChangeDietAndExercisesStylesheet.css").toExternalForm());
        changeStage.setTitle("RAW POWER GYM - Log In");
        changeStage.setScene(changeScene);
        changeStage.show();
    }


    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
    }

    public Users getUser() throws Exception{
        String username = getUsername();
        UserService userService = new UserService();
        return userService.findUserDashboard(username);
    }

    public Trainers getTrainer() throws Exception{
        Users user = getUser();
        TrainerService trainerService = new TrainerService();
        return trainerService.findTrainerId(user.getIdTrainer());
    }

    public List<Membership> getSpecificMemberships() throws Exception{
        MembershipService membershipService = new MembershipService();
        Membership membership;
        Trainers trainers = getTrainer();
        List<Membership> membershipList = membershipService.getAllMemberships();
        List<Membership> membershipList1 = new ArrayList<>();
        for (Membership value : membershipList) {
            membership = value;
            if (membership.getIdTrainer() == trainers.getIdTrainer()) {
                membershipList1.add(membership);
            }
        }
        return membershipList1;
    }

    public List<Clients> getSpecificClients() throws Exception{
        List<Membership> membershipList = getSpecificMemberships();
        Membership membership;
        List<Clients> clientsList = new ArrayList<>();
        ClientService clientService = new ClientService();
        for (Membership value : membershipList) {
            membership = value;
            if (clientService.findClientId(membership.getIdMembership()) != null) {
                clientsList.add(clientService.findClientId(membership.getIdMembership()));
            }
        }
        return clientsList;
    }

    public String getUsername(){
        String username = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/login/SessionUsername.txt"))){
            String usernameTmp;
            while((usernameTmp = br.readLine()) != null)
                username = usernameTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return username;
    }
}
