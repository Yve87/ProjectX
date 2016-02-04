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

public class MaintenanceWindow_Controller {
	
	@FXML TextField maintenanceid;
	@FXML DatePicker gueltigkeit;
	@FXML TextField betrag;
	int idtext;
	Date gueltigkeittext;
	float betragtext;
	LocalDate localdate;
	ListView<Object> listview;
	
	@FXML
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
	
	@FXML
	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		gueltigkeittext = Date.valueOf(gueltigkeit.getValue());
		betragtext = Float.parseFloat(betrag.getText());
		idtext = Integer.parseInt(maintenanceid.getText());
		java.sql.Connection conn = Connection.connecten();
		String query = "UPDATE Maintenance SET Betrage = '"+ betragtext +"' WHERE idMaintenance IN ("+idtext+")";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Update at Table Maintenance is completed.");
	}
	
	@FXML
	public void delete() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		gueltigkeittext = Date.valueOf(gueltigkeit.getValue());
		betragtext = Float.parseFloat(betrag.getText());
		idtext = Integer.parseInt(maintenanceid.getText());
		java.sql.Connection conn = Connection.connecten();
		String query = "DELETE FROM Maintenance WHERE idMaintenance = '"+ idtext +"'";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("Delete at Table Maintenance is completed.");
	}
	
	@FXML
	public void show(){
		Stage primarystage = new Stage();
		ShowWindow window = new ShowWindow();
		window.start(primarystage);
	}
	
	public void back(){
		Stage primaryStage = new Stage();
		BetweenWindow window = new BetweenWindow();
		window.start(primaryStage);
		MaintenanceWindow.stage5.close();
	}
}
