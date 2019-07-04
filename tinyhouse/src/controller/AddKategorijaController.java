package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Kategorija;

public class AddKategorijaController extends Controller {

    @FXML private Label warning;

    @FXML private TextField tfNaziv;

    @FXML private ComboBox<Kategorija> cb;

    private Stage stage;

    private Aplikacija model;

    public AddKategorijaController(){
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

    private String provera(String naziv){
        for(Kategorija k : model.getKategorije()){
            if (k.getNaziv().equals(naziv))
                return "Postoji kategorija sa ovim nazivom";
        }
        return "";
    }

    public void dodavanje(){
        Kategorija selected = cb.getSelectionModel().getSelectedItem();
        String naziv = tfNaziv.getText();
        String message;
        if((message = provera(naziv)).equals("")){
            model.dodavanjeKategorije(naziv, selected);
            povratak();
        } else{
            tfNaziv.setStyle("-fx-border-color: red");
            warning.setTextFill(Color.RED);
            warning.setText(message);
        }
    }

    @FXML
    public void povratak(ActionEvent e) {
        povratak();
    }

    public void povratak() {
        ModeratorCategoriesController c = new ModeratorCategoriesController();
        SceneSwitcher.switchScene(c, "../view/moderator_categories_view.fxml", true);
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    public void populate(){
        ObservableList<Kategorija> observableList = FXCollections.observableList(model.getKategorije());
        cb.setItems(observableList);
    }
}
