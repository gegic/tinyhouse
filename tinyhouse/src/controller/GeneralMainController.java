package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Proizvod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GeneralMainController extends Controller {

    @FXML private BorderPane borderPane;
    @FXML private VBox box1, box2, box3;
    @FXML private Label lbNaziv1, lbNaziv2, lbNaziv3;
    @FXML private ImageView iv1, iv2, iv3;
    @FXML private GridPane gridPane;

    private Proizvod p1, p2, p3;
    private TopBarController tbc;
    private Aplikacija model;

    public GeneralMainController() {
        model = Aplikacija.getInstance();
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setInfo(Object o){
        TopBarController c = new TopBarController();
        borderPane.setTop(c.create());
        FooterController fc = new FooterController();
        borderPane.setBottom(fc.create());
        if(model.getProizvodi().size() >= 3) {
            p1 = model.getProizvodi().get(0);
            p2 = model.getProizvodi().get(1);
            p3 = model.getProizvodi().get(2);

            iv1.setImage(p1.getSlike()[0]);
            iv2.setImage(p2.getSlike()[0]);
            iv3.setImage(p3.getSlike()[0]);

            lbNaziv1.setText(p1.getNaziv());
            lbNaziv2.setText(p2.getNaziv());
            lbNaziv3.setText(p3.getNaziv());
        } else{
            box1.setVisible(false);
            box2.setVisible(false);
            GridPane.setRowSpan(box3, 2);
            GridPane.setColumnSpan(box3, 2);
            iv3.setImage(new Image(getClass().getResourceAsStream("../styles/images/storeicon.png")));
            lbNaziv3.setText("Najbolja onlajn prodavnica na svijetu");
            box3.setCursor(Cursor.DEFAULT);
            box3.setOnMouseClicked(null);
        }
    }

    @FXML
    public void details1(MouseEvent e){
        details(p1);
    }
    @FXML
    public void details2(MouseEvent e){
        details(p2);
    }
    @FXML
    public void details3(MouseEvent e){
        details(p3);
    }

    private void details(Proizvod p){
        ProizvodDetailsController c = new ProizvodDetailsController();
        SceneSwitcher.switchScene(c, "../view/proizvod_details_view.fxml", p);
    }
}
