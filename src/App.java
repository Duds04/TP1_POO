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

            // for (int i = 0 ; i < numCols ; i++) {
            //     for (int j = 0; j < numRows; j++) {
            //         addPane(i, j);
                    
            //     }
            // }
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
        //     for(i=0;i<mapa.getLinhas();i++){
        //     for(j=0;j<mapa.getColunas();j++){
        //         if(mapa.isRevelado(i, j)){
        //             for (javafx.scene.Node node : grid.getChildren()) {
        //                 if (GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == i
        //                         && GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) == j
        //                         && node instanceof Button) {
        //                             ((Button) node).setText("a");

        //             }
        //         }
        //     }
        // }
            for (Node node : grid.getChildren()) {
                if (node instanceof Button) {
                    int i = GridPane.getRowIndex(node);
                    int j = GridPane.getColumnIndex(node);
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
                    // Button pane = new Button(" ");
                    // pane.setPrefSize(30, 30);
                    // pane.setOnMouseClicked(event -> {
                    //         // Set the text of all buttons to "a"
                    //         pane.setText("ds");
                    //         pane.setText("" + ((CampoSemBomba)mapa.mapa[rowIndex][colIndex]).getBombasAdjacentes());
                    //         // setButtonTexts(grid, "a");
                    //         for (Node node : grid.getChildren()) {
                    //             if (node instanceof Button) {
                    //                 ((Button) node).setText("a");
                    //             }
                    //         }
                    // });
                    // grid.add(pane, colIndex, rowIndex);
                    addPane(i, j);
                }
            }
        }


        private void setButtonTexts(GridPane gridPane, String text) {
            for (Node node : gridPane.getChildren()) {
                if (node instanceof Button) {
                    ((Button) node).setText(text);
                }
            }
        }

        public void abrirFacil(ActionEvent event) throws IOException {
            // mapa = new Mapa("FACIL");
            // GridPane root = FXMLLoader.load(getClass().getResource("mapaFacin.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            // stage.setScene(new Scene(root, 800, 800));


            Scene scene = new Scene(this.grid, 300, 300);
            // for (int i = 0; i < 8; i++){
            // 	for (int j = 0; j < 8; j++){
            // 		Button button = new Button(" ");
            // 		root.add(button, i, j);
            // 		root.setVgap(10);
            // 		root.setHgap(10);
            // 	}
            // }
            this.iniciaGrid();
            // this.mapa = new Mapa("FACIL");
            stage.setScene(scene);
            stage.setTitle("NIVEL FACIL");
            stage.show();
        }
       
    }
/*
 * 
 * 
 * 
 * 
 * 
 * 

import java.io.IOException;

import GameClasses.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class controlerDifficult {

    @FXML
    private GridPane grid ;
    Mapa mapa;
    private Stage stage;
    private Scene scene;
    private Parent root;
        
    
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

        for (int i = 0 ; i < numCols ; i++) {
            for (int j = 0; j < numRows; j++) {
                addPane(i, j);
                
            }
        }
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

    private void addPane(int colIndex, int rowIndex) {
        Button pane = new Button(" ");
        pane.setPrefSize(30, 30);
        pane.setOnMouseClicked(e -> {
            System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
            mapa.abrirBloco(rowIndex, colIndex);
            atualizaPane();
        });
        grid.add(pane, colIndex, rowIndex);
    }

    private void atualizaPane(){
        int i, j;
        Button aux;
        for(i=0;i<mapa.getLinhas();i++){
            for(j=0;j<mapa.getColunas();j++){
                if(mapa.isRevelado(i, j)){
                    for (javafx.scene.Node node : grid.getChildren()) {
                        if (GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) == i
                                && GridPane.getColumnIndex(node) != null && GridPane.getColumnIndex(node) == j
                                && node instanceof Button) {
                            aux = (Button) node;
                            aux.setText(""+mapa.contaBomba(i,j));
                        }
                    }
                }
            }
        }
    }

    public void abrirFacil(ActionEvent event) throws IOException {
        mapa = new Mapa("FACIL");
        // GridPane root = FXMLLoader.load(getClass().getResource("mapaFacin.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // stage.setScene(new Scene(root, 800, 800));


		Scene scene = new Scene(this.grid, 300, 300);
		// for (int i = 0; i < 8; i++){
		// 	for (int j = 0; j < 8; j++){
		// 		Button button = new Button(" ");
		// 		root.add(button, i, j);
		// 		root.setVgap(10);
		// 		root.setHgap(10);
		// 	}
        // }
        this.iniciaGrid();
		// this.mapa = new Mapa("FACIL");
        stage.setScene(scene);
		stage.setTitle("NIVEL FACIL");
		stage.show();

    }
    public void abrirMedio(ActionEvent event) throws IOException {
        Mapa mapa = new Mapa("MEDIO");
		root = FXMLLoader.load(getClass().getResource("mapaMedio.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        int numCols = 14;
        int numRows = 14;
        for (int i = 0 ; i < numCols ; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            this.grid.getColumnConstraints().add(colConstraints);
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
        stage.setScene(scene);
        stage.show();
		mapa.geraMapa("medio");
    }
    public void abrirDificil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("medioDificil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
		mapa.geraMapa("dificil");
    }
    
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void mouseEntered(MouseEvent e) {
        Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
    }
}

 */