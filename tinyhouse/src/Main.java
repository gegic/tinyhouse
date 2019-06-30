import controller.GeneralMainController;
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
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(800);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
