import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Button button = new Button("Botao");
        //Stage stage = new Stage();
        stage.setTitle("Akskad");
        StackPane root = new StackPane();
        root.getChildren().addAll(button);
        stage.setScene( new Scene(root, 200, 200));
        stage.show();

    }
}
