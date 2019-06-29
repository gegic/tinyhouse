package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class ProizvodCellController extends ListCell<Proizvod> {

    @FXML
    private Label lb_id_proizvoda;

    @FXML
    private Button izbrisi;

    @FXML
    private AnchorPane box;

    @FXML
    private Label lb_kolicina;

    @FXML
    private Label lb_naziv;

    @FXML
    private ImageView icon;

    @FXML
    private TextField tfKolicina;

    @FXML
    private Button btUvecaj;

    private FXMLLoader mLLoader;

    @FXML
    public void brisanje(ActionEvent e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/delete_proizvod_view.fxml"));
            Parent root = loader.load();

            DeleteProizvodController c = loader.getController();
            Stage stage = (Stage)((Scene)((Button)e.getSource()).getScene()).getWindow();
            c.setStage(stage);
            c.setLbIdProizvoda(lb_id_proizvoda.getText());
            c.setLbNaziv(lb_naziv.getText());
            Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
            stage.setScene(scene);
        } catch(Exception ex){
            System.out.println("Nije moguće učitati scenu.");
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void izmena(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/modify_proizvod_view.fxml"));
            Parent root = loader.load();

            ModifyProizvodController c = loader.getController();
            Stage stage = (Stage)((Scene)((Button)e.getSource()).getScene()).getWindow();
            c.setStage(stage);
            c.setTfIdProizvoda(lb_id_proizvoda.getText());
            c.setInfo();
            Scene scene = new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight());
            stage.setScene(scene);
        } catch(Exception ex){
            System.out.println("Nije moguće učitati scenu.");
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void enter_uvecanje_kolicine(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER){
            uvecanjeKolicine(null);
        }
    }

    @FXML
    public void uvecanjeKolicine(ActionEvent e){
        Aplikacija model = Aplikacija.getInstance();
        if(btUvecaj.getText().equals("Uvećaj količinu")) {
            btUvecaj.setText("✓");
            tfKolicina.setVisible(true);
            tfKolicina.requestFocus();
        } else{
            String textKolicina = tfKolicina.getText();
            try{
                int kolicina = Integer.valueOf(textKolicina);
                if(kolicina > 0) {
                    btUvecaj.setText("Uvećaj količinu");
                    tfKolicina.setVisible(false);
                    int ukupno = model.uvecajKolicinuProizvoda(Integer.valueOf(lb_id_proizvoda.getText()), kolicina);
                    if(ukupno >=1000){
                        lb_kolicina.setText("...");
                    } else {
                        lb_kolicina.setText(String.valueOf(ukupno)); // jer necemo da se bakcemo sa listenerima :D
                    }
                    tfKolicina.setStyle("-fx-border-color: lightgray");
                    tfKolicina.setText("");
                } else{
                    tfKolicina.setStyle("-fx-border-color: red");
                }
            } catch (Exception ex){
                if(textKolicina.equals("")){
                    btUvecaj.setText("Uvećaj količinu");
                    tfKolicina.setVisible(false);
                    tfKolicina.setStyle("-fx-border-color: lightgray");
                    tfKolicina.setText("");
                } else {
                    tfKolicina.setStyle("-fx-border-color: red");
                }
            }
        }
    }

    @Override
    protected void updateItem(Proizvod p, boolean empty) {
        super.updateItem(p, empty);
        if(empty || p == null) {
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../view/proizvod_cell_view.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            lb_id_proizvoda.setText(String.valueOf(p.getId()));
            lb_naziv.setText(p.getNaziv());
            int kolicina = p.getKolicinaZaOnline();
            if(kolicina >= 1000){
                lb_kolicina.setText("...");
            }else {
                lb_kolicina.setText(String.valueOf(kolicina));
            }
            icon.setImage(p.getSlike()[0]);
            setText(null);
            setGraphic(box);
        }

    }

}
