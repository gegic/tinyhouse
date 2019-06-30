package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Proizvod;

import java.util.ArrayList;


public class ResultsController extends Controller {

    @FXML
    private TilePane tilePane;

    @FXML private Button btPretraga;
    @FXML private TextField tfPretraga;

    private Aplikacija model;

    private Stage stage;

    private ArrayList<Proizvod> results;

    public ResultsController(){
        model = Aplikacija.getInstance();
        results = new ArrayList<>();
    }

    public void populate(){
        for(Proizvod p : results){
            ProizvodTileController c = new ProizvodTileController();
            tilePane.getChildren().add(c.create(p));
        }
        if(results.size() == 0){
            Label prazno = new Label("Nema rezultata koji zadovoljavaju kriterijum pretrage");
            prazno.setId("prazno");
            prazno.setStyle("../styles/style.css");
            tilePane.getChildren().add(prazno);
        }
    }

    @FXML
    public void povratak(ActionEvent e){
        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml");
    }

    @FXML
    private void enter_pretraga(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            pretraga();
        }
    }

    @FXML
    public void pretraga(ActionEvent e){
    }

    public void pretraga(){
    }
    @FXML
    public void prijava(ActionEvent e){
        LoginController c = new LoginController();
        SceneSwitcher.switchScene(c, "../view/login_view.fxml");
    }

    @FXML
    public void korpa(ActionEvent e){

    }

    private ArrayList<Proizvod> search(String term){
        ArrayList<Proizvod> proizvodi = new ArrayList<>();
        for(Proizvod p : model.proizvodi){
            if(p.getNaziv().toLowerCase().contains(term.toLowerCase())) proizvodi.add(p);
        }
        return proizvodi;
    }

    public TilePane getTilePane() {
        return tilePane;
    }


    public void setList(ArrayList<Proizvod> list) {
        results = list;
    }
}
