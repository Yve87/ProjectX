package application;

import java.sql.Date;

public class Invoice {

	String fikusname;
	String perkusname;
	String produktname;
	String standortname;
	int preis;
	int rabatt;
	int rechnungsid;
	Date rechnungsdatum;
	int bestellnummer;
	int lieferscheinid;
	int vorgaengerrechnung;
	int bezahlt;
	
	
	public Invoice(String fikusname,String perkusname,String produktname,
			String standortname,int preis,int rabatt,int rechnungsid,
			Date rechnungsdatum,int lieferantennummer,int bestellnummer,
			int lieferscheinid,int vorgaengerrechnung,int bezahlt){
		
		this.fikusname = fikusname;
		this.perkusname = perkusname;
		this.produktname = produktname;
		this.standortname = standortname;
		this.preis = preis;
		this.rabatt = rabatt;
		this.rechnungsid = rechnungsid;
		this.rechnungsdatum = rechnungsdatum;
		this.bestellnummer = bestellnummer;
		this.lieferscheinid = lieferscheinid;
		this.vorgaengerrechnung = vorgaengerrechnung;
		this.bezahlt = bezahlt;
	}
}
