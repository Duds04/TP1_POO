import java.io.IOException;

import GameClasses.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class App extends Application{
    Mapa mapa;
    private GridPane grid ;
    private Stage stage;
    private Scene scene;
    private Parent root;
            
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
            grid = new GridPane();
            mapa = new Mapa("FACIL");
            // Add buttons to the grid pane
            iniciaGrid();
    
            Scene scene = new Scene(grid, 300, 200);
            stage.setScene(scene);
            stage.setTitle("Button GridPane Example");
            stage.show();

    }    
    private void addPane(int colIndex, int rowIndex) {
        Button pane = new Button(" ");
        pane.setPrefSize(30, 30);
        pane.setOnMouseClicked(e -> {
            System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
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