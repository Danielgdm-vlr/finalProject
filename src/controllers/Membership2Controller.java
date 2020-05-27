package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.Exes;
import model.Trainers;
import services.ExesService;

import java.util.List;

public class Membership2Controller {
    @FXML
    private ComboBox comboBoxSelectEx;
    @FXML
    private Button buttonFinish;

    public void initialize(){
        buttonFinish.setDisable(true);

        //to see all the ex in the comboBox
        ExesService exesService = new ExesService();
        List<Exes> exesList = exesService.getAllEx();
        /*if no ex is found, the list size is 0, and an alert message pops up, else the list gets all the ex
        and it displays the ex on the screen in a comboBox*/
        if(exesList.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Currently there are no trainers at the gyms!");
            alert.setTitle("opsie dopsie :S");
            alert.setHeaderText(null);
            alert.show();
            comboBoxSelectEx.setItems(null);
        }
        else
            comboBoxSelectEx.setItems(FXCollections.observableArrayList(exesList));
    }
    public void onClickButtonFinish(){}

    public void keyReleasedProperty(){
        buttonFinish.setDisable(comboBoxSelectEx.getSelectionModel().isEmpty());
    }
}
