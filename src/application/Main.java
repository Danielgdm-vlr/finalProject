package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public void start(Stage fStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/views/LogIn.fxml"));
        fStage.setScene(new Scene(root));
        fStage.setTitle("RAW POWER GYM - Log In");
        fStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
