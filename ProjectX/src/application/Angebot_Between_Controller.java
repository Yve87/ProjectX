package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Angebot_Between_Controller {
	
	Angebot_Between_Window window;
	Stage primaryStage = new Stage();
	
	public void Angebot_Eingabe(){
		window = new Angebot_Between_Window();
		window.start(primaryStage);
	}
}
