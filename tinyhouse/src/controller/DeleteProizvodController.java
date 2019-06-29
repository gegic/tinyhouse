package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;

import java.io.IOException;

public class DeleteProizvodController {

    @FXML
    private Label lbIdProizvoda;

    @FXML
    private Label lbNaziv;

    private Stage stage;

    private Aplikacija model;

    public DeleteProizvodController(){
        this.model = Aplikacija.getInstance();
    }

    @FXML
    public void brisi(ActionEvent e){
        brisi();
    }

    @FXML
    public void enter_brisi(KeyEvent e){if (e.getCode() == KeyCode.ENTER) brisi();}

    public void brisi(){
        if(!model.brisanjeProizvoda(Integer.valueOf(lbIdProizvoda.getText()))){
            System.out.println("Doslo je do greske!");
        } else{
            povratak();
        }
    }

    @FXML
    public void otkazi(ActionEvent e) throws IOException {
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


    public void setLbIdProizvoda(String IdProizvoda) {
        this.lbIdProizvoda.setText(IdProizvoda);
    }

    public void setLbNaziv(String naziv) {
        this.lbNaziv.setText(naziv);
    }
}


