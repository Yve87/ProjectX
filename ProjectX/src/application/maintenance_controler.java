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

public class maintenance_controler implements Initializable{
	
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
		listview = new ListView<>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		java.sql.Connection conn;
		try {
			conn = Connection.connecten();
			String query = "SELECT * FROM Maintenance";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet set = stmt.executeQuery();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}