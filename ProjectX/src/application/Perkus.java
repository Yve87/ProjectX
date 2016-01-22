package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Perkus {

	public int id;
	public String name;
	public String vorname;
	public String anrede;
	public String titel;
	public String abteilung;
	public String gebaeudenummer;
	public String zimmernummer;
	public String tel;
	public String fax;
	public String email;
	public String position;
	public int fikusid;
	
	
	public Perkus(int id,String name,String vorname, String anrede, String titel, 
			String abteilung,String gebaeudenummer, String zimmernummer,String tel,
			String fax,String email,String position,int fikusid){
		
		this.id = id;
		this.name = name;
		this.vorname = vorname;
		this.anrede = anrede;
		this.titel = titel;
		this.abteilung = abteilung;
		this.gebaeudenummer = gebaeudenummer;
		this.zimmernummer = zimmernummer;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.position = position;
		this.fikusid = fikusid;
	}
}
