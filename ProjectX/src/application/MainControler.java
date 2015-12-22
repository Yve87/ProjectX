package application;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainControler {
	
	auswahl_window window;
	Stage primaryStage = new Stage();
	
	public void Datenbank_modifizieren(){
		window = new auswahl_window();
		window.start(primaryStage);
	}
	
	public void angebot_erstellen(){
		DateiSchreiben datei = new DateiSchreiben();
		datei.schreibeString("Neues Angebot");
	}
}
