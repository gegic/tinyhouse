package controller;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import model.Aplikacija;
import model.Kategorija;
import model.Proizvod;


import java.io.IOException;
import java.util.ArrayList;


public class TopBarController extends Controller{
    @FXML private Button btPretraga;
    @FXML private TextField tfPretraga;
    @FXML private Button btPrijava;
    @FXML private Button btOdjava;
    @FXML private HBox box;
    @FXML private HBox menuBar;
    private Aplikacija model;

    public TopBarController(){model = Aplikacija.getInstance();}

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

    @FXML private void odjava(ActionEvent e){
        SceneSwitcher.odjava();
    };

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
                ex.printStackTrace();
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

    private void pregledKategorije(Kategorija k){
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource("../view/results_view.fxml"));
            Parent root = loader.load();
            ResultsController c = loader.getController();
            c.setList(k.getAllProizvodi());
            c.setStage(stage);
            c.populate();
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private void setSubCategories(SplitMenuButton m, Kategorija k){
        if(k.getPotkategorije().size() == 0){
            MenuItem mi = new MenuItem(k.getNaziv());
            mi.setOnAction((e) -> pregledKategorije(k));
            m.getItems().add(mi);
        } else{
            CustomMenuItem cmi = new CustomMenuItem();
            SplitMenuButton smb = new SplitMenuButton();
            smb.setPopupSide(Side.RIGHT);
            smb.setText(k.getNaziv());
            smb.setOnAction((e) -> pregledKategorije(k));
            smb.setId("upper_split_button");
            smb.getStylesheets().add(getClass().getResource("../styles/style.css").toString());
            for(Kategorija pk : k.getPotkategorije()){
                setSubCategories(smb, pk);
            }
            cmi.setContent(smb);
            m.getItems().add(cmi);
        }
    }

    private void profil(ActionEvent e){
        RegistrovaniProfilController c = new RegistrovaniProfilController();
        SceneSwitcher.switchScene(c, "../view/registrovani_profil_view.fxml", "nebitno");
    }

    private void setCategories(){
        for(Kategorija k : model.getKategorije()){
            if(k.getNatkategorija() == null){
                if(k.getPotkategorije().size() == 0){
                    Button m = new Button(k.getNaziv());
                    m.setId("upper_button");
                    m.setOnAction((e) -> pregledKategorije(k));
                    m.getStylesheets().add(getClass().getResource("../styles/style.css").toString());

                    menuBar.getChildren().add(m);
                } else{
                    SplitMenuButton m = new SplitMenuButton();
                    m.setText(k.getNaziv());
                    m.setOnAction((e) -> pregledKategorije(k));
                    m.setId("upper_split_button");
                    m.getStylesheets().add(getClass().getResource("../styles/style.css").toString());
                    menuBar.getChildren().add(m);

                    for(Kategorija pk : k.getPotkategorije()){
                        setSubCategories(m, pk);
                    }
                }
            }
        }

    }


    public HBox create(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/top_bar_view.fxml"));
        loader.setController(this);
        try {
            loader.load();
            this.stage = SceneSwitcher.getStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (model.getUlogovani() != null){
            btPrijava.setText("Profil");
            btPrijava.setOnAction(e -> profil(e));
            btOdjava.setPrefWidth(93);
        }
        setCategories();
        return box;
    }
}
