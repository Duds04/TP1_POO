
import java.util.Map;

import GameClasses.CampoMinado;
import GameClasses.Mapa;
import javafx.application.Application;
import javafx.css.CssParser.ParseError;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args); // Parte responsavel por iniciar o jogo
    }

    // O jogo é construido daqui pra baixo
    @Override
    public void start(Stage stage) throws Exception {
        Mapa mapa;
     
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(root); // stage é a janela. Scene é o que esta dentro da janela
        stage.setTitle("Campo minado"); // Titulo da janela
        Image icon = new Image("bomb1.png");
        stage.getIcons().add(icon);

        stage.setResizable(false); // pra nao ser possivel mexer com o tamanho da tela
        
        stage.setScene(scene);
        stage.show();
    }
}
