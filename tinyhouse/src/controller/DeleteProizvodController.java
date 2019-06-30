package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Aplikacija;
import model.Proizvod;

import java.io.IOException;

public class DeleteProizvodController extends Controller {

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
        ModeratorItemsController c = new ModeratorItemsController();
        SceneSwitcher.switchScene(c, "../view/moderator_items_view.fxml", true);
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setInfo(String idProizvoda) {
        int id = Integer.valueOf(idProizvoda);
        this.lbIdProizvoda.setText(idProizvoda);
        Proizvod p = model.pronadjiProizvod(id);
        this.lbNaziv.setText(p.getNaziv());
    }
}


