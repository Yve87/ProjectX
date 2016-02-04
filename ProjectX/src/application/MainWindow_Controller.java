package application;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainWindow_Controller {
	
	BetweenWindow window;
	DeliveryNoteWindow window1;
	InvoiceWindow window2;
	OfferWindow window3;
	PreviousDocumentWindow window4;
	Stage primaryStage = new Stage();
	
	
	public void Datenbank_modifizieren(){
		window = new BetweenWindow();
		window.start(primaryStage);
		MainWindow.stage.close();
	}
	
	public void angebot_erstellen(){
		window3 = new OfferWindow();
		window3.start(primaryStage);
		MainWindow.stage.close();
	}
	
	public void rechnung_erstellen(){
		window2 = new InvoiceWindow();
		window2.start(primaryStage);
		MainWindow.stage.close();
	}
	
	public void leiferschein_erstellen(){
		window1 = new DeliveryNoteWindow();
		window1.start(primaryStage);
		MainWindow.stage.close();
	}
	
	public void show(){
		window4 = new PreviousDocumentWindow();
		window4.start(primaryStage);
		MainWindow.stage.close();
	}
	
}
