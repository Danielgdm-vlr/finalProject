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
import model.Diets;
import model.Gyms;
import model.Trainers;
import services.DietService;
import services.GymService;
import services.TrainerService;

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
    private Button buttonNextPageMembership;

    public void initialize(){
        buttonNextPageMembership.setDisable(true);

        //to see all the trainers in the comboBox
        TrainerService trainerService = new TrainerService();
        List<Trainers> trainersList = trainerService.getAllTrainers();
        /*if no trainer is found, the list size is 0, and an alert message pops up, else the list gets all the trainers
        and it displays them on the screen in a comboBox*/
        if(trainersList.size() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no trainers at the gyms!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectTrainer.setItems(null);
        }
        else
            comboBoxSelectTrainer.setItems(FXCollections.observableArrayList(trainersList));

        //to see all the gyms in the comboBox
        GymService gymService = new GymService();
        List<Gyms> gymsList = gymService.getAllGyms();
        /*if no gym is found, the list size is 0, and an alert message pops up, else the list gets all the gymLoc
        and it displays the gyms on the screen in a comboBox*/
        if (gymsList.size() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no gyms!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectGym.setItems(null);
        }
        else
            comboBoxSelectGym.setItems(FXCollections.observableArrayList(gymsList));

        //to see all the diets in the comboBox
        DietService dietService = new DietService();
        List<Diets> dietsList = dietService.getAllDiets();
        /*if no diet is found, the list size is 0, and an alert message pops up, else the list gets all the diets
        and it displays the dietMeal and dietCal on the screen in a comboBox*/
        if (gymsList.size() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no diets!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectDiet.setItems(null);
        }
        else
            comboBoxSelectDiet.setItems(FXCollections.observableArrayList(dietsList));
    }

    public void keyReleasedProperty(){
        boolean buttonDisabled = (comboBoxSelectDiet.getSelectionModel().isEmpty() ||
                                  comboBoxSelectGym.getSelectionModel().isEmpty() ||
                                  comboBoxSelectTrainer.getSelectionModel().isEmpty());
        buttonNextPageMembership.setDisable(buttonDisabled);
    }

    public void onClickGoToNextPage(){
        try {
            buttonNextPageMembership.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/resources/views/Membership2.fxml"));
            Stage m2Stage = new Stage();
            m2Stage.setScene(new Scene(root));
            m2Stage.setTitle("RAW POWER GYM - Create YOUR Membership!");
            m2Stage.show();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
