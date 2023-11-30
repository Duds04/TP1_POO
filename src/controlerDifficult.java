

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class controlerDifficult {
    @FXML
	
	public void setDificuldadeFacil(ActionEvent e) {
		
		System.out.println("Facil");	
	}
	// Os elementos dos fxmls possuem sets
	public void setDificuldadeMedio(ActionEvent e) {
		System.out.println("Medio");	
	}
	public void setDificuldadeDificil(ActionEvent e) {
		System.out.println("Dificil");	
	}
}
