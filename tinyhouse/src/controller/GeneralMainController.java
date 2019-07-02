package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Proizvod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GeneralMainController extends Controller {

    @FXML private Button btPretraga;
    @FXML private TextField tfPretraga;
    private Stage stage;

    private Aplikacija model;

    public GeneralMainController() {
        model = Aplikacija.getInstance();
    }
    @FXML
    private void prijava(){
        LoginController c = new LoginController();
        SceneSwitcher.switchScene(c, "../view/login_view.fxml");
    }

    @FXML
    private void korpa(){
        KorpaController c = new KorpaController();
        SceneSwitcher.switchScene(c, "../view/korpa_view.fxml", true, "nema nista");
    }

    @FXML
    private void enter_pretraga(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            pretraga();
        }
    }

    @FXML
    private void pretraga(ActionEvent e){
        pretraga();
    }

    private void pretraga(){
        if(btPretraga.getText().equals("Pretraga")){
            tfPretraga.setPrefWidth(120);
            btPretraga.setText("");
            btPretraga.setStyle("-fx-background-radius:30");
            tfPretraga.requestFocus();
        } else{
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
            }
        }
    }

    private ArrayList<Proizvod> search(String term){
        ArrayList<Proizvod> proizvodi = new ArrayList<>();
        for(Proizvod p : model.proizvodi){
            if(p.getNaziv().toLowerCase().contains(term.toLowerCase())) proizvodi.add(p);
        }
        return proizvodi;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
