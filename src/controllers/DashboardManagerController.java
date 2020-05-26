package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardManagerController {
    @FXML
    private Button buttonSeeGyms, buttonAddTrainer, buttonSeeClientsFeedback, buttonTotalWorkingHours;

    public void onClickButtonSeeGyms(){

    }

    public void onClickButtonAddTrainer() throws IOException {
        buttonAddTrainer.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/AddTrainer.fxml"));
        Stage addTrainerStage = new Stage();
        addTrainerStage.setTitle("RAW POWER GYM - Manager`s Dashboard / Add a new trainer to the gym!");
        addTrainerStage.setScene(new Scene(root));
        addTrainerStage.setFullScreen(true);
        addTrainerStage.show();
    }

    public void onClickButtonSeeClientsFeedback(){

    }

    public void onClickButtonSeeTotalWorkingHours(){

    }
}
