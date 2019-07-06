package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Prodavnica;

import java.io.IOException;

public class DeleteProdavnicaController extends Controller {

    @FXML
    private Label id_prodavnice_label;

    @FXML
    private Label adresa_label;

    @FXML
    private Button obrisi_button;

    private int id_prodavnice;

    private String adresa;

    private Stage stage;

    private Aplikacija model;

    public DeleteProdavnicaController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void brisi(ActionEvent e){
        brisi();
    }

    @FXML
    public void enter_brisi(KeyEvent e){if (e.getCode() == KeyCode.ENTER) brisi();}

    public void brisi(){
        if(!model.brisanjeProdavnice(id_prodavnice)){
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
        ModeratorStoresController c = new ModeratorStoresController();
        SceneSwitcher.switchScene(c, "../view/moderator_stores_view.fxml", true);
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getId_prodavnice() {
        return id_prodavnice;
    }

    public void setInfo(Object o) {
        Prodavnica p = (Prodavnica) o;
        this.id_prodavnice = p.getIdProdavnice();
        id_prodavnice_label.setText(String.valueOf(id_prodavnice));
        adresa_label.setText(p.getAdresa());

    }
}


