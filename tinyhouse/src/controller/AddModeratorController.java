package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class AddModeratorController {

    @FXML
    private Label warning;

    @FXML
    private TextField k_ime;

    @FXML
    private PasswordField lozinka;

    private Stage stage;

    private Aplikacija model;

    public AddModeratorController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void enter_dodavanje(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            dodavanje();
        }
    }
    @FXML
    public void dodavanje(ActionEvent e){
        dodavanje();
    }

    public void dodavanje(){
        String message;
        if(!(message = model.dodajModeratora(k_ime.getText(), lozinka.getText())).equals("")){
            warning.setTextFill(Color.RED);
            warning.setText(message);
            k_ime.setStyle("-fx-border-color: red");
            lozinka.setStyle("-fx-border-color: red");
        }
        else{
            povratak();
        }
    }

    @FXML
    public void povratak(ActionEvent e) throws IOException {
        povratak();
    }

    public void povratak() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/admin_users_view.fxml"));
            Parent root = loader.load();

            AdminUsersController c = loader.getController();
            c.setStage(stage);
            c.populate();
            Scene moderator_view = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
            stage.setScene(moderator_view);
        } catch(Exception ex){
            System.out.println("Nije moguće učitati scenu.");
        }
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


}
