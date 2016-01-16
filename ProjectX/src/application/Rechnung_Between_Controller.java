package application;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Rechnung_Between_Controller {
	
	@FXML private TextField fikusname;
	@FXML private TextField produktname;
	@FXML private TextField perkusname;
	@FXML private TextField standortname;
	@FXML private TextField preis;
	@FXML private TextField rabatt;
	@FXML private DatePicker rechnungdatum;
	String fikusnametext;
	String perkusnametext;
	String produktnametext;
	String standortnametext;
	int preistext;
	int rabatttext;
	int rechnungsid = 0;
	Date rechnungsdatum;
	int lieferantennummer;
	int bestellnummer;
	int lieferscheinid;

	public void rechnung_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		rechnungsdatum = Date.valueOf(rechnungdatum.getValue());
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
		String query5 = "SELECT Produkt WHERE Listenpreis='"+ preistext+"'";
		String query6 = "SELECT Lizenz WHERE Rabatt='"+ rabatttext+"'";
		//String query7 ="SELECT Rechnung FROM idRechnung";
		PreparedStatement stmt1 = conn.prepareStatement(query1);
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		PreparedStatement stmt4 = conn.prepareStatement(query4);
		PreparedStatement stmt5 = conn.prepareStatement(query5);
		PreparedStatement stmt6 = conn.prepareStatement(query6);
		//PreparedStatement stmt7 = conn.prepareStatement(query7);
		stmt1.executeUpdate();
		stmt2.executeUpdate();
		stmt3.executeUpdate();
		stmt4.executeUpdate();
		stmt5.executeUpdate();
		stmt6.executeUpdate();
		//rechnungsid = stmt7.executeUpdate();
		rechnungsid ++;
		
		AngebotSchreiben datei = new AngebotSchreiben();
		datei.schreibeString("Neue Rechnung\n");
		datei.schreibeString(+rechnungsid+". Rechnung: \n Produktname: " + produktnametext + "\n Firmenkunde: " 
		+fikusnametext+"\n Person:"+perkusnametext+"\n Price: "+preistext+ "\n Rabatt: "
				+rabatttext);
	
		System.out.println("New Rechnung is ready.");
	}
}
