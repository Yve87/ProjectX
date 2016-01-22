package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Produkt {

	public int produktid;
	public String name;
	public int versionsnummer;
	public int listenpreis;
	public String systemvoraussetzung;
	public String produktcol;
	
	
	public Produkt(int produktid,String name, int versionsnummer,int listenpreis,
			String systemvoraussetzung,String produktcol){
		
		this.produktid = produktid;
		this.name = name;
		this.versionsnummer = versionsnummer;
		this.listenpreis = listenpreis;
		this.systemvoraussetzung = systemvoraussetzung;
		this.produktcol = produktcol;
	}
}
