package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class AdminController {

    private Stage stage;


    private Aplikacija model;

    public AdminController(){
        this.model = Aplikacija.getInstance();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void odjava(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login_scene.fxml"));

        Parent root = loader.load();
        model.setUlogovani(null);
        Controller c = loader.getController();
        c.setStage(stage);

        stage.setScene(new Scene(root, 800, 600));
    }

    @FXML
    public void pregledajModeratore(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/admin_moderator_view.fxml"));
        Parent root = loader.load();

        AdminUsersController c = loader.getController();
        c.setStage(stage);
        c.populate();
        Scene moderator_view = new Scene(root, 800, 600);
        stage.setScene(moderator_view);
    }
}
