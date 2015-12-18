package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class perkus_insert_controller {
	
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
	@FXML private Button button;
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
		String query = "INSERT INTO Perkus(idPerkus,Name,Fikus_idFikus)" + "values('"+ids+"','"+nametext+"','"+idfikus+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Perkus is completed.");
	}
}