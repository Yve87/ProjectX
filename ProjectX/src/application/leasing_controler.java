package application;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class leasing_controler{
	
	// FXML fields
	@FXML private DatePicker VertragsdatumFXML;
	@FXML private DatePicker RechnungsdatumFXML;
	@FXML private TextField RechnungsbetragFXML;
	@FXML private TextField Anzahl_RechnungenFXML;
	@FXML private DatePicker Datum_letzter_RechnungsbetragFXML;
	@FXML private DatePicker Datum_naechster_RechnungsbetragFXML;
	@FXML private TextField NutzerzahlFXML;
	@FXML private TextField idLeasingFXML;
	
	// attributes of class leasing_controller
	Date Vertragsdatum;
	Date Rechnungsdatum;
	float Rechnungsbetrag;
	int Anzahl_Rechnungen;
	Date Datum_letzter_Rechnungsbetrag;
	Date Datum_naechster_Rechnungsbetrag;
	int Nutzerzahl;
	int idLeasing;
	
	ListView<Object> listview;
	
	// insert
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {	
		// get values entered in the FXML window in the attributes 
		Vertragsdatum = Date.valueOf(VertragsdatumFXML.getValue());	// get value of FXML in attribute
	    Rechnungsdatum = Date.valueOf(RechnungsdatumFXML.getValue());
	    Rechnungsbetrag = Float.parseFloat(RechnungsbetragFXML.getText());
	    Anzahl_Rechnungen = Integer.parseInt(Anzahl_RechnungenFXML.getText());
	    Datum_letzter_Rechnungsbetrag = Date.valueOf(Datum_letzter_RechnungsbetragFXML.getValue());
	    Datum_naechster_Rechnungsbetrag = Date.valueOf(Datum_naechster_RechnungsbetragFXML.getValue());
	    Nutzerzahl = Integer.parseInt(NutzerzahlFXML.getText());
	    idLeasing = Integer.parseInt(idLeasingFXML.getText());
	   
	    java.sql.Connection conn = Connection.connecten();	// connect database
	    String query = "INSERT INTO Leasing(Vertragsdatum, Rechnungsdatum, Rechungsbetrag, Anzahl_Rechnungen,"
	    		+ "Datum_letzter_Rechnungsbetrag, Datum_naechster_Rechnungsbetrag, Nutzerzahl, idLeasing)"
	    		+ "values('"+Vertragsdatum+"', '"+Rechnungsdatum+"', '"+Rechnungsbetrag+"'," // get values
	    		+ "'"+Anzahl_Rechnungen+"', '"+Datum_letzter_Rechnungsbetrag+"', "
	    		+ "'"+Datum_naechster_Rechnungsbetrag+"', '"+Nutzerzahl+"', '"+idLeasing+"' ";
	    // PreparedStatement for Connection and query
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.executeUpdate();			// execute preparedStatement
	    System.out.println("New INSERT into Table Leasing is completed");
	}
	
	// update
	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Vertragsdatum = Date.valueOf(VertragsdatumFXML.getValue());	// get value of FXML in attribute
	    Rechnungsdatum = Date.valueOf(RechnungsdatumFXML.getValue());
	    Rechnungsbetrag = Float.parseFloat(RechnungsbetragFXML.getText());
	    Anzahl_Rechnungen = Integer.parseInt(Anzahl_RechnungenFXML.getText());
	    Datum_letzter_Rechnungsbetrag = Date.valueOf(Datum_letzter_RechnungsbetragFXML.getValue());
	    Datum_naechster_Rechnungsbetrag = Date.valueOf(Datum_naechster_RechnungsbetragFXML.getValue());
	    Nutzerzahl = Integer.parseInt(NutzerzahlFXML.getText());
	    idLeasing = Integer.parseInt(idLeasingFXML.getText());
	    
	    java.sql.Connection conn = Connection.connecten();
	    String query = "UPDATE Leasing SET Vertragsdatum = '"+VertragsdatumFXML+"', Rechnungsdatum = "
	    		+ " '"+RechnungsbetragFXML+"', Rechungsbetrag = '"+RechnungsbetragFXML+"', "
	    				+ " Anzahl_Rechnungen = '"+Anzahl_RechnungenFXML+"', Datum_letzter_Rechnungsbetrag ="
	    				+ " '"+Datum_letzter_RechnungsbetragFXML+"', Datum_naechster_Rechnungsbetrag =  "
	    				+ " '"+Datum_naechster_RechnungsbetragFXML+"', Nutzerzahl = '"+NutzerzahlFXML+"',"
	    				+ " idLeasing = '"+idLeasingFXML+"' WHERE idLeasing IN ("+idLeasing+")";
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.executeUpdate();			// execute preparedStatement
	    System.out.println("New UPDATE of Table Leasing is completed");
	}
	
	public void delete () {
		Vertragsdatum = Date.valueOf(VertragsdatumFXML.getValue());	// get value of FXML in attribute
	    Rechnungsdatum = Date.valueOf(RechnungsdatumFXML.getValue());
	    Rechnungsbetrag = Float.parseFloat(RechnungsbetragFXML.getText());
	    Anzahl_Rechnungen = Integer.parseInt(Anzahl_RechnungenFXML.getText());
	    Datum_letzter_Rechnungsbetrag = Date.valueOf(Datum_letzter_RechnungsbetragFXML.getValue());
	    Datum_naechster_Rechnungsbetrag = Date.valueOf(Datum_naechster_RechnungsbetragFXML.getValue());
	    Nutzerzahl = Integer.parseInt(NutzerzahlFXML.getText());
	    idLeasing = Integer.parseInt(idLeasingFXML.getText());
	    
	    java.sql.Connection conn = Connection.connecten();
	    String query = "DELETE from Leasing "
	}
	

	
	public void show(){
		listview = new ListView<>();
	}

}
