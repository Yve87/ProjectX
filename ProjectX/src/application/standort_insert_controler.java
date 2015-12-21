package application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

}
