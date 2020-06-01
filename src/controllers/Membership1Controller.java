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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Membership1Controller {

    @FXML
    private ComboBox comboBoxSelectGym;
    @FXML
    private ComboBox comboBoxSelectTrainer;
    @FXML
    private ComboBox comboBoxSelectDiet;
    @FXML
    private ComboBox comboBoxSelectEx;
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
        ExesService exesService = new ExesService();
        List<Exes> exesList = exesService.getAllEx();
        /*if no ex is found, the list size is 0, and an alert message pops up, else the list gets all the ex
        and it displays the exName and on the screen in a comboBox*/
        if (exesList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no exercises!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectEx.setItems(null);
        } else
            comboBoxSelectEx.setItems(FXCollections.observableArrayList(exesList));
    }

    public void keyReleasedProperty() {
        boolean buttonDisabled = (comboBoxSelectDiet.getSelectionModel().isEmpty() ||
                comboBoxSelectGym.getSelectionModel().isEmpty() ||
                comboBoxSelectTrainer.getSelectionModel().isEmpty() ||
                comboBoxSelectEx.getSelectionModel().isEmpty());
        buttonFinish.setDisable(buttonDisabled);
    }

    public void onClickButtonFinish() throws Exception {
        Membership membership = new Membership();
        membership.setGymId((comboBoxSelectGym.getSelectionModel().getSelectedIndex() + 1));
        membership.setTrainerId((comboBoxSelectTrainer.getSelectionModel().getSelectedIndex() + 1));
        membership.setDietId((comboBoxSelectDiet.getSelectionModel().getSelectedIndex() + 1));
        membership.setExesId((comboBoxSelectEx.getSelectionModel().getSelectedIndex() + 1));
        System.out.println(membership);

        MembershipService membershipService = new MembershipService();
        membershipService.addMembership(membership);

        List<Membership> membershipList = membershipService.getAllMemberships();
        Membership membership1 = membershipList.get(membershipList.size() - 1);

        Clients client = new Clients();
        ClientService clientService = new ClientService();
        client.setfNameC(getFName());
        client.setlNameC(getLName());
        client.setEmailC(getEmail());
        client.setTelNoC(getTelNo());
        client.setAgeC(getAge());
        client.setMembershipId(membership1.getMembershipId());
        clientService.addClient(client);

        Clients client1 = clientService.findClient(getFName());
        System.out.println(client1);

        //put username and password in users table
        UserService userService = new UserService();
        Users user = new Users();
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setClientId(client1.getClientId());
        userService.addUser(user);
        System.out.println(user);
        try {
            buttonFinish.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardClient.fxml"));
            Stage m2Stage = new Stage();
            m2Stage.setScene(new Scene(root));
            m2Stage.setTitle("RAW POWER GYM - Create YOUR Membership!");
            m2Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public String getLName() {
        String ln = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionSignUpLastName.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                ln = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ln;
    }

    public String getEmail() {
        String em = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionSignUpEmail.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                em = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return em;
    }

    public String getTelNo() {
        String tn = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionSignUpTelNo.txt"))) {
            String passwordTmp;
            while ((passwordTmp = br.readLine()) != null)
                tn = passwordTmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tn;
    }

    public String getAge() {
        String ag = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionSignUpAge.txt"))) {
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
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionUsername.txt"))){
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
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/session/SessionPassword.txt"))){
            String passwordTmp;
            while((passwordTmp = br.readLine()) != null)
                password = passwordTmp;
        }catch (Exception e){
            e.printStackTrace();
        }
        return password;
    }
}
