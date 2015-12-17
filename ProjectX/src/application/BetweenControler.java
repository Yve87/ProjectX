package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class BetweenControler {
	
	public void fikus_button(){
		
		Stage primarystage = new Stage();
		Fikus_Window window = new Fikus_Window();
		window.start(primarystage);
	}
}
