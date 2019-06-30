package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class AddProdavnicaController extends Controller {

    @FXML
    private Label warning;

    @FXML
    private TextField id_p;

    @FXML
    private TextField adresa;

    @FXML
    private TextField g_sirina;

    @FXML
    private TextField g_duzina;

    private Stage stage;

    private Aplikacija model;

    public AddProdavnicaController(){
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
        try {
            int id = Integer.valueOf(id_p.getText());
            float geoSirina = Float.valueOf(g_sirina.getText());
            float geoDuzina = Float.valueOf(g_duzina.getText());
            if(!(message = model.dodajProdavnicu(id, adresa.getText(), geoSirina, geoDuzina)).equals("")){
                warning.setTextFill(Color.RED);
                warning.setText(message);
                id_p.setStyle("-fx-border-color: red");
                adresa.setStyle("-fx-border-color: red");
                g_sirina.setStyle("-fx-border-color: red");
                g_duzina.setStyle("-fx-border-color: red");
            }
            else{
                povratak();
            }
        } catch (NumberFormatException e){
            warning.setTextFill(Color.RED);
            warning.setText("Sva polja moraju biti logično popunjena");
            id_p.setStyle("-fx-border-color: red");
            adresa.setStyle("-fx-border-color: red");
            g_sirina.setStyle("-fx-border-color: red");
            g_duzina.setStyle("-fx-border-color: red");
        }
    }

    @FXML
    public void povratak(ActionEvent e) throws IOException {
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


}
