package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Kategorija;
import model.Proizvod;

import java.io.File;
import java.io.IOException;
import java.security.Key;

public class AddProizvodController extends Controller {

    @FXML private TextField tfIdProizvoda;
    @FXML private TextField tfNaziv;
    @FXML private TextArea taOpis;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @FXML private Pane pane3;
    @FXML private Label lbDodaj1;
    @FXML private Label lbDodaj2;
    @FXML private Label lbDodaj3;
    @FXML private ImageView iv1;
    @FXML private ImageView iv2;
    @FXML private ImageView iv3;
    @FXML private Button btDodavanje;
    @FXML private Label warning;
    @FXML private TextField tfCijena;
    @FXML private ComboBox<Kategorija> cbKategorija;
    private Image images[];

    private Stage stage;
    private Aplikacija model;

    public AddProizvodController(){
        this.model = Aplikacija.getInstance();
        images = new Image[3];
    }

    public void populate(){
        ObservableList<Kategorija> observableList = FXCollections.observableList(model.getKategorije());
        cbKategorija.setItems(observableList);
        setBoundaries();
    }

    private void setBoundaries(){
        tfCijena.textProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (!newValue.matches("^\\d+\\.?\\d*$")) newValue = newValue.replaceAll("((?!\\.)\\D+\\.?)", "");
                    tfCijena.setText(newValue);
                });
        tfIdProizvoda.textProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if (!newValue.matches("\\d*")) newValue = newValue.replaceAll("[^\\d]", "");
                    tfIdProizvoda.setText(newValue);
                });
    }

    @FXML
    public void enter_dodavanje(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            dodavanje();
        }
    }
    @FXML
    public void dodavanje(ActionEvent e){
        dodavanje();
    }

    @FXML
    public void selectImage1(MouseEvent e){

        File selectedFile = izbor_slike();
        if(selectedFile != null){
            images[0] = new Image(selectedFile.toURI().toString());
            iv1.setImage(images[0]);
            pane2.setDisable(false);
            lbDodaj1.setVisible(false);
            btDodavanje.setDisable(false);
        }
    }

    @FXML
    public void selectImage2(MouseEvent e){
        if(lbDodaj2.getText().equals("ukloni sliku")){
            images[1] = null;
            iv2.setImage(null);
            pane3.setDisable(true);
            lbDodaj2.setStyle("-fx-background-color: transparent");
            lbDodaj2.setText("dodaj sliku");
        } else{
            File selectedFile = izbor_slike();
            if(selectedFile != null){
                images[1] = new Image(selectedFile.toURI().toString());
                iv2.setImage(images[1]);
                pane3.setDisable(false);
                lbDodaj2.setStyle("-fx-background-color: white");
                lbDodaj2.setText("ukloni sliku");
            }
        }
    }

    @FXML
    public void selectImage3(MouseEvent e){
        if(lbDodaj3.getText().equals("ukloni sliku")){
            images[2] = null;
            iv3.setImage(null);
            lbDodaj3.setStyle("-fx-background-color: transparent");
            lbDodaj3.setText("dodaj sliku");
            lbDodaj2.setText("ukloni sliku");
            lbDodaj2.setVisible(true);
        } else {
            File selectedFile = izbor_slike();
            if (selectedFile != null) {
                images[2] = new Image(selectedFile.toURI().toString());
                iv3.setImage(images[2]);
                lbDodaj3.setStyle("-fx-background-color: white");
                lbDodaj3.setText("ukloni sliku");
                lbDodaj2.setText("slika 2");
                lbDodaj2.setVisible(false);
            }
        }
    }

    private File izbor_slike(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Slecet image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        return selectedFile;
    }

    private String provera(int id, String naziv, String opis, Image[] slike, float cijena, Kategorija k){
        if(slike[0] == null){
            return "Mora se postaviti bar jedna slika";
        }
        if(id > 10000 || id < 1){
            return "ID mora biti između 1 i 10000";
        }
        if(cijena <= 0){
            return "Cijena mora da prelazi 0 dinara";
        }
        if(k == null){
            return "Mora se izabrati kategorija";
        }
        if(naziv.length() < 3 || naziv.length() > 15){
            return "Naziv proizvoda mora imati između 3 i 15 karaktera";
        }
        if(opis.length() < 3 || opis.length() > 255){
            return "Opis proizvoda mora imati između 3 i 255 karaktera";
        }
        for(Proizvod p : model.getProizvodi()){
            if(p.getId() == id){
                return "Već postoji proizvod sa ovim ID-jem";
            }
        }
        return "";
    }

    public void dodavanje(){
        try {
            String message;
            int id = Integer.valueOf(tfIdProizvoda.getText());
            float cijena = Float.valueOf(tfCijena.getText());
            Kategorija natKategorija = cbKategorija.getSelectionModel().getSelectedItem();
            if ((message = provera(id, tfNaziv.getText(), taOpis.getText(), images, cijena, natKategorija)).equals("")) {
                model.dodavanjeProizvoda(id, tfNaziv.getText(), taOpis.getText(), images, cijena, natKategorija);
                povratak();
            } else {
                warning.setTextFill(Color.RED);
                warning.setText(message);
                tfIdProizvoda.setStyle("-fx-border-color: red");
                tfNaziv.setStyle("-fx-border-color: red");
                taOpis.setStyle("-fx-border-color: red");
                tfCijena.setStyle("-fx-border-color: red");

            }
        } catch (Exception ex){
            warning.setTextFill(Color.RED);
            warning.setText("Morate logicno popuniti polja");
            tfIdProizvoda.setStyle("-fx-border-color: red");
            tfNaziv.setStyle("-fx-border-color: red");
            taOpis.setStyle("-fx-border-color: red");
            tfCijena.setStyle("-fx-border-color: red");
        }
    }

    @FXML
    public void move(KeyEvent e){
        if (e.getCode() == KeyCode.TAB && e.isShiftDown()){
            tfNaziv.requestFocus();
        } else if(e.getCode() == KeyCode.TAB){
            tfCijena.requestFocus();
        }
    }

    @FXML
    public void povratak(ActionEvent e) throws IOException {
        povratak();
    }

    public void povratak() {
        ModeratorItemsController c = new ModeratorItemsController();
        SceneSwitcher.switchScene(c, "../view/moderator_items_view.fxml", true);
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


}
