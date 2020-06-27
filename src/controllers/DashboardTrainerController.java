package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;
import services.*;

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
    private ListView<Clients> clientsListView;
    @FXML
    private Label trainerName;

    public void initialize() throws Exception {
        Trainers trainers = getTrainer();
        trainerName.setText(" " + trainers.getFirstNameTrainer() + " " + trainers.getLastNameTrainer());
        List<Clients> clientsList = getSpecificClients();
        clientsListView.setItems(FXCollections.observableArrayList(new ArrayList<Clients>(clientsList)));
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

    public void onClickHyperlinkMe(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {}
    }

    public Users getUser() throws Exception{
        String username = getUsername();
        UserService userService = new UserService();
        Users user = userService.findUserDashboard(username);
        return user;
    }

    public Trainers getTrainer() throws Exception{
        Users user = getUser();
        TrainerService trainerService = new TrainerService();
        Trainers trainer = trainerService.findTrainerId(user.getIdTrainer());
        return trainer;
    }

    public List<Membership> getSpecificMemberships() throws Exception{
        MembershipService membershipService = new MembershipService();
        Membership membership;
        Trainers trainers = getTrainer();
        List<Membership> membershipList = membershipService.getAllMemberships();
        List<Membership> membershipList1 = new ArrayList<Membership>();
        for(int i = 0; i < membershipList.size(); i++){
            membership = membershipList.get(i);
            if(membership.getIdTrainer() == trainers.getIdTrainer()){
                   membershipList1.add(membership);
            }
        }
        return membershipList1;
    }

    public List<Clients> getSpecificClients() throws Exception{
        List<Membership> membershipList = getSpecificMemberships();
        Membership membership;
        List<Clients> clientsList = new ArrayList<Clients>();
        ClientService clientService = new ClientService();
        for(int i = 0; i < membershipList.size(); i++) {
            membership = membershipList.get(i);
            if(clientService.findClientId(membership.getIdMembership()) != null){
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
