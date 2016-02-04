package application;

import java.sql.Date;
import java.text.DecimalFormat;

import javafx.beans.property.*;

public class Invoice {

	StringProperty fikusname;
	StringProperty perkusname;
	StringProperty produktname;
	StringProperty standortname;
	FloatProperty gesamtpreis;
	IntegerProperty rabatt;
	IntegerProperty rechnungsid;
	ObjectProperty<Date> rechnungsdatum;
	IntegerProperty bestellnummer;
	IntegerProperty lieferscheinid;
	IntegerProperty lieferantennummer;
	int invoicezaehler;
	
	DecimalFormat f = new DecimalFormat("#0.00"); 
	
	public Invoice(int rechnungsid,Date rechnungsdatum,float gesamtpreis,int lieferantennummer,
			String fikusname,String perkusname,String produktname,int lieferscheinid){
		
		this.gesamtpreis = new SimpleFloatProperty(gesamtpreis);
		this.rechnungsid = new SimpleIntegerProperty(rechnungsid);
		this.rechnungsdatum =new SimpleObjectProperty<Date>(rechnungsdatum);
		this.lieferantennummer = new SimpleIntegerProperty(lieferantennummer);
		this.lieferscheinid = new SimpleIntegerProperty(lieferscheinid);
		this.fikusname = new SimpleStringProperty(fikusname);
		this.perkusname = new SimpleStringProperty(perkusname);
		this.produktname = new SimpleStringProperty(produktname);
		this.invoicezaehler = rechnungsid;
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
	
	public Float getgesamtpreis(){
		return gesamtpreis.get();
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
	
	public String toString(){
		return ("");
	}
}
