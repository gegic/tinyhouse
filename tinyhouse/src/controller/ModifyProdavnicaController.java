package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Prodavnica;

import java.io.IOException;

public class ModifyProdavnicaController {

    @FXML
    private Label warning;

    @FXML
    private TextField id_prodavnice_text;

    @FXML
    private TextField adresa_text;

    @FXML
    private TextField g_sirina_text;

    @FXML
    private TextField g_duzina_text;



    private Stage stage;

    private Aplikacija model;

    public ModifyProdavnicaController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void enter_izmena(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            izmena();
        }
    }
    @FXML
    public void izmena(ActionEvent e){
        izmena();
    }

    public void izmena(){
        String message;
        try {
            int id = Integer.valueOf(id_prodavnice_text.getText());
            float geoSirina = Float.valueOf(g_sirina_text.getText());
            float geoDuzina = Float.valueOf(g_duzina_text.getText());
            if(!(message = model.izmeniProdavnicu(id, adresa_text.getText(), geoSirina, geoDuzina)).equals("")){
                warning.setTextFill(Color.RED);
                warning.setText(message);
                adresa_text.setStyle("-fx-border-color: red");
                g_sirina_text.setStyle("-fx-border-color: red");
                g_duzina_text.setStyle("-fx-border-color: red");
            }
            else{
                povratak();
            }
        } catch (NumberFormatException e){
            warning.setTextFill(Color.RED);
            warning.setText("Sva polja moraju biti logično popunjena");
            adresa_text.setStyle("-fx-border-color: red");
            g_sirina_text.setStyle("-fx-border-color: red");
            g_duzina_text.setStyle("-fx-border-color: red");
        }
    }

    @FXML
    public void povratak(ActionEvent e) throws IOException {
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

    public int getId_prodavnice_text() {
        return Integer.valueOf(id_prodavnice_text.getText());
    }

    public void setId_prodavnice_text(String id_prodavnice_text) {
        this.id_prodavnice_text.setText(id_prodavnice_text);
    }

    public void setInfo(){
        Prodavnica p = model.pronadji_prodavnicu(Integer.valueOf(id_prodavnice_text.getText()));
        adresa_text.setText(p.getAdresa());
        g_sirina_text.setText(String.valueOf(p.getGeoSirina()));
        g_duzina_text.setText(String.valueOf(p.getGeoDuzina()));
    }
}