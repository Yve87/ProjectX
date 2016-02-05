package application;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class LeasingWindow_Controller {
	
	// FXML fields
	@FXML private DatePicker VertragsdatumFXML;
	@FXML private DatePicker RechnungsdatumFXML;
	@FXML private TextField RechnungsbetragFXML;
	@FXML private TextField Anzahl_RechnungenFXML;
	@FXML private DatePicker Datum_letzter_RechnungsbetragFXML;
	@FXML private DatePicker Datum_naechster_RechnungsbetragFXML;
	@FXML private TextField NutzerzahlFXML;
	@FXML private TextField idLeasingFXML;
	@FXML private TextField idProdukt;
	@FXML private TextField idPerkus;
	@FXML private TextField idFikus;
	
	// attributes of class leasing_controller
	Date Vertragsdatum;
	Date Rechnungsdatum;
	float Rechnungsbetrag;
	int Anzahl_Rechnungen;
	Date Datum_letzter_Rechnungsbetrag;
	Date Datum_naechster_Rechnungsbetrag;
	int Nutzerzahl;
	int idLeasing;
	int idp;
	int idpe;
	int idf;
	
	// insert
	@FXML
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
	    idp = Integer.parseInt(idProdukt.getText());
	    idpe = Integer.parseInt(idPerkus.getText());
	    idf = Integer.parseInt(idFikus.getText());
	   
	    java.sql.Connection conn = Connection.connecten();	// connect database
	    String query = "INSERT INTO Leasing(Vertragsbeginn,Rechnungsdatum,Rechnungsbetrag,Anzahl_Rechnungen,"
	    		+ "Datum_letzter_Rechnungsbetrag,Datum_naechster_Rechnungsbetrag,Nutzerzahl,idLeasing,"
	    		+ "Produkt_idProdukt,Perkus_idPerkus,Fikus_idFikus)"
	    		+ "values('"+Vertragsdatum+"','"+Rechnungsdatum+"','"+Rechnungsbetrag+"'," // get values
	    		+ "'"+Anzahl_Rechnungen+"','"+Datum_letzter_Rechnungsbetrag+"',"
	    		+ "'"+Datum_naechster_Rechnungsbetrag+"','"+Nutzerzahl+"','"+idLeasing+"','"+idp+"','"
	    		+idpe+"','"+idf+"')";
	    // PreparedStatement for Connection and query
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.executeUpdate();			// execute preparedStatement
	    System.out.println("New INSERT into Table Leasing is completed");
	    
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Leasing has been inserted!");
        alert.showAndWait();
	}
	
	// update
	@FXML
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
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Leasing has been updated!");
        alert.showAndWait();
	}
	
	@FXML
	public void delete () throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Vertragsdatum = Date.valueOf(VertragsdatumFXML.getValue());	// get value of FXML in attribute
	    Rechnungsdatum = Date.valueOf(RechnungsdatumFXML.getValue());
	    Rechnungsbetrag = Float.parseFloat(RechnungsbetragFXML.getText());
	    Anzahl_Rechnungen = Integer.parseInt(Anzahl_RechnungenFXML.getText());
	    Datum_letzter_Rechnungsbetrag = Date.valueOf(Datum_letzter_RechnungsbetragFXML.getValue());
	    Datum_naechster_Rechnungsbetrag = Date.valueOf(Datum_naechster_RechnungsbetragFXML.getValue());
	    Nutzerzahl = Integer.parseInt(NutzerzahlFXML.getText());
	    idLeasing = Integer.parseInt(idLeasingFXML.getText());
	    
	    java.sql.Connection conn = Connection.connecten();
	    String query = "DELETE FROM Leasing WHERE idLeasing ='"+ idLeasing +"'";
	    PreparedStatement stmt = conn.prepareStatement(query);
	    stmt.executeUpdate();			// execute preparedStatement
	    System.out.println("Delete of Table Leasing is completed");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Leasing has been deleted!");
        alert.showAndWait();
	}

	@FXML
	public void show(){
	
		Stage primarystage = new Stage();
		Show_Window window = new Show_Window();
		window.start(primarystage);
	}
	
	public void back(){
		Stage primaryStage = new Stage();
		BetweenWindow window = new BetweenWindow();
		window.start(primaryStage);
		LeasingWindow.stage8.close();
	}

}
