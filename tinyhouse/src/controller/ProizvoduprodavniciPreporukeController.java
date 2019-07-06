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

public class ProizvoduprodavniciPreporukeController extends Controller {

    @FXML
    private ListView<Proizvod> itemsList;

    @FXML private Button btPotvrdi;
    @FXML private BorderPane borderPane;
    private Stage stage;

    private Aplikacija model;

    private Prodavnica prodavnica;

    private Proizvod previous;

    public ProizvoduprodavniciPreporukeController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        if(prodavnica != null &&
                Aplikacija.getInstance().getUlogovani() != null &&
                Aplikacija.getInstance().getUlogovani().getTip() == TipKorisnika.moderator) {
            ArrayList<Proizvod> populateList = new ArrayList<>(model.proizvodi);
            ObservableList<Proizvod> observableList = FXCollections.observableList(populateList);
            itemsList.setItems(observableList);
            itemsList.setCellFactory(e -> new ProizvodCellController(true));
            for (Proizvod pp : prodavnica.getProizvodi()) {
                if (populateList.contains(pp)) {
                    itemsList.getSelectionModel().select(pp);
                }
            }
        } else if (prodavnica != null){
            TopBarController c = new TopBarController();
            borderPane.setTop(c.create());
            btPotvrdi.setVisible(false);

            ObservableList<Proizvod> observableList = FXCollections.observableList(prodavnica.getProizvodi());
            itemsList.setItems(observableList);
            itemsList.setCellFactory(e -> new ProizvodCellController(true));
        } else{
            TopBarController c = new TopBarController();
            borderPane.setTop(c.create());
            ArrayList<Proizvod> populateList = new ArrayList<>(model.proizvodi);
            populateList.remove(previous);
            ObservableList<Proizvod> observableList = FXCollections.observableList(populateList);
            itemsList.setItems(observableList);
            itemsList.setCellFactory(e -> new ProizvodCellController(true));
            for (Proizvod pp : previous.getSlicanProizvod()) {
                if (populateList.contains(pp)) {
                    itemsList.getSelectionModel().select(pp);
                }
            }
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
        if(prodavnica != null && Aplikacija.getInstance().getUlogovani() != null && Aplikacija.getInstance().getUlogovani().getTip() == TipKorisnika.moderator) {
            ModeratorStoresController c = new ModeratorStoresController();
            SceneSwitcher.switchScene(c, "../view/moderator_stores_view.fxml", true);
        } else if (prodavnica != null){
            povratakKorisnik(e);
        } else{
            ModeratorItemsController c = new ModeratorItemsController();
            SceneSwitcher.switchScene(c, "../view/moderator_items_view.fxml", true);
        }
    }

    private void povratakKorisnik(ActionEvent e){
        KorisnikStoresController c = new KorisnikStoresController();
        SceneSwitcher.switchScene(c, "../view/korisnik_stores_view.fxml", true, previous);
    }

    @FXML
    public void potvrdi(ActionEvent e){
        ArrayList<Proizvod> lp = new ArrayList<>(itemsList.getSelectionModel().getSelectedItems());
        if(prodavnica != null) {
            model.dodavanjeProizvodaProdavnici(lp, prodavnica);
        } else{
            model.dodavanjeSlicnihProizvoda(lp, previous);
        }
        povratak(null);
    }

    public void setInfo(Object o){
        if(o instanceof Object[]){
            Object[] obs = (Object[]) o;
            prodavnica = (Prodavnica) obs[0];
            previous = (Proizvod) obs[1];
        } else if(o instanceof Prodavnica){
            prodavnica = (Prodavnica) o;

        } else{
            prodavnica = null;
            previous = (Proizvod) o;
        }
        itemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
