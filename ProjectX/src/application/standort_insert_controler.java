package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class standort_insert_controler {
	
	@FXML private TextField standortid;
	@FXML private TextField name;
	@FXML private TextField strasse;
	@FXML private TextField hausnummer;
	@FXML private TextField plz;
	@FXML private TextField pls;
	@FXML private TextField postfachnummer;
	@FXML private TextField telefon;
	@FXML private TextField fikusid;
	@FXML private TextField perkusid;
	private int ids;
	private String nametext;
	private String strassetext;
	private int hntext;
	private int plztext;
	private int plstext;
	private int pfntext;
	private int tel;
	private int fid;
	private int perid;
	ListView<Object> listview;
	
	public void insert() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ids = Integer.parseInt(standortid.getText());
		nametext = name.getText();
		strassetext = strasse.getText();
		hntext = Integer.parseInt(hausnummer.getText());
		plztext = Integer.parseInt(plz.getText());
		plstext = Integer.parseInt(pls.getText());
		pfntext = Integer.parseInt(postfachnummer.getText());
		tel = Integer.parseInt(telefon.getText());
		fid = Integer.parseInt(fikusid.getText());
		perid = Integer.parseInt(perkusid.getText());
		
		java.sql.Connection conn = Connection.connecten();
		String query = "INSERT INTO Standort(idstandort,name,strasse,hausnummer,plz,pls,"
				+ "postfachnummer,telefon,Fikus_idFikus,Perkus_idPerkus)"
				+ "values('"+ids+"','"+nametext+"','"+strassetext+"','"+hntext+"','"+plztext+"','"
				+plstext+"','"+pfntext+"','"+tel+"','"+fid+"','"+perid+"')";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Insert into Table Standort is completed.");
	}
	
	public void update() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ids = Integer.parseInt(standortid.getText());
		nametext = name.getText();
		strassetext = strasse.getText();
		hntext = Integer.parseInt(hausnummer.getText());
		plztext = Integer.parseInt(plz.getText());
		plstext = Integer.parseInt(pls.getText());
		pfntext = Integer.parseInt(postfachnummer.getText());
		tel = Integer.parseInt(telefon.getText());
		fid = Integer.parseInt(fikusid.getText());
		perid = Integer.parseInt(perkusid.getText());

		java.sql.Connection conn = Connection.connecten();
		String query = "UPDATE Standort SET Name = '"+ nametext +"' WHERE idStandort IN ("+ids+")";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Update at Table Perkus is completed.");
	}
	
	public void delete() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		ids = Integer.parseInt(standortid.getText());
		nametext = name.getText();
		strassetext = strasse.getText();
		hntext = Integer.parseInt(hausnummer.getText());
		plztext = Integer.parseInt(plz.getText());
		plstext = Integer.parseInt(pls.getText());
		pfntext = Integer.parseInt(postfachnummer.getText());
		tel = Integer.parseInt(telefon.getText());
		fid = Integer.parseInt(fikusid.getText());
		perid = Integer.parseInt(perkusid.getText());
		
		java.sql.Connection conn = Connection.connecten();
		String query = "DELETE FROM Standort WHERE idStandort = '"+ids+"' AND Name = "
				+ "'"+nametext+"' AND Strasse = '"+strassetext+"' AND Hausnummer ='"+hntext+"'"
						+ " AND PLZ ='"+plztext+"' AND PLS ='"+plstext+"' AND Postfachnummer ='"
				+pfntext+"' AND Telefon ='"+telefon+"' AND Fikus_idFikus ='"+fid+"' AND Perkus_idPerkus ='"
						+perid+"'";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.executeUpdate();
		System.out.println("New Delete at Table Standort is completed.");
	}
	
	public void show(){
		
		Stage primarystage = new Stage();
		standort_show_window window = new standort_show_window();
		window.start(primarystage);
	}
}
