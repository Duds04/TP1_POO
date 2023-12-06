

import java.io.IOException;

import GameClasses.Mapa;
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
        

    public void initialize() {
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

    private void addPane(int colIndex, int rowIndex) {
        Button pane = new Button();
        pane.setOnMouseClicked(e -> {
            System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
        });
        grid.add(pane, colIndex, rowIndex);
    }


    public void abrirFacil(ActionEvent event) throws IOException {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();


		Scene scene = new Scene(this.grid, 300, 300);
		// for (int i = 0; i < 8; i++){
		// 	for (int j = 0; j < 8; j++){
		// 		Button button = new Button(" ");
		// 		root.add(button, i, j);
		// 		root.setVgap(10);
		// 		root.setHgap(10);
		// 	}
        // }
        this.initialize();
		// this.mapa = new Mapa("FACIL");
		stage.setScene(scene);
		stage.setTitle("NIVEL FACIL");
		stage.show();

    }
    public void abrirMedio(ActionEvent event) throws IOException {
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
