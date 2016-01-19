package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Lizenz_controller {

	@FXML private TextField idlizenz;
	@FXML private TextField typ;
	@FXML private TextField status;
	@FXML private TextField maintenanceinfo;
	@FXML private TextField rabatt;
	@FXML private DatePicker verkaufsdatum;
	@FXML private DatePicker ablaufdatum;
	@FXML private TextField lizenzcol;
	@FXML private TextField maintenanceid;
	@FXML private TextField produktid;
	@FXML private TextField perkusid;
	@FXML private TextField installationsschluessel;
	int idlizenztext;
	String typtext;
	String installationsschluesseltext;
	int statustext;
	int maintenanceinfotext;
	int rabatttext;
	Date verkaufsdatumtext;
	Date ablaufdatumtext;
	String lizenzcoltext;
	int maintenanceidtext;
	int produktidtext;
	int perkusidtext;
	
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		verkaufsdatumtext = Date.valueOf(verkaufsdatum.getValue());
		ablaufdatumtext = Date.valueOf(ablaufdatum.getValue());
		idlizenztext = Integer.parseInt(idlizenz.getText());
		lizenzcoltext = lizenzcol.getText();
		typtext = typ.getText();
		installationsschluesseltext = installationsschluessel.getText();
		statustext = Integer.parseInt(status.getText());
		maintenanceinfotext = Integer.parseInt(maintenanceinfo.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		maintenanceidtext = Integer.parseInt(maintenanceid.getText());
		produktidtext = Integer.parseInt(produktid.getText());
		perkusidtext = Integer.parseInt(perkusid.getText());

		java.sql.Connection conn = Connection.connecten();
		String query = "INSERT INTO Lizenz(idLizenz,Typ,Installationsschluessel,Status,MaintenanceInfo,"
				+ "Rabatt,Verkaufsdatum,Ablaufdatum,Lizenzcol,Maintenance_idMaintenance,"
				+ "Produkt_idProdukt"+ ",Perkus_idPerkus)"
				+ "values('"+idlizenztext+"','"+typtext+"','"+installationsschluesseltext+"'"
						+ ",'"+statustext+"','"+maintenanceinfotext+"','"+rabatttext+"','"
				+verkaufsdatumtext+"','"+ablaufdatumtext+"','"+lizenzcoltext+"','"+maintenanceidtext+"'"
						+ ",'"+produktidtext+"','"+perkusidtext+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Lizenz is completed.");
	}
	
	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idlizenztext = Integer.parseInt(idlizenz.getText());
		lizenzcoltext = lizenzcol.getText();
		typtext = typ.getText();
		installationsschluesseltext = installationsschluessel.getText();
		statustext = Integer.parseInt(status.getText());
		maintenanceinfotext = Integer.parseInt(maintenanceinfo.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		maintenanceidtext = Integer.parseInt(maintenanceid.getText());
		produktidtext = Integer.parseInt(produktid.getText());
		perkusidtext = Integer.parseInt(perkusid.getText());
		
		java.sql.Connection conn = Connection.connecten();
		String query = "UPDATE Lizenz SET Typ = '"+ typtext +"' WHERE idLizenz IN ("+idlizenztext+")";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Update at Table Lizenz is completed.");
	}
	
	public void delete() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		idlizenztext = Integer.parseInt(idlizenz.getText());
		lizenzcoltext = lizenzcol.getText();
		typtext = typ.getText();
		installationsschluesseltext = installationsschluessel.getText();
		statustext = Integer.parseInt(status.getText());
		maintenanceinfotext = Integer.parseInt(maintenanceinfo.getText());
		rabatttext = Integer.parseInt(rabatt.getText());
		maintenanceidtext = Integer.parseInt(maintenanceid.getText());
		produktidtext = Integer.parseInt(produktid.getText());
		perkusidtext = Integer.parseInt(perkusid.getText());
		
		java.sql.Connection conn = Connection.connecten();
		String query = "DELETE FROM Lizenz WHERE idLizenz = '"+ idlizenztext +"' AND Typ ='"+typtext+"'"
				+ " AND Installationsschlüssel ='"+installationsschluesseltext+"'"
				+ " AND Status ='"+statustext+"' AND Maintenance-Info'"+maintenanceinfotext+"'"
				+ " AND Rabatt ='"+rabatttext+"' AND Verkaufsdatum ='"+verkaufsdatumtext+"'"
				+ " AND Ablaufdatum ='"+ablaufdatumtext+"' AND Lizenzcol ='"+lizenzcoltext+"'"
				+ " AND Maintenance_idMaintenance ='"+maintenanceidtext+"'"
				+ " AND Produkt_idProdukt ='"+produktidtext+"' AND Perus_idPerkus ='"+perkusidtext+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Update at Table Lizenz is completed.");
	}
}
