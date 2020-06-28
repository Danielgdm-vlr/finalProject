package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.*;
import services.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ChangeDietAndExercisesController {
    @FXML
    private Hyperlink hyperlinkBackToDashboard;
    @FXML
    private ComboBox<Clients> comboBoxSelectClient;
    @FXML
    private ComboBox<Diets> comboBoxChangeDiet;
    @FXML
    private ComboBox<Exercises> comboBoxChangeExercisePlan;
    @FXML
    private Label labelClientsName1, labelClientsName2, labelClientsDiet, labelClientsExercisePlan;
    @FXML
    private Button buttonUpdate;

    public void initialize() throws Exception {
        buttonUpdate.setDisable(true);
        //to see all the clients that have membership to this specific trainer in the comboBox
        List<Clients> clientsList = getSpecificClients();
        /*if no trainer is found, the list size is 0, and an alert message pops up, else the list gets all the trainers
        and it displays them on the screen in a comboBox*/
        if (clientsList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no trainers at the gyms!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectClient.setItems(null);
        } else
            comboBoxSelectClient.setItems(FXCollections.observableArrayList(clientsList));
        comboBoxChangeDiet.setDisable(true);
        comboBoxChangeExercisePlan.setDisable(true);
    }

    public void keyReleasedProperty() throws Exception {
        comboBoxChangeDiet.setDisable(false);
        //to see all the diets in the comboBox
        DietService dietService = new DietService();
        List<Diets> dietsList = dietService.getAllDiets();
        /*if no diet is found, the list size is 0, and an alert message pops up, else the list gets all the diets
        and it displays the dietMeal and dietCal on the screen in a comboBox*/
        if (dietsList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no diets!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();

            comboBoxChangeDiet.setItems(null);
        } else
            comboBoxChangeDiet.setItems(FXCollections.observableArrayList(dietsList));

        comboBoxChangeExercisePlan.setDisable(false);
        //to see all the ex in the comboBox
        ExercisesService exercisesService = new ExercisesService();
        List<Exercises> exesList = exercisesService.getAllExercises();
        /*if no ex is found, the list size is 0, and an alert message pops up, else the list gets all the ex
        and it displays the exName and on the screen in a comboBox*/
        if (exesList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no exercises!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxChangeExercisePlan.setItems(null);
        } else
            comboBoxChangeExercisePlan.setItems(FXCollections.observableArrayList(exesList));
        labelClientsName1.setText(getClient() + "`s");
        labelClientsName2.setText(getClient() + "`s");
        labelClientsDiet.setText(getDiet());
        labelClientsExercisePlan.setText(getExercisePlan());
    }

    public void keyReleasedProperty2(){
        boolean buttonDisabled = (comboBoxChangeDiet.getSelectionModel().isEmpty() &&
                                  comboBoxChangeExercisePlan.getSelectionModel().isEmpty());
        buttonUpdate.setDisable(buttonDisabled);

    }

    public void updateDiet() throws Exception {
        //update diet for the specific client
        Diets diets = getNewDiet();
        int idDiet = diets.getIdDiet();
        MembershipService membershipService = new MembershipService();
        Membership membership = membershipService.findMembership(getMembership());
        membership.setIdDiet(idDiet);
        membershipService.updateMembership(membership);
    }

    public void updateExercisePlan() throws Exception {
        //update exercises for the specific client
        Exercises exercises = getNewExercisePlan();
        int idDiet = exercises.getIdExercise();
        MembershipService membershipService = new MembershipService();
        Membership membership = membershipService.findMembership(getMembership());
        membership.setIdDiet(idDiet);
        membershipService.updateMembership(membership);
    }

    public void onClickButtonUpdate() throws Exception {
        buttonUpdate.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardTrainer.fxml"));
        Stage dashboardManager = new Stage();
        Scene sceneDM = new Scene(root);
        sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardTrainerStylesheet.css").toExternalForm());
        dashboardManager.setScene(sceneDM);
        dashboardManager.setTitle("RAW POWER GYM - Trainer`s Dashboard");
        dashboardManager.show();
        if(!comboBoxChangeDiet.getSelectionModel().isEmpty()){
            updateDiet();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The client`s diet was successfully changed!");
            alert.setTitle("Hurray!");
            alert.setHeaderText(null);
            alert.show();
        }
        if(!comboBoxChangeExercisePlan.getSelectionModel().isEmpty()){
            updateExercisePlan();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("The client`s exercise plan was successfully changed!");
            alert.setTitle("Hurray!");
            alert.setHeaderText(null);
            alert.show();
        }
    }

    public Diets getNewDiet(){
        return comboBoxChangeDiet.getSelectionModel().getSelectedItem();
    }

    public Exercises getNewExercisePlan(){
        return comboBoxChangeExercisePlan.getSelectionModel().getSelectedItem();
    }

    public String getClient(){
        Clients clients = comboBoxSelectClient.getSelectionModel().getSelectedItem();
        return clients.getFirstNameClient();
    }

    public int getMembership(){
        Clients clients = comboBoxSelectClient.getSelectionModel().getSelectedItem();
        return clients.getIdMembership();
    }

    public Membership findMembership() throws Exception {
        MembershipService membershipService = new MembershipService();
        return membershipService.findMembership(getMembership());
    }

    public String getDiet() throws Exception {
        Membership membership = findMembership();
        DietService dietService = new DietService();
        Diets diets = dietService.findDietId(membership.getIdDiet());
        return diets.getDietMeals() + " " + diets.getDietCalories();
    }

    public String getExercisePlan() throws Exception{
        Membership membership = findMembership();
        ExercisesService exercisesService = new ExercisesService();
        Exercises exercises = exercisesService.findExerciseId(membership.getIdExercise());
        return exercises.getExerciseName();
    }

    public void onClickGoBackToMainDashboard() throws Exception {
        hyperlinkBackToDashboard.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardTrainer.fxml"));
        Stage dashboardManager = new Stage();
        Scene sceneDM = new Scene(root);
        sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardTrainerStylesheet.css").toExternalForm());
        dashboardManager.setScene(sceneDM);
        dashboardManager.setTitle("RAW POWER GYM - Trainer`s Dashboard");
        dashboardManager.show();
    }

    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
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

}
