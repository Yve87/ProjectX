package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class perkus_update_controller {
	
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
	private String nametext;
	private int ids;
	
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
}
