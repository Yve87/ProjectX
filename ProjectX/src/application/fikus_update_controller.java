package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class fikus_update_controller {
	
	@FXML private TextField name; 
	@FXML private TextField id;
	@FXML private Button button;
	private String idtext;
	private String nametext;
	private int ids;
	
	@FXML
	public void updaten() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idtext = id.getText();
		nametext = name.getText();
		ids = Integer.parseInt(idtext);
		java.sql.Connection conn = Connection.connecten();
		String query = "UPDATE Fikus SET Name = '"+ nametext +"' WHERE idFikus IN ("+ids+")";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("Update at Table Fikus is completed.");
	}
}