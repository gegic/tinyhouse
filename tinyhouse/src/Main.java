import controller.GeneralMainController;
import controller.Loader;
import controller.SceneSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneSwitcher.setStage(primaryStage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/general_main_view.fxml"));

        Parent root = loader.load();
        GeneralMainController c = loader.getController();
        c.setStage(primaryStage);
        primaryStage.setTitle("tinyhouse");
        primaryStage.setMinHeight(768);
        primaryStage.setMinWidth(1024);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setOnCloseRequest(e -> {SceneSwitcher.odjava(); Loader.save();});

        primaryStage.show();
        c.setInfo(null);

    }


    public static void main(String[] args) {
        Loader.load();
        launch(args);
    }
}
