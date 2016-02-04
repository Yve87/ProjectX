package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Yve
 *
 */
public class PeopleCustomers_Controller {
	
	@FXML private TextField id;
	@FXML private TextField name;
	@FXML private TextField vorname;
	@FXML private TextField anrede;
	@FXML private TextField titel;
	@FXML private TextField abteilung;
	@FXML private TextField gebaeudenummer;
	@FXML private TextField zimmernummer;
	@FXML private TextField tel;
	@FXML private TextField fax;
	@FXML private TextField email;
	@FXML private TextField position;
	@FXML private TextField fikusid;
	private String idtext;
	private String idtextf;
	private String nametext;
	private String anredetext;
	private String vornametext;
	private String titeltext;
	private String abteilungtext;
	private String gebaeudenummertext;
	private String zimmernummertext;
	private String teltext;
	private String faxtext;
	private String emailtext;
	private String positiontext;
	private int ids;
	private int idfikus;
	
	@FXML
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = id.getText();
		nametext = name.getText();
		anredetext = anrede.getText();
		vornametext = vorname.getText();
		titeltext = titel.getText();
		abteilungtext = abteilung.getText();
		gebaeudenummertext = gebaeudenummer.getText();
		zimmernummertext = zimmernummer.getText();
		teltext = tel.getText();
		faxtext = fax.getText();
		emailtext = email.getText();
		positiontext = position.getText();
		idtextf = fikusid.getText();
		
		ids = Integer.parseInt(idtext);
		idfikus = Integer.parseInt(idtextf);
		java.sql.Connection conn = Connection.connecten();
		String query = "INSERT INTO Perkus(idPerkus,Name,Anrede,Vorname,Titel,"
				+ "Abteilung,Gebaeudenummer,Zimmernummer,Tel,Fax,Email,Position,Fikus_idFikus)"
				+ "values('"+ids+"','"+nametext+"','"+anredetext+"','"+vornametext+"','"
				+titeltext+"','"+abteilungtext+"','"+gebaeudenummertext+"','"
				+zimmernummertext+"','"+teltext+"','"+faxtext+"','"+emailtext+"','"
				+positiontext+"','"+idfikus+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Perkus is completed.");
	}
	
	@FXML
	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = fikusid.getText();
		nametext = name.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "UPDATE Perkus SET Name = '"+ nametext +"' WHERE Fikus_idFikus IN ("+ids+")";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("Update at Table Perkus is completed.");
	}
	
	@FXML
	public void delete() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = id.getText();
		nametext = name.getText();
		anredetext = anrede.getText();
		vornametext = vorname.getText();
		titeltext = titel.getText();
		abteilungtext = abteilung.getText();
		gebaeudenummertext = gebaeudenummer.getText();
		zimmernummertext = zimmernummer.getText();
		teltext = tel.getText();
		faxtext = fax.getText();
		emailtext = email.getText();
		positiontext = position.getText();
		idtextf = fikusid.getText();
		
		ids = Integer.parseInt(idtext);
		idfikus = Integer.parseInt(idtextf);
		java.sql.Connection conn = Connection.connecten();
		String query = "DELETE FROM Perkus WHERE idPerkus ='"+ids+"' AND Name ='"+nametext+"' AND"
				+ " AND Anrede ='"+anredetext+"' AND Vorname ='"+vornametext+"' AND Titel ='"
				+titeltext+"' AND Abteilung ='"+abteilungtext+"' AND Gebaeudenummer ='"+gebaeudenummertext+"'"
						+ " AND Zimmernummer ="+zimmernummertext+"' AND Tel ='"+teltext+"' AND "
								+ " Fax ='"+faxtext+"' Email ='"+emailtext+"' AND Position ='"+positiontext+"'"
										+ " AND Fikus_idFikus ='"+idfikus+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Delete at Table Perkus is completed.");
	}
	
	@FXML
	public void show(){
		Stage primarystage = new Stage();
		ShowWindow window = new ShowWindow();
		window.start(primarystage);
	}
}

// alerts : meldung warning,
// man kann keine fikus l�schen
// ausf�hrbare jar Datei. artefakte, dependencies
// main. build artefacts