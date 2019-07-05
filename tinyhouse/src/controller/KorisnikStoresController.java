package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Prodavnica;

public class KorisnikStoresController extends Controller {

    @FXML
    private ListView<Prodavnica> prodList;

    private Stage stage;

    private Aplikacija model;

    public KorisnikStoresController() {
        this.model = Aplikacija.getInstance();
    }

    public void populate() {
        ObservableList<Prodavnica> observableList = FXCollections.observableList(model.prodavnice);
        prodList.setItems(observableList);
        prodList.setCellFactory(e -> new ProdavnicaCellController());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }



    @FXML
    public void povratak(ActionEvent e) {

        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml");
    }

}


