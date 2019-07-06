package controller;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import model.Aplikacija;
import model.Prodavnica;
import model.Proizvod;
import model.StavkaNarudzbine;


public class KartaController extends Controller {

    @FXML private WebView webView;
    @FXML private BorderPane borderPane;

    private Aplikacija model;
    private Prodavnica prodavnica;
    private Proizvod previous;

    public KartaController(){
        model = Aplikacija.getInstance();
    }

    @FXML
    public void povratak(ActionEvent e){
        KorisnikStoresController c = new KorisnikStoresController();
        SceneSwitcher.switchScene(c, "../view/korisnik_stores_view.fxml", true, previous);
    }

    public void setInfo(Object o){
        Object[] obs = (Object[]) o;
        prodavnica = (Prodavnica) obs[0];
        TopBarController c = new TopBarController();
        borderPane.setTop(c.create());
        previous = (Proizvod) obs[1];
        webView.getEngine().load("https://www.google.com/maps/@" + prodavnica.getGeoSirina() + "," + prodavnica.getGeoDuzina() + ",17z");
    }
}
