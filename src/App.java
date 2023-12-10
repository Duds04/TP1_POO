import java.io.IOException;

import GameClasses.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class App extends Application{
    Mapa mapa;
    private GridPane grid ;
    private Stage stage;
    private Scene scene;
    private Parent root;
    String [] args;
            
    public static void main(String[] args) throws Exception {
        launch(args); // Parte responsavel por iniciar o jogo
    }
        
    public void initialize(){
        int numCols = 8 ; 
        int numRows = 8 ;
        this.grid = new GridPane();

        for (int i = 0 ; i < numCols ; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            grid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0 ; i < numRows ; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            grid.getRowConstraints().add(rowConstraints);
        }
    }
    // O jogo é construido daqui pra baixo
    @Override
    public void start(Stage stage) throws Exception {

            StackPane root = new StackPane();

            Button botaoFacil = new Button("Diculdade Fácil");
            botaoFacil.setPrefSize(200,50);
            botaoFacil.setOnMouseClicked(e -> {
                grid = new GridPane();
                mapa = new Mapa("FACIL");
                // Add buttons to the grid pane
                iniciaGrid();
    
                Scene scene = new Scene(grid, 300, 200);
                stage.setScene(scene);
                stage.setTitle("Campo Minado");
                stage.show();
            });

            Button botaoMedio = new Button("Diculdade Média");
            botaoMedio.setPrefSize(200,50);
            botaoMedio.setOnMouseClicked(e -> {
                grid = new GridPane();
                mapa = new Mapa("MEDIO");
                // Add buttons to the grid pane
                iniciaGrid();
    
                Scene scene = new Scene(grid, 400, 400);
                stage.setScene(scene);
                stage.setTitle("Campo Minado");
                stage.show();
            });

            Button botaoDificil = new Button("Diculdade Difícil");
            botaoDificil.setPrefSize(200,50);
            botaoDificil.setOnMouseClicked(e -> {
                grid = new GridPane();
                mapa = new Mapa("DIFICIL");
                // Add buttons to the grid pane
                iniciaGrid();
    
                Scene scene = new Scene(grid, 500, 500);
                stage.setScene(scene);
                stage.setTitle("Campo Minado");
                stage.show();
            });

            VBox caixaTexto = new VBox();
            Text texto = new Text("Escolha a dificuldade do Campo Minado!");
            texto.setFont(new Font(20));
            caixaTexto.getChildren().add(texto);
            caixaTexto.setAlignment(Pos.BASELINE_CENTER);

            VBox caixaBotoes = new VBox();
            caixaBotoes.setAlignment(Pos.CENTER);
            caixaBotoes.getChildren().addAll(botaoFacil, botaoMedio, botaoDificil);

            root.getChildren().add(caixaTexto);
            root.getChildren().add(caixaBotoes);
            Scene scene = new Scene(root, 400, 400);
            stage.setScene(scene);
            stage.setTitle("Campo Minado");
            stage.show();
    }

    
    private void addPane(int colIndex, int rowIndex) {
        Button pane = new Button(" ");
        pane.setPrefSize(30, 30);
        pane.setOnMouseClicked(e -> {
            System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);

            if (mapa.mapa[rowIndex][colIndex].isBomba() && (e.getButton() == MouseButton.PRIMARY)){
                Stage stagePerdeu = new Stage();
                StackPane root = new StackPane();
                Label label = new Label("VOCE PERDEU");
                Button button = new Button("Voltar ao Menu");
                button.setOnMouseClicked(f-> {
                    Stage stage = (Stage) button.getScene().getWindow();
                    stage.close();

                    // Launch a new instance of the application
                    Platform.runLater(() -> {
                        try {
                            new App().start(new Stage());
                        } catch (Exception g) {
                            g.printStackTrace();
                        }
                    });
                }); 
                VBox vBox = new VBox(2);
                label.setAlignment(Pos.BASELINE_CENTER);

                vBox.getChildren().addAll(label, button);
                root.getChildren().add(vBox);
                vBox.setAlignment(Pos.CENTER);

                Scene scenePerdeu = new Scene(root, 400, 300);
                stagePerdeu.setScene(scenePerdeu);
                stagePerdeu.setTitle("Voce perdeu");
                // Show the new stage
                Stage stageAtual = (Stage) pane.getScene().getWindow();
                stageAtual.close();
                stagePerdeu.show();
            }

            if (mapa.getCelulasAbertas() == mapa.getTotCelulas() - 1){
                Stage stageGanhou = new Stage();
                StackPane rootGanhou = new StackPane();
                Label label = new Label("VOCE GANHOU!!");
                Button button = new Button("Voltar ao Menu");
                button.setOnMouseClicked(f-> {
                    Stage stage = (Stage) button.getScene().getWindow();
                    stage.close();

                    // Launch a new instance of the application
                    Platform.runLater(() -> {
                        try {
                            new App().start(new Stage());
                        } catch (Exception g) {
                            g.printStackTrace();
                        }
                    });
                }); 
                VBox vBox = new VBox(2);
                label.setAlignment(Pos.BASELINE_CENTER);

                vBox.getChildren().addAll(label, button);
                vBox.setAlignment(Pos.CENTER);
                rootGanhou.getChildren().add(vBox);
                Scene sceneGanhou = new Scene(rootGanhou, 400, 300);
                stageGanhou.setScene(sceneGanhou);
                stageGanhou.setTitle("Voce ganhou");
                // Show the new stage
                Stage stageAtual = (Stage) pane.getScene().getWindow();
                stageAtual.close();
                stageGanhou.show();
            }

            if (e.getButton() == MouseButton.SECONDARY){
                //if (mapa.mapa[rowIndex][colIndex].isBomba()){
                //    return;
                //}
                System.out.println("mouse direito");
                mapa.modificaBadeira(rowIndex, colIndex);
                for (Node node : grid.getChildren()) {
                    if (node instanceof Button) {
                        int i = GridPane.getRowIndex(node);
                        int j = GridPane.getColumnIndex(node);
                        // if(mapa.mapa[i][j].isBomba()) ((Button) node).setText("X"); // vai mostrar os Xs
                        if (mapa.mapa[i][j].isBandeira() && mapa.mapa[i][j].isRevelado() == false){
                            ((Button) node).setText("B");
                            continue;
                        }
                        if (mapa.mapa[i][j].isRevelado() == false){
                            ((Button) node).setText(" ");
                            continue;
                        }
                        if (mapa.mapa[i][j].isRevelado()){
                            ((Button) node).setText("" + ((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes());
                            continue;
                        }
                    }
                }
                return;
            }
            mapa.abrirBloco(rowIndex, colIndex);

            mapa.mostraCampo();
            for (Node node : grid.getChildren()) {
                if (node instanceof Button) {
                    int i = GridPane.getRowIndex(node);
                    int j = GridPane.getColumnIndex(node);
                    // if(mapa.mapa[i][j].isBomba()) ((Button) node).setText("X"); // vai mostrar os Xs
                    if (mapa.mapa[i][j].isRevelado()){
                         ((Button) node).setText("" + ((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes());
                    }
                }
            }
            pane.setText(""+ mapa.abrirBloco(rowIndex, colIndex));

        });
        grid.add(pane, colIndex, rowIndex);
    }

    public void iniciaGrid(){
        System.out.println();
        int numCols = mapa.getColunas() ;
        int numRows = mapa.getLinhas() ;
        this.grid = new GridPane();

        for (int i = 0 ; i < numCols ; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            grid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0 ; i < numRows ; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            grid.getRowConstraints().add(rowConstraints);
        }
        for (int i = 0 ; i < numCols ; i++) {
            for (int j = 0; j < numRows; j++) {
                addPane(i, j);
            }
        }
    }


    public void abrirFacil(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(this.grid, 300, 300);

        this.iniciaGrid();
        stage.setScene(scene);
        stage.setTitle("NIVEL FACIL");
        stage.show();
    }
}