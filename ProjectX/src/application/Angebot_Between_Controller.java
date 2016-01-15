package application;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Angebot_Between_Controller {
	
	@FXML private TextField fikusname;
	@FXML private TextField produktname;
	@FXML private TextField perkusname;
	@FXML private TextField standortname;
	@FXML private TextField preis;
	@FXML private TextField rabatt;
	Angebot_Between_Window window;
	Stage primaryStage = new Stage();
	String fikusnametext;
	String perkusnametext;
	String produktnametext;
	String standortnametext;
	int preistext;
	int rabatttext;
	
	public void Angebot_Eingabe(){
		window = new Angebot_Between_Window();
		window.start(primaryStage);
	}
	
	public void angebot_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		fikusnametext = fikusname.getText();
		produktnametext = produktname.getText();
		perkusnametext = perkusname.getText();
		standortnametext = standortname.getText();
		preistext = Integer.parseInt(preis.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		
		java.sql.Connection conn = Connection.connecten();
		String query1 = "SELECT Fikus WHERE Name='"+ fikusnametext+"'";
		String query2 = "SELECT Produkt WHERE Name='"+ produktnametext+"'";
		String query3 = "SELECT Perkus WHERE Name='"+ perkusnametext+"'";
		String query4 = "SELECT Standort WHERE Name='"+ standortnametext+"'";
		String query5 = "SELECT Produkt WHERE Preis='"+ preistext+"'";
		String query6 = "SELECT Produkt WHERE Rabatt='"+ rabatttext+"'";
		PreparedStatement stmt1 = conn.prepareStatement(query1);
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		PreparedStatement stmt4 = conn.prepareStatement(query4);
		PreparedStatement stmt5 = conn.prepareStatement(query5);
		PreparedStatement stmt6 = conn.prepareStatement(query6);
		stmt1.executeUpdate();
		stmt2.executeUpdate();
		stmt3.executeUpdate();
		stmt4.executeUpdate();
		stmt5.executeUpdate();
		stmt6.executeUpdate();
		
		AngebotSchreiben datei = new AngebotSchreiben();
		datei.schreibeString("Neues Angebot\n");
		datei.schreibeString("1. Angebot: \n Produktname: " + produktnametext + "\n Firmenkunde: " 
		+fikusnametext+"\n Person:"+perkusnametext+"\n Price: "+preistext+ "\n Rabatt: "
				+rabatttext);
		
		System.out.println("New Advertisement is ready.");
	}
}
