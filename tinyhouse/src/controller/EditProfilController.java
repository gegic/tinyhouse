package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.Aplikacija;
import model.Korisnik;
import model.TipKorisnika;

public class EditProfilController extends Controller {

    @FXML private CheckBox cbIme, cbEmail, cbAresa, cbLozinka;
    @FXML private TextField tfMail, tfAdresa, tfKIme,tfIme, tfPrezime;
    @FXML private PasswordField tfLozinkaStara, tfLozinkaNova;

    private Korisnik ulogovani;
    private Aplikacija model;
    public EditProfilController(){
        model = Aplikacija.getInstance();
        ulogovani = Aplikacija.getInstance().getUlogovani();

    }

    public void setInfo(Object o){
        tfKIme.setText(ulogovani.getUsername());
        if(ulogovani.getTip()== TipKorisnika.obican){
            tfIme.setText(ulogovani.getKupac().getIme());
            tfPrezime.setText(ulogovani.getKupac().getPrezime());
            tfMail.setText(ulogovani.getKupac().geteMail());
            tfAdresa.setText(ulogovani.getKupac().getAdresa());
        }
        else{
            cbIme.setDisable(true);
            cbEmail.setDisable(true);
            cbAresa.setDisable(true);
        }
    }

    @FXML
    private void cbImeAction(){
        setInfo(this);
        if(cbIme.isSelected()){
            tfIme.setDisable(false);
            tfPrezime.setDisable(false);
        }else {
            tfIme.setText(ulogovani.getKupac().getIme());
            tfPrezime.setText(ulogovani.getKupac().getPrezime());
            tfIme.setDisable(true);
            tfPrezime.setDisable(true);
        }
    }

    @FXML
    private void cbEmailAction(){
        if(cbEmail.isSelected()){
            tfMail.setDisable(false);
        }else {
            tfMail.setText(ulogovani.getKupac().geteMail());
            tfMail.setDisable(true);
        }
    }

    @FXML
    private void cbAresaAction(){
        if(cbAresa.isSelected()){
            tfAdresa.setDisable(false);
        }else {
            tfAdresa.setText(ulogovani.getKupac().getAdresa());
            tfAdresa.setDisable(true);
        }
    }

    @FXML
    private void cbLoznkaAction(){
        if(cbLozinka.isSelected()){
            tfLozinkaNova.setDisable(false);
        }else {
            tfLozinkaNova.setDisable(true);
        }
    }

    @FXML
    private void izmeni(){
        if(ulogovani.getTip()==TipKorisnika.obican) {
            if (tfIme.getText().trim().equalsIgnoreCase("") || tfPrezime.getText().trim().equalsIgnoreCase("") ||
                    tfMail.getText().trim().equalsIgnoreCase("") || tfAdresa.getText().trim().equalsIgnoreCase("") ||
                    tfKIme.getText().trim().equalsIgnoreCase("") || tfLozinkaStara.getText().trim().equalsIgnoreCase("")) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("GREŠKA");
                alert.setContentText("Polja koja se menjaju moraju biti popunjena, kao i polje lozinke.");
                alert.showAndWait();
                return;
            }
        }
        if( !tfLozinkaStara.getText().trim().equals(ulogovani.getPassword())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("GREŠKA");
            alert.setContentText("Unesite ispravnu lozinku.");
            alert.showAndWait();
        }
        izmenaUlogovanog();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Uspšno");
        alert.setContentText("Uspešno izmenjeni podaci.");
        alert.showAndWait();
        povratak();
    }

    private void izmenaUlogovanog(){
        if(cbLozinka.isSelected()){
            if(tfLozinkaNova.getText().length()<8){
                tfLozinkaStara.setStyle("-fx-border-color: red");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("GREŠKA");
                alert.setContentText("Lozinka mora da ima više od  karaktera.");
                alert.showAndWait();
                return;
            }
            ulogovani.setPassword(tfLozinkaNova.getText().trim());
        }
        postavljanePodataka();
    }

    private void postavljanePodataka(){
        if(ulogovani.getTip()==TipKorisnika.obican){
            ulogovani.getKupac().setIme(tfIme.getText().trim());
            ulogovani.getKupac().setPrezime(tfPrezime.getText().trim());
            ulogovani.getKupac().seteMail(tfMail.getText().trim());
            ulogovani.getKupac().setAdresa(tfAdresa.getText().trim());
        }
    }

    @FXML
    private void povratak(){
        if (ulogovani.getTip() == TipKorisnika.obican){
            GeneralMainController c = new GeneralMainController();
            SceneSwitcher.switchScene(c, "../view/general_main_view.fxml", "nebitno");
        } else if (ulogovani.getTip() == TipKorisnika.moderator){
            ModeratorMainController c = new ModeratorMainController();
            SceneSwitcher.switchScene(c, "../view/moderator_main_view.fxml");
        } else{
            AdminMainController c = new AdminMainController();
            SceneSwitcher.switchScene(c, "../view/admin_main_view.fxml");
        }

        /*RegistrovaniProfilController c = new RegistrovaniProfilController();
        SceneSwitcher.switchScene(c, "../view/registrovani_profil_view.fxml");*/ //Kad ovde vratim ona mi ne izmeni one tf-ove nego im stoji onaj podrazumevani tekst

    }
}
