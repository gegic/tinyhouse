package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

import java.io.File;
import java.io.IOException;

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

    private Image images[];

    private Stage stage;
    private Aplikacija model;

    public AddProizvodController(){
        this.model = Aplikacija.getInstance();
        images = new Image[3];
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
        File selectedFile = izbor_slike();
        if(selectedFile != null){
            images[1] = new Image(selectedFile.toURI().toString());
            iv2.setImage(images[1]);
            pane3.setDisable(false);
            lbDodaj2.setVisible(false);
        }
    }

    @FXML
    public void selectImage3(MouseEvent e){
        File selectedFile = izbor_slike();
        if(selectedFile != null){
            images[2] = new Image(selectedFile.toURI().toString());
            iv3.setImage(images[2]);
            lbDodaj3.setVisible(false);
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

    public void dodavanje(){
        String message;
        try {
            int id = Integer.valueOf(tfIdProizvoda.getText());
            float cijena = Float.valueOf(tfCijena.getText());
            if(!(message = model.dodavanjeProizvoda(id, tfNaziv.getText(), taOpis.getText(), images, cijena)).equals("")){
                warning.setTextFill(Color.RED);
                warning.setText(message);
                tfIdProizvoda.setStyle("-fx-border-color: red");
                tfNaziv.setStyle("-fx-border-color: red");
                taOpis.setStyle("-fx-border-color: red");
                tfCijena.setStyle("-fx-border-color: red");
            }
            else{
                povratak();
            }
        } catch (NumberFormatException e){
            warning.setTextFill(Color.RED);
            warning.setText("Sva polja moraju biti logično popunjena");
            tfIdProizvoda.setStyle("-fx-border-color: red");
            tfNaziv.setStyle("-fx-border-color: red");
            tfCijena.setStyle("-fx-border-color: red");
            taOpis.setStyle("-fx-border-color: red");
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
