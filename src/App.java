import java.io.IOException;

import GameClasses.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{
    Mapa mapa;
    private GridPane grid ;
    private Stage stage;
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
                
                grid.setStyle("-fx-background-color: rgb(" + 150 + "," + 150 + ", " + 150 + ");");
                Scene scene = new Scene(grid, 620, 450);
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
                
                grid.setStyle("-fx-background-color: gray;");
                Scene scene = new Scene(grid, 1000, 900);
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
    
                grid.setStyle("-fx-background-color: gray;");
                Scene scene = new Scene(grid, 1700, 1000);
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

            root.setStyle("-fx-background-color: lightgray;");
            root.getChildren().add(caixaTexto);
            root.getChildren().add(caixaBotoes);
            Scene scene = new Scene(root, 400, 400);
            Image icone = new Image("bomb1.png");
            stage.getIcons().add(icone);
            stage.setScene(scene);
            stage.setTitle("Campo Minado");
            stage.show();
    }

    
    private void addPane(int colIndex, int rowIndex) {
        Button pane = new Button(" ");
        pane.setStyle("-fx-background-color: gray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");
        pane.setPrefSize(80, 80);
        pane.setOnMouseClicked(e -> {
            System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);

            if (mapa.mapa[rowIndex][colIndex].isBandeira() && e.getButton() == MouseButton.PRIMARY){
                return;
            }

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
                Image icone = new Image("bomb1.png");
                stagePerdeu.getIcons().add(icone);
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
                Image icone = new Image("bomb1.png");
                stageGanhou.getIcons().add(icone);
                // Show the new stage
                Stage stageAtual = (Stage) pane.getScene().getWindow();
                stageAtual.close();
                stageGanhou.show();
            }

            if (e.getButton() == MouseButton.SECONDARY){
                System.out.println("mouse direito");
                mapa.modificaBadeira(rowIndex, colIndex);
                for (Node node : grid.getChildren()) {
                    if (node instanceof Button) {
                        int i = GridPane.getRowIndex(node);
                        int j = GridPane.getColumnIndex(node);
                        // if(mapa.mapa[i][j].isBomba()) ((Button) node).setText("X"); // vai mostrar os Xs
                        if (mapa.mapa[i][j].isBandeira() && mapa.mapa[i][j].isRevelado() == false){

                            Image imagemBandeira = new Image("imagemBandeira.png");
                            ImageView viewBandeira = new ImageView(imagemBandeira);
                            viewBandeira.setFitWidth(40);
                            viewBandeira.setFitHeight(40);
                            ((Button) node).setGraphic(viewBandeira);
                            continue;
                        }
                        if (mapa.mapa[i][j].isRevelado() == false){
                            ((Button) node).setGraphic(null);
                            //((Button) node).setText(" ");
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
                        if (((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes() == 0) ((Button) node).setStyle("-fx-text-fill: black; -fx-font-size: 20px; -fx-background-color: lightgray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");
                        else if (((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes() == 1) ((Button) node).setStyle("-fx-text-fill: blue; -fx-font-size: 20px; -fx-background-color: lightgray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");
                        else if (((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes() == 2) ((Button) node).setStyle("-fx-text-fill: green; -fx-font-size: 20px; -fx-background-color: lightgray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");
                        else if (((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes() == 3) ((Button) node).setStyle("-fx-text-fill: red; -fx-font-size: 20px; -fx-background-color: lightgray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");
                        else if (((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes() == 4) ((Button) node).setStyle("-fx-text-fill: darkblue; -fx-font-size: 20px; -fx-background-color: lightgray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");
                        else if (((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes() == 5) ((Button) node).setStyle("-fx-text-fill: brown; -fx-font-size: 20px; -fx-background-color: lightgray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");
                        else if (((CampoSemBomba) mapa.mapa[i][j]).getBombasAdjacentes() == 6) ((Button) node).setStyle("-fx-text-fill: orange; -fx-font-size: 20px; -fx-background-color: lightgray; -fx-border-color: rgb(" + 100 + "," + 100 + ", " + 100 + ")");

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