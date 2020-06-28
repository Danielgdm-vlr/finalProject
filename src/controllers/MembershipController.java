package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.*;
import services.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MembershipController {

    @FXML
    private ComboBox<Gyms> comboBoxSelectGym;
    @FXML
    private ComboBox<Trainers> comboBoxSelectTrainer;
    @FXML
    private ComboBox<Diets> comboBoxSelectDiet;
    @FXML
    private ComboBox<Exercises> comboBoxSelectExercises;
    @FXML
    private Button buttonFinish;

    public void initialize() {
        buttonFinish.setDisable(true);

        //to see all the trainers in the comboBox
        TrainerService trainerService = new TrainerService();
        List<Trainers> trainersList = trainerService.getAllTrainers();
        /*if no trainer is found, the list size is 0, and an alert message pops up, else the list gets all the trainers
        and it displays them on the screen in a comboBox*/
        if (trainersList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no trainers at the gyms!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectTrainer.setItems(null);
        } else
            comboBoxSelectTrainer.setItems(FXCollections.observableArrayList(trainersList));

        //to see all the gyms in the comboBox
        GymService gymService = new GymService();
        List<Gyms> gymsList = gymService.getAllGyms();
        /*if no gym is found, the list size is 0, and an alert message pops up, else the list gets all the gymLoc
        and it displays the gyms on the screen in a comboBox*/
        if (gymsList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no gyms!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectGym.setItems(null);
        } else
            comboBoxSelectGym.setItems(FXCollections.observableArrayList(gymsList));

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
            comboBoxSelectDiet.setItems(null);
        } else
            comboBoxSelectDiet.setItems(FXCollections.observableArrayList(dietsList));
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
            comboBoxSelectExercises.setItems(null);
        } else
            comboBoxSelectExercises.setItems(FXCollections.observableArrayList(exesList));
    }

    public void keyReleasedProperty() {
        boolean buttonDisabled = (isSelected(comboBoxSelectGym.getSelectionModel().isEmpty(), comboBoxSelectTrainer.getSelectionModel().isEmpty(),
                                     comboBoxSelectDiet.getSelectionModel().isEmpty() || comboBoxSelectExercises.getSelectionModel().isEmpty()));
        buttonFinish.setDisable(buttonDisabled);
    }

    //method to check if there is text in every comboBoxes(booleans), so the button for different task may be setDisable("false")
    public static boolean isSelected(boolean... booleanArr) {
        for (boolean bln : booleanArr) {
            if  (bln)
                return true;

        }
        return false;
    }

    public void onClickButtonFinish() throws Exception {
        Membership membership = new Membership();
        membership.setIdGym((comboBoxSelectGym.getSelectionModel().getSelectedIndex() + 1));
        membership.setIdTrainer((comboBoxSelectTrainer.getSelectionModel().getSelectedIndex() + 1));
        membership.setIdDiet((comboBoxSelectDiet.getSelectionModel().getSelectedIndex() + 1));
        membership.setIdExercise((comboBoxSelectExercises.getSelectionModel().getSelectedIndex() + 1));
        System.out.println(membership);

        MembershipService membershipService = new MembershipService();
        membershipService.addMembership(membership);

        List<Membership> membershipClientList = membershipService.getAllMemberships();
        Membership membershipClient = membershipClientList.get(membershipClientList.size() - 1);

        Clients client = new Clients();
        ClientService clientService = new ClientService();
        client.setFirstNameClient(getFirstNameClient());
        client.setLastNameClient(getLastNameClient());
        client.setEmailClient(getEmailClient());
        client.setTelephoneNumberClient(getTelephoneNumberClient());
        client.setAgeClient(getAgeClient());
        client.setIdMembership(membershipClient.getIdMembership());
        clientService.addClient(client);

        Clients clientUser = clientService.findClient(getFirstNameClient());
        System.out.println(clientUser);

        //put username and password in users table
        UserService userService = new UserService();
        Users user = new Users();
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setIdClient(clientUser.getIdClient());
        userService.addUser(user);
        System.out.println(user);
        try {
            buttonFinish.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardClient.fxml"));
            Stage mStage = new Stage();
            Scene sceneM = new Scene(root);
            sceneM.getStylesheets().add(getClass().getResource("/resources/css/DashboardClientStylesheet.css").toExternalForm());
            mStage.setScene(sceneM);
            mStage.setTitle("RAW POWER GYM - Create YOUR Membership!");
            mStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
    }

    public String getFirstNameClient() {
        String fn = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signUp/SessionSignUpFirstName.txt"))) {
            String usernameTmp;
            while ((usernameTmp = br.readLine()) != null)
                fn = usernameTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fn;
    }

    public String getLastNameClient() {
        String ln = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signUp/SessionSignUpLastName.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                ln = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ln;
    }

    public String getEmailClient() {
        String em = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signUp/SessionSignUpEmail.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                em = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em;
    }

    public String getTelephoneNumberClient() {
        String tn = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signUp/SessionSignUpTelNo.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                tn = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tn;
    }

    public String getAgeClient() {
        String ag = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/signUp/SessionSignUpAge.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                ag = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ag;
    }

    public String getUsername(){
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

    public String getPassword(){
        String password = null;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/logIn/SessionPassword.txt"))){
            String passwordTmp;
            while((passwordTmp = br.readLine()) != null)
                password = passwordTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return password;
    }
}
