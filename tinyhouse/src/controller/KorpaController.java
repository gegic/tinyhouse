package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Korpa;
import model.Proizvod;
import model.StavkaNarudzbine;

import java.util.ArrayList;
import java.util.List;

public class KorpaController extends Controller {

    @FXML private ListView<StavkaNarudzbine> itemsList;

    @FXML private Label lbUkupno;
    @FXML private VBox vbNoResults;
    @FXML private Button btKupi;
    @FXML private BorderPane borderPane;
    private Stage stage;

    private Aplikacija model;

    public KorpaController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        List<StavkaNarudzbine> s = model.getTrenutnaKorpa().getStavkeNarudzbine();
        if(s.isEmpty()){
            vbNoResults.setVisible(true);
            btKupi.setDisable(true);
        } else {
            ObservableList<StavkaNarudzbine> observableList = FXCollections.observableList(s);
            itemsList.setItems(observableList);
            itemsList.setCellFactory(e -> new KorpaCellController(this));
        }
    }

    @FXML
    public void povratak(ActionEvent e){
        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml", "nebitno");
    }


    public void setInfo(Object o){
        lbUkupno.setText(model.getTrenutnaKorpa().getUkupnaCijena() + " RSD");
        TopBarController c = new TopBarController();
        borderPane.setTop(c.create());
        FooterController fc = new FooterController();
 borderPane.setBottom(fc.create());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void resetUkupno(float oldUkupno, float newUkupno){
        model.resetUkupno(oldUkupno, newUkupno);
        lbUkupno.setText(model.getTrenutnaKorpa().getUkupnaCijena() + " RSD");
    }

    @FXML
    public void kupi(ActionEvent e){
        KupovinaController c = new KupovinaController();
        SceneSwitcher.switchScene(c, "../view/kupovina_view.fxml", "nebitno");
    }
}
