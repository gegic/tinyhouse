package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import model.Aplikacija;
import model.Proizvod;

import java.util.ArrayList;


public class ResultsController extends Controller {

    @FXML private TilePane tilePane;
    @FXML private Button btPretraga;
    @FXML private TextField tfPretraga;
    @FXML private ScrollPane scrollPane;

    private Aplikacija model;

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
            setNoResults();
        }
    }

    private void setNoResults() {
        Label prazno = new Label("Nema rezultata koji zadovoljavaju kriterijum pretrage");
        prazno.setId("prazno");
        prazno.setStyle("../styles/style.css");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        tilePane.prefWidthProperty().bind(scrollPane.widthProperty());
        tilePane.prefHeightProperty().bind(scrollPane.heightProperty());
        tilePane.setOrientation(Orientation.VERTICAL);
        tilePane.setAlignment(Pos.CENTER);
        tilePane.setTileAlignment(Pos.CENTER);
        ImageView icon = new ImageView(
                new Image(getClass().getResourceAsStream("../styles/images/noresultsicon.png")));
        icon.setFitHeight(100);
        icon.setFitWidth(100);
        tilePane.getChildren().addAll(icon, prazno);
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

    @FXML
    public void korpa(ActionEvent e){
        KorpaController c = new KorpaController();
        SceneSwitcher.switchScene(c, "../view/korpa_view.fxml", true, "nema nista");
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
