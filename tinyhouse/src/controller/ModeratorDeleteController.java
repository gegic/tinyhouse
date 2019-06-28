package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class ModeratorDeleteController {

    @FXML
    private Label label;

    @FXML
    private Button obrisi_button;
    private String korisnicko_ime;

    private Stage stage;

    private Aplikacija model;

    public ModeratorDeleteController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void brisi(ActionEvent e){
        brisi();
    }

    @FXML
    public void enter_brisi(KeyEvent e){if (e.getCode() == KeyCode.ENTER) brisi();}

    public void brisi(){
        if(!model.brisanjeModeratora(korisnicko_ime)){
            System.out.println("Doslo je do greske!");
        } else{
            povratak();
        }
    }

    @FXML
    public void otkazi(ActionEvent e) throws IOException {
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

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
        label.setText(korisnicko_ime);
        if(korisnicko_ime.equals(model.getUlogovani().getUsername())){
            obrisi_button.setDisable(true);
        }
    }
}


