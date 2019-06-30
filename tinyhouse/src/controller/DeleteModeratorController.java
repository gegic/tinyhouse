package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class DeleteModeratorController extends Controller {

    @FXML
    private Label label;

    @FXML
    private Button obrisi_button;
    private String korisnicko_ime;

    private Stage stage;

    private Aplikacija model;

    public DeleteModeratorController(){
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
        AdminUsersController c = new AdminUsersController();
        SceneSwitcher.switchScene(c, "../view/admin_users_view.fxml", true);
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

    public void setInfo(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
        label.setText(korisnicko_ime);
        if(korisnicko_ime.equals(model.getUlogovani().getUsername())){
            obrisi_button.setDisable(true);
        }
    }
}


