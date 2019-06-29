package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class DeleteProdavnicaController {

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/moderator_stores_view.fxml"));
            Parent root = loader.load();

            ModeratorStoresController c = loader.getController();
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

    public int getId_prodavnice() {
        return id_prodavnice;
    }

    public void setId_prodavnice(int id_prodavnice) {
        this.id_prodavnice = id_prodavnice;
        id_prodavnice_label.setText(String.valueOf(id_prodavnice));
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
        adresa_label.setText(adresa);
    }
}


