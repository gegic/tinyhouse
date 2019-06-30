package controller;

import javafx.fxml.FXMLLoader;
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

    public static void switchScene(Controller c, String path, String id){
        switchScene(c, path, false, id);
    }

    public static void switchScene(Controller c, String path, boolean populate, String id){
        try {
            FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(path));

            Parent root = loader.load();
            c = loader.getController();
            c.setStage(stage);
            if (populate){
                c.populate();
            }
            if (id != null){
                c.setInfo(id);
            }
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void odjava(){
        Aplikacija.getInstance().setUlogovani(null);
        GeneralMainController c = new GeneralMainController();
        SceneSwitcher.switchScene(c, "../view/general_main_view.fxml");
    }

    public static void setStage(Stage s){stage = s;}
}
