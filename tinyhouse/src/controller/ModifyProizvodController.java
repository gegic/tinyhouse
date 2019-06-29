package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import model.Prodavnica;
import model.Proizvod;

import java.io.File;
import java.io.IOException;

public class ModifyProizvodController {

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
    private Image images[];

    private Stage stage;

    private Aplikacija model;

    public ModifyProizvodController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void enter_izmena(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            izmena();
        }
    }
    @FXML
    public void izmena(ActionEvent e){
        izmena();
    }

    public void izmena(){
        String message;
        try {
            int id = Integer.valueOf(tfIdProizvoda.getText());
            if(!(message = model.izmeniProizvod(id, tfNaziv.getText(), taOpis.getText(), images)).equals("")){
                warning.setTextFill(Color.RED);
                warning.setText(message);
                tfNaziv.setStyle("-fx-border-color: red");
                taOpis.setStyle("-fx-border-color: red");
            }
            else{
                povratak();
            }
        } catch (NumberFormatException e){
            warning.setTextFill(Color.RED);
            warning.setText("Sva polja moraju biti logično popunjena");
            tfNaziv.setStyle("-fx-border-color: red");
            taOpis.setStyle("-fx-border-color: red");
        }
    }

    @FXML
    public void povratak(ActionEvent e) throws IOException {
        povratak();
    }

    public void povratak() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/moderator_items_view.fxml"));
            Parent root = loader.load();

            ModeratorItemsController c = loader.getController();
            c.setStage(stage);
            c.populate();
            Scene moderator_view = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
            stage.setScene(moderator_view);
        } catch(Exception ex){
            System.out.println("Nije moguće učitati scenu.");
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setTfIdProizvoda(String IdProizvoda) {
        this.tfIdProizvoda.setText(IdProizvoda);
    }

    public void setInfo(){
        Proizvod p = model.pronadjiProizvod(Integer.valueOf(tfIdProizvoda.getText()));
        tfNaziv.setText(p.getNaziv());
        taOpis.setText(p.getOpis());
        images = p.getSlike();
        if(images[0] != null){
            iv1.setImage(images[0]);
            pane2.setDisable(false);
            lbDodaj1.setVisible(false);
            btDodavanje.setDisable(false);
        }
        if(images[1] != null){
            iv2.setImage(images[2]);
            iv2.setImage(images[1]);
            pane3.setDisable(false);
            lbDodaj2.setVisible(false);
        }
        if(images[2] != null){
            iv3.setImage(images[2]);
            lbDodaj3.setVisible(false);
        }

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
}
