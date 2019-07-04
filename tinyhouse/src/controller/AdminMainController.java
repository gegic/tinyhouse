package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Aplikacija;

public class AdminMainController extends Controller {

    private Stage stage;


    private Aplikacija model;

    public AdminMainController(){
        this.model = Aplikacija.getInstance();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void odjava(ActionEvent e) {
        SceneSwitcher.odjava();
    }

    @FXML
    public void pregledajModeratore(ActionEvent e) {
        AdminUsersController c = new AdminUsersController();
        SceneSwitcher.switchScene(c, "../view/admin_users_view.fxml", true);
    }

    @FXML
    public void profil(ActionEvent e) {
        RegistrovaniProfilController c = new RegistrovaniProfilController();
        SceneSwitcher.switchScene(c, "../view/registrovani_profil_view.fxml");

    }
}
