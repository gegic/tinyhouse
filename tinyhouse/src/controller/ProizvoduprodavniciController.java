package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Prodavnica;
import model.Proizvod;
import model.TipKorisnika;

import javax.swing.border.Border;
import java.util.ArrayList;

public class ProizvoduprodavniciController extends Controller {

    @FXML
    private ListView<Proizvod> itemsList;

    @FXML private Button btPotvrdi;
    @FXML private BorderPane borderPane;
    private Stage stage;

    private Aplikacija model;

    private Prodavnica prodavnica;

    private Proizvod previous;

    public ProizvoduprodavniciController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        if(Aplikacija.getInstance().getUlogovani() != null && Aplikacija.getInstance().getUlogovani().getTip() == TipKorisnika.moderator) {
            ArrayList<Proizvod> populateList = new ArrayList<>(model.proizvodi);
            ObservableList<Proizvod> observableList = FXCollections.observableList(populateList);
            itemsList.setItems(observableList);
            itemsList.setCellFactory(e -> new ProizvodCellController(true));
            for (Proizvod pp : prodavnica.getProizvodi()) {
                if (populateList.contains(pp)) {
                    itemsList.getSelectionModel().select(pp);
                }
            }
        } else{
            TopBarController c = new TopBarController();
            borderPane.setTop(c.create());
            btPotvrdi.setVisible(false);

            ObservableList<Proizvod> observableList = FXCollections.observableList(prodavnica.getProizvodi());
            itemsList.setItems(observableList);
            itemsList.setCellFactory(e -> new ProizvodCellController(true));
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void povratak(ActionEvent e) {
        if(Aplikacija.getInstance().getUlogovani() != null && Aplikacija.getInstance().getUlogovani().getTip() == TipKorisnika.moderator) {
            ModeratorStoresController c = new ModeratorStoresController();
            SceneSwitcher.switchScene(c, "../view/moderator_stores_view.fxml", true);
        } else{
            povratakKorisnik(e);
        }
    }

    private void povratakKorisnik(ActionEvent e){
        KorisnikStoresController c = new KorisnikStoresController();
        SceneSwitcher.switchScene(c, "../view/korisnik_stores_view.fxml", true, previous);
    }

    @FXML
    public void potvrdi(ActionEvent e){
        ArrayList<Proizvod> lp = new ArrayList<>(itemsList.getSelectionModel().getSelectedItems());
        model.dodavanjeProizvodaProdavnici(lp, prodavnica);
        povratak(null);
    }

    public void setInfo(Object o){
        Object[] obs = (Object[]) o;
        prodavnica = (Prodavnica) obs[0];
        previous = (Proizvod) obs[1];
        itemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
