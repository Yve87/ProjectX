package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Standort {

	public int standortid;
	public String name;
	public String strasse;
	public int hausnummer;
	public int plz;
	public int pls;
	public int postfachnummer;
	public int telefon;
	public int fikusid;
	public int perkusid;
	
	
	public Standort(int standortid, String name, String strasse, int hausnummer,
			int plz, int pls, int postfachnummer, int telefon, int fikusid, int perkusid){
		
		this.standortid = standortid;
		this.name = name;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.pls = pls;
		this.postfachnummer = postfachnummer;
		this.telefon = telefon;
		this.fikusid = fikusid;
		this.perkusid = perkusid;
	}
}
