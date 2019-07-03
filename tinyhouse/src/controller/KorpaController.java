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

    @FXML private Button btPretraga;
    @FXML private TextField tfPretraga;
    @FXML private Label lbUkupno;
    @FXML private VBox vbNoResults;
    private Stage stage;

    private Aplikacija model;

    public KorpaController(){
        this.model = Aplikacija.getInstance();
    }

    public void populate(){
        List<StavkaNarudzbine> s = model.getTrenutnaKorpa().getStavkeNarudzbine();
        if(s.isEmpty()){
            vbNoResults.setVisible(true);
        } else {
            ObservableList<StavkaNarudzbine> observableList = FXCollections.observableList(s);
            itemsList.setItems(observableList);
            itemsList.setCellFactory(e -> new KorpaCellController(this));
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
        pretraga();
    }

    public void pretraga(){
        if(btPretraga.getText().equals("Pretraga")){
            tfPretraga.setPrefWidth(120);
            btPretraga.setText("");
            btPretraga.setStyle("-fx-background-radius:30");
            tfPretraga.requestFocus();
        } else {
            tfPretraga.setPrefWidth(0);
            btPretraga.setText("Pretraga");
            btPretraga.setStyle("-fx-background-radius:15");
            ArrayList<Proizvod> ps = search(tfPretraga.getText());
            tfPretraga.setText("");
            ResultsController c = new ResultsController();
            try {
                FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource("../view/results_view.fxml"));
                Parent root = loader.load();
                c = loader.getController();
                c.setList(ps);
                c.setStage(stage);
                c.populate();
                stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
            } catch(Exception ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    @FXML
    public void prijava(ActionEvent e){
        LoginController c = new LoginController();
        SceneSwitcher.switchScene(c, "../view/login_view.fxml");
    }

    private ArrayList<Proizvod> search(String term){
        ArrayList<Proizvod> proizvodi = new ArrayList<>();
        for(Proizvod p : model.proizvodi){
            if(p.getNaziv().toLowerCase().contains(term.toLowerCase())) proizvodi.add(p);
        }
        return proizvodi;
    }

    public void setInfo(String id){
        lbUkupno.setText(model.getTrenutnaKorpa().getUkupnaCijena() + " RSD");
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
}
