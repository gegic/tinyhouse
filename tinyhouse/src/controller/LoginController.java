package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Korisnik;
import model.TipKorisnika;

import java.io.IOException;

public class LoginController extends Controller {
    @FXML
    private TextField k_ime;

    @FXML
    private Label lbGreska;

    @FXML
    private PasswordField lozinka;

    private Stage stage;


    private Aplikacija model;

    public LoginController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void prijavljen(ActionEvent e){
        prijava();
    }

    @FXML
    public void enter_prijavljen(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER) {
            prijava();
        }
    }

    void prijava(){
        Korisnik k = model.prijava(k_ime.getText(), lozinka.getText());
        if (k == null){
            k_ime.setStyle("-fx-border-color: red");
            lozinka.setStyle("-fx-border-color: red");
            lbGreska.setText("Pogrešno uneti podaci, pokušaj ponovo!");
        } else if(k.getTip() == TipKorisnika.admin){
            lbGreska.setText("");
            model.setUlogovani(k);
            scenaAdminGlavna();
        } else if (k.getTip() == TipKorisnika.moderator){
            lbGreska.setText("");
            model.setUlogovani(k);
            scenaModeratorGlavna();
        } else if(k.getTip() == TipKorisnika.obican){
            lbGreska.setText("");
            model.setUlogovani(k);
            scenaKorisnikGlavna();
        }
    }

    private void scenaModeratorGlavna(){
        ModeratorMainController c = new ModeratorMainController();
        SceneSwitcher.switchScene(c, "../view/moderator_main_view.fxml", "nebitno");
    }

    private void scenaAdminGlavna() {
        AdminMainController c = new AdminMainController();
        SceneSwitcher.switchScene(c, "../view/admin_main_view.fxml", "nebitno");
    }

    private void scenaKorisnikGlavna(){
        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml", "nebitno");
    }

    @FXML
    private void registracija(){
        RegistrationController c = new RegistrationController();
        SceneSwitcher.switchScene(c, "../view/registration_view.fxml");
    }

    @FXML
    private void povratak() throws IOException {
        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml", "nebitno");
    }


    public Aplikacija getModel() {
        return model;
    }

    public void setModel(Aplikacija model) {
        this.model = model;
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
