package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Aplikacija;

public class SceneSwitcher {

    private static Stage stage;

    public static void switchScene(Controller c, String path) {
        switchScene(c, path, false, null);
    }

    public static void switchScene(Controller c, String path, boolean populate) {
        switchScene(c, path, populate, null);
    }

    public static void switchScene(Controller c, String path, Object o){
        switchScene(c, path, false, o);
    }

    public static void switchScene(Controller c, String path, boolean populate, Object o){
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(path));
            Parent root = loader.load();
            c = loader.getController();
            c.setStage(stage);
            if (o != null){
                c.setInfo(o);
            }
            if (populate){
                c.populate();
            }
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void odjava(){
        Aplikacija.getInstance().odjava();
        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml", "nebitno");
    }

    public static void setStage(Stage s){stage = s;}

    public static Stage getStage() {
        return stage;
    }
}
