package application;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Date;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Rechnung_Between_Controller implements Initializable{
	
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
	int rechnungsid;
	Date rechnungsdatum;
	int bestellnummer;
	int lieferscheinid;
	int vorgaengerrechnung;
	int bezahlt;
	ListView<Object> listview;
	
	public void rechnung_erstellen() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		rechnungsdatum = Date.valueOf(rechnungdatum.getValue());
		fikusnametext = fikusname.getText();
		produktnametext = produktname.getText();
		perkusnametext = perkusname.getText();
		standortnametext = standortname.getText();
		preistext = Integer.parseInt(preis.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		rechnungsid = 1;
		java.sql.Connection conn = Connection.connecten();
		String query1 = "SELECT Name FROM Fikus WHERE Name='"+fikusnametext+"'";
		String query2 = "SELECT * FROM Produkt WHERE Name='"+produktnametext+"'";
		String query3 = "SELECT * FROM Perkus WHERE Name='"+perkusnametext+"'";
		String query4 = "SELECT * FROM Standort WHERE Name='"+standortnametext+"'";
		String query5 = "SELECT * FROM Produkt WHERE Listenpreis='"+preistext+"'";
		String query6 = "SELECT * FROM Lizenz WHERE Rabatt='"+rabatttext+"'";
		String query7 = "INSERT INTO Rechnung(idRechnung,Rechnungsdatum,Vorgängerrechnung,"
				+ "Bezahlt,Betrag,Lieferantennummer,Bestellnummer,Lieferschein_idLieferschein)"
				+ "values('"+rechnungsid+"','"+rechnungsdatum+"','"+vorgaengerrechnung+"',"
				+ "'"+bezahlt+"','"+preistext+"','"
				+ ""+bestellnummer+"','"+lieferscheinid+"')";
		String query8 = "SELECT * FROM Rechnung WHERE idRechnung";

		PreparedStatement stmt1 = conn.prepareStatement(query1);
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		PreparedStatement stmt3 = conn.prepareStatement(query3);
		PreparedStatement stmt4 = conn.prepareStatement(query4);
		PreparedStatement stmt5 = conn.prepareStatement(query5);
		PreparedStatement stmt6 = conn.prepareStatement(query6);
		PreparedStatement stmt7 = conn.prepareStatement(query7);
		PreparedStatement stmt8 = conn.prepareStatement(query8);
		
		stmt1.executeQuery();
		stmt2.executeQuery();
		stmt3.executeQuery();
		stmt4.executeQuery();
		stmt5.executeQuery();
		stmt6.executeQuery();
		stmt7.executeUpdate();
		stmt8.executeQuery();
		
		Rechnungschreiben datei = new Rechnungschreiben();
		datei.schreibeString("Neue Rechnung "+ rechnungsdatum +"\n");
		datei.schreibeString(+rechnungsid+". Rechnung: \n Produktname: " + produktnametext + "\n Firmenkunde: " 
		+fikusnametext+"\n Person:"+perkusnametext+"\n Price: "+preistext+ "\n Rabatt: "
				+rabatttext);
	
		System.out.println("New Rechnung is ready.");
	}
	
	public void show(){
		listview = new ListView<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.sql.Connection conn;
		try {
			conn = Connection.connecten();
			String query = "SELECT * FROM Rechnung";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
