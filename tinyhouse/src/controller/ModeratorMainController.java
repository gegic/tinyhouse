package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class ModeratorMainController {

    private Stage stage;

    private Aplikacija model;

    public ModeratorMainController(){
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/login_view.fxml"));

        Parent root = loader.load();
        model.setUlogovani(null);
        LoginController c = loader.getController();
        c.setStage(stage);

        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
    }

    @FXML
    public void pregledajProdavnice(ActionEvent e){
        // TODO: pregledanje prodavnica
    }

    @FXML
    public void pregledajProizvode(ActionEvent e){
        // TODO: pregledanje prozivoda
    }
}
