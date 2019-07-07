package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Narudzbina;
import model.Prodavnica;
import model.TipKorisnika;

import java.util.ArrayList;

public class OrdersController extends Controller {

    @FXML
    private ListView<Narudzbina> itemList;
    @FXML
    private BorderPane borderPane;

    private Stage stage;

    private Aplikacija model;

    public OrdersController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        TopBarController c = new TopBarController();
        borderPane.setTop(c.create());
        ArrayList<Narudzbina> ln;
        if(model.getUlogovani().getTip() == TipKorisnika.moderator){
            ln = new ArrayList<>(model.getNarudzbine());
        } else{
            ln = new ArrayList<>(model.getUlogovani().getKupac().getNarudzbine());
        }
        ObservableList<Narudzbina> observableList = FXCollections.observableList(ln);
        itemList.setItems(observableList);
        itemList.setCellFactory(e -> new NarudzbinaCellController());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void odjava(ActionEvent e) {
        SceneSwitcher.odjava();
    }

    @FXML
    public void povratak(ActionEvent e) {
        if(model.getUlogovani().getTip() == TipKorisnika.moderator) {
            ModeratorMainController c = new ModeratorMainController();
            SceneSwitcher.switchScene(c, "../view/moderator_main_view.fxml", "nebitno");
        } else{
            RegistrovaniProfilController c = new RegistrovaniProfilController();
            SceneSwitcher.switchScene(c, "../view/registrovani_profil_view.fxml", "nebitno");
        }
    }
}
