package application;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainControler {
	
	Between_Window window;
	Stage primaryStage = new Stage();
	
	
	public void Datenbank_modifizieren(){
		window = new Between_Window();
		window.start(primaryStage);
	}
	
	public void angebot_erstellen(){
		AngebotSchreiben datei = new AngebotSchreiben();
		datei.schreibeString("Neues Angebot");
	}
	
	public void rechnung_erstellen(){
		Rechnungschreiben datei = new Rechnungschreiben();
		datei.schreibeString("Neue Rechnung");
	}
	
	public void leiferschein_erstellen(){
		Lieferscheinschreiben datei = new Lieferscheinschreiben();
		datei.schreibeString("Neuer Lieferschein");
	}
}
