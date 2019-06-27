package controller;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private TextField k_ime;

    @FXML
    private PasswordField lozinka;
    @FXML
    public void prijavljen(MouseEvent e){
        System.out.println(k_ime.getText());
        System.out.println(lozinka.getText());

    }

    @FXML
    public void enter_prijavljen(KeyEvent e){
        if(e.getCode() == KeyCode.ENTER) {
            prijavljen(null);
        }
    }
}
