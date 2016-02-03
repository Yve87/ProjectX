package application;

import java.sql.Date;

import javafx.beans.property.*;

public class Invoice {

	StringProperty fikusname;
	StringProperty perkusname;
	StringProperty produktname;
	StringProperty standortname;
	IntegerProperty preis;
	IntegerProperty rabatt;
	IntegerProperty rechnungsid;
	ObjectProperty<Date> rechnungsdatum;
	IntegerProperty bestellnummer;
	IntegerProperty lieferscheinid;
	IntegerProperty lieferantennummer;
	int invoicezaehler;
	
	
	public Invoice(String fikusname,String perkusname,String produktname,
			String standortname,int preis,int rabatt,int rechnungsid,
			Date rechnungsdatum,int lieferantennummer,int bestellnummer,
			int lieferscheinid,int invoicezaehler){
		
		this.fikusname = new SimpleStringProperty(fikusname);
		this.perkusname = new SimpleStringProperty(perkusname);
		this.produktname = new SimpleStringProperty(produktname);
		this.standortname = new SimpleStringProperty(standortname);
		this.preis = new SimpleIntegerProperty(preis);
		this.rabatt = new SimpleIntegerProperty(rabatt);
		this.rechnungsid = new SimpleIntegerProperty(rechnungsid);
		this.rechnungsdatum =new SimpleObjectProperty<Date>(rechnungsdatum);
		this.lieferantennummer = new SimpleIntegerProperty(lieferantennummer);
		this.bestellnummer = new SimpleIntegerProperty(bestellnummer);
		this.lieferscheinid = new SimpleIntegerProperty(lieferscheinid);
		this.invoicezaehler = invoicezaehler;
	}
	
	public Integer getlieferscheinid(){
		return lieferscheinid.get();
	}
	
	public String getfikusname(){
		return fikusname.get();
	}
	
	public String getperkusname(){
		return perkusname.get();
	}
	
	public String getproduktname(){
		return produktname.get();
	}
	
	public String getstandortname(){
		return standortname.get();
	}
	
	public Integer getpreis(){
		return preis.get();
	}
	
	public Integer getrabatt(){
		return rabatt.get();
	}
	
	public Integer getrechnungsid(){
		return rechnungsid.get();
	}
	
	public Date getrechnungsdatum(){
		return rechnungsdatum.get();
	}
	
	public Integer getlieferantennummer(){
		return lieferantennummer.get();
	}
	
	public Integer getbestellnummer(){
		return bestellnummer.get();
	}
	
	public String toString(){
		return ("");
	}
}
