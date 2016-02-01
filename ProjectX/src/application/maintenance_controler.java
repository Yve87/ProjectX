package application;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class maintenance_controler {
	
	@FXML TextField maintenanceid;
	@FXML DatePicker gueltigkeit;
	@FXML TextField betrag;
	int idtext;
	Date gueltigkeittext;
	float betragtext;
	LocalDate localdate;
	ListView<Object> listview;
	
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		gueltigkeittext = Date.valueOf(gueltigkeit.getValue());
		betragtext = Float.parseFloat(betrag.getText());
		idtext = Integer.parseInt(maintenanceid.getText());
		java.sql.Connection conn = Connection.connecten();
		String query = "INSERT INTO Maintenance(idMaintenance,Gueltigkeit,Betrag)" 
		+ "values('"+idtext+"','"+gueltigkeittext+"','"+betragtext+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Lizenz is completed.");
	}
	
	public void update(){
		
		
	}
	
	public void delete(){
		
	}
	
	public void search(){
		
	}
	
	public void show(){
		Stage primarystage = new Stage();
		showwindow window = new showwindow();
		window.start(primarystage);
	}
}
