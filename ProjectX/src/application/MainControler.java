package application;

import javafx.stage.Stage;

public class MainControler {
	
	auswahl_window window;
	Stage primaryStage = new Stage();
	
	public void Datenbank_modifizieren(){
		window = new auswahl_window();
		window.start(primaryStage);
	}
}
