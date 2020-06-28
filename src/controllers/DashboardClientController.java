package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.*;
import services.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class DashboardClientController {
    @FXML
    private Hyperlink hyperlinkSignOut;
    @FXML
    private Label welcomeLabelClient, usernameClient, trainerNameClient, gymClient,  dietPlan, exercisesPlan;
    @FXML
    private Label firstNameClient, lastNameClient, emailClient, telephoneNumberClient, ageClient;
    //'future update'
    //@FXML
    //private Button buttonGiveFeedback;

    public void initialize() throws Exception {
        /*firstTab: "Your account": show on screen details about the client`s membership: the gym he goes to, his trainer`s name, his diet plan and his exercise plan
         and about his user account: username and password */
        welcomeLabelClient.setText(" " + getUsernameClient());
        usernameClient.setText(" " + getUsernameClient());
        gymClient.setText(" " + getGymClient());
        trainerNameClient.setText(" " + getTrainerNameClient());
        dietPlan.setText(" " + getDietPlan());
        exercisesPlan.setText(" " + getExercisesPlan());

        //secondTab: "Give Feedback": 'future update'

        /*thirdTab: "Personal info": show on screen details about the client: first name, last name, his email address, his telephone number and his age */
        firstNameClient.setText(getFirstNameClient());
        lastNameClient.setText(getLastNameClient());
        emailClient.setText(getEmailClient());
        telephoneNumberClient.setText(getTelephoneNumberClient());
        ageClient.setText(getAgeClient());
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

    public void onClickButtonGiveFeedback(){
        //'future update'
    }

    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
    }

    public Membership getMembership() throws Exception {
        ClientService clientService = new ClientService();
        Clients clients = clientService.findClient(getFirstNameClient());
        MembershipService membershipService = new MembershipService();
        return membershipService.findMembership(clients.getIdMembership());
    }

    public String getGymClient() throws Exception {
        Membership membership = getMembership();
        GymService gymService = new GymService();
        Gyms gyms = gymService.findGymId(membership.getIdGym());
        return gyms.getGymLocation();
    }

    public String getTrainerNameClient() throws Exception{
        Membership membership = getMembership();
        TrainerService trainerService = new TrainerService();
        Trainers trainers = trainerService.findTrainerId(membership.getIdTrainer());
        return trainers.getFirstNameTrainer() + " " + trainers.getLastNameTrainer();
    }

    public String getDietPlan() throws Exception{
        Membership membership = getMembership();
        DietService dietService = new DietService();
        Diets diet = dietService.findDietId(membership.getIdDiet());
        return diet.getDietMeals() + " " + diet.getDietCalories() + " Cal.";
    }

    public String getExercisesPlan()throws Exception{
        Membership membership = getMembership();
        ExercisesService exercisesService = new ExercisesService();
        Exercises exercises = exercisesService.findExerciseId(membership.getIdExercise());
        return exercises.getExerciseName();
    }

    public String getUsernameClient(){
        String username = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/logIn/SessionUsername.txt"))){
            String usernameTmp;
            while((usernameTmp = br.readLine()) != null)
                username = usernameTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return username;
    }

    public Clients getClient() throws Exception {
        String usernameTmp = getUsernameClient();
        UserService userService = new UserService();
        Users users = userService.findUserDashboard(usernameTmp);
        ClientService clientService = new ClientService();
        return clientService.findClientId(users.getIdClient());
    }

    //'future update'
    /*public String getPasswordClient(){
        String password = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/logIn/SessionPassword.txt"))){
            String passwordTmp;
            while((passwordTmp = br.readLine()) != null)
                password = passwordTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return password;
    }*/

    public String getFirstNameClient() throws Exception {
        Clients clients = getClient();
        return clients.getFirstNameClient();
    }

    public String getLastNameClient() throws Exception {
        Clients clients = getClient();
        return clients.getLastNameClient();
    }

    public String getEmailClient() throws Exception {
        Clients clients = getClient();
        return clients.getEmailClient();
    }

    public String getTelephoneNumberClient() throws Exception {
        Clients clients = getClient();
        return clients.getTelephoneNumberClient();
    }

    public String getAgeClient() throws Exception {
        Clients clients = getClient();
        return clients.getAgeClient();
    }
}
