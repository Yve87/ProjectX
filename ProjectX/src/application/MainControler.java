package application;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainControler {
	
	Between_Window window;
	Lieferschein_Between_Window window1;
	Rechnung_Between_Window window2;
	Angebot_Between_Window window3;
	showwindow window4;
	Stage primaryStage = new Stage();
	
	
	public void Datenbank_modifizieren(){
		window = new Between_Window();
		window.start(primaryStage);
	}
	
	public void angebot_erstellen(){
		window3 = new Angebot_Between_Window();
		window3.start(primaryStage);
	}
	
	public void rechnung_erstellen(){
		window2 = new Rechnung_Between_Window();
		window2.start(primaryStage);
	}
	
	public void leiferschein_erstellen(){
		window1 = new Lieferschein_Between_Window();
		window1.start(primaryStage);
	}
	
	public void show(){
		window4 = new showwindow();
		window4.start(primaryStage);	
	}
	
}
