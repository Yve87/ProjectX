package application;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainControler {
	
	Between_Window window;
	Lieferschein_Between_Window window1;
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
		window1 = new Lieferschein_Between_Window();
		window1.start(primaryStage);
		Lieferscheinschreiben datei = new Lieferscheinschreiben();
		datei.schreibeString("Neuer Lieferschein");
	}
}
