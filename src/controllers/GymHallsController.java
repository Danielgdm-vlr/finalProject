package controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import model.Gyms;
import services.GymService;

import java.awt.*;
import java.net.URL;
import java.util.List;

public class GymHallsController {
    @FXML
    private Hyperlink hyperlinkBackToDashboard;
    @FXML
    private ComboBox<Gyms> comboBoxSeeGyms;

    public void initialize(){
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
            comboBoxSeeGyms.setItems(null);
        } else
            comboBoxSeeGyms.setItems(FXCollections.observableArrayList(gymsList));
    }

    public String getGym() throws Exception {
        int gym = comboBoxSeeGyms.getSelectionModel().getSelectedIndex() + 1;
        GymService gymService = new GymService();
        Gyms gyms = gymService.findGymId(gym);
        return gyms.getGymLocation();
    }

    public void keyReleasedProperty() {
        //String s = getGym();
        //'future update' - for an outside view of the gym hall, or inside view, or both doesnt matter
    }

    public void onClickGoBackToMainDashboard() throws Exception {
        hyperlinkBackToDashboard.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/DashboardManager.fxml"));
        Stage dashboardManager = new Stage();
        Scene sceneDM = new Scene(root);
        sceneDM.getStylesheets().add(getClass().getResource("/resources/css/DashboardManagerStylesheet.css").toExternalForm());
        dashboardManager.setScene(sceneDM);
        dashboardManager.setTitle("RAW POWER GYM - Manager`s Dashboard");
        dashboardManager.show();
    }

    public void onClickHyperlinkMe() throws Exception {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/Danielgdm-vlr").toURI());
        } catch (Exception e) {
            throw new Exception("The link couldn`t be opened!");
        }
    }
}
