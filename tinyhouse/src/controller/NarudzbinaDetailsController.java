package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Narudzbina;
import model.StavkaNarudzbine;

import java.util.List;

public class NarudzbinaDetailsController extends Controller {

    @FXML private ListView<StavkaNarudzbine> itemsList;

    @FXML private Label lbUkupno;
    @FXML private Label lbTrenutno;
    @FXML private VBox vbNoResults;
    @FXML private BorderPane borderPane;
    private Narudzbina narudzbina;
    private Stage stage;

    private Aplikacija model;

    public NarudzbinaDetailsController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        List<StavkaNarudzbine> s = narudzbina.getStavke();
        ObservableList<StavkaNarudzbine> observableList = FXCollections.observableList(s);
        itemsList.setItems(observableList);
        itemsList.setCellFactory(e -> new StavkaCellController());
    }

    @FXML
    public void povratak(ActionEvent e){
        OrdersController c = new OrdersController();
        SceneSwitcher.switchScene(c, "../view/orders_view.fxml", true);
    }

    @FXML
    public void odjava(ActionEvent e){
        SceneSwitcher.odjava();
    }

    public void setInfo(Object narudzbina){
        this.narudzbina = (Narudzbina) narudzbina;
        lbUkupno.setText(this.narudzbina.getCijena() + " RSD");
        lbTrenutno.setText(this.narudzbina.getTrenutno_stanje().toString());
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
}
