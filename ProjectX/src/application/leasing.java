package application;

import java.sql.Date;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class leasing {

	 private ObjectProperty<Date> vertragsdatum;
	 private ObjectProperty<Date> rechnungsdatum;
	 private FloatProperty rechnungsbetrag;
	 private IntegerProperty anzahl_rechnungen;
	 private ObjectProperty<Date> datum_letzter_rechnungsbetrag;
	 private ObjectProperty<Date> datum_naechster_rechnungsbetrag;
	 private IntegerProperty nutzerzahl;
	 private IntegerProperty idLeasing;
	 private IntegerProperty idProdukt;
	 private IntegerProperty idPerkus;
	 private IntegerProperty idFikus;
	 int leasingnummer;
	 
	 
	 public leasing(Date vertragsdatum,Date rechnungsdatum, Float rechnungsbetrag, int anzahl_rechnungen,
			 Date datum_letzter_rechnungsbetrag, Date datum_naechster_rechnungsbetrag, int nutzerzahl,
			 int idLeasing,int idProdukt,int idPerkus,int idFikus, int leasingnummer){
		 
		 this.vertragsdatum = new SimpleObjectProperty<Date>(vertragsdatum);
		 this.rechnungsdatum = new SimpleObjectProperty<Date>(rechnungsdatum);
		 this.rechnungsbetrag = new SimpleFloatProperty(rechnungsbetrag);
		 this.anzahl_rechnungen = new SimpleIntegerProperty(anzahl_rechnungen);
		 this.datum_letzter_rechnungsbetrag = new SimpleObjectProperty<Date>(datum_letzter_rechnungsbetrag);
		 this.datum_letzter_rechnungsbetrag = new SimpleObjectProperty<Date>(datum_letzter_rechnungsbetrag);
		 this.nutzerzahl = new SimpleIntegerProperty(nutzerzahl);
		 this.idLeasing = new SimpleIntegerProperty(idLeasing);
		 this.leasingnummer = leasingnummer;
		 this.idProdukt = new SimpleIntegerProperty(idProdukt);
		 this.idPerkus = new SimpleIntegerProperty(idPerkus);
		 this.idFikus = new SimpleIntegerProperty(idFikus);
	 }
	 
	 public Date getvertragsdatum(){
		 return vertragsdatum.get();
	 }
	 
	 public Date getrechnungsdatum(){
		 return rechnungsdatum.get();
	 }
	 
	 public Float  getrechnungsbetrag(){
		 return rechnungsbetrag.get();
	 }
	 
	 public Integer  getanzahl_rechnungen(){
		 return anzahl_rechnungen.get();
	 }
	 
	 public Date getdatum_letzter_rechnungsbetrag(){
		 return datum_letzter_rechnungsbetrag.get();
	 }
	 
	 public Date getdatum_naechster_rechnungsbetrag(){
		 return datum_naechster_rechnungsbetrag.get();
	 }
	 
	 public Integer getnutzerzahl(){
		 return nutzerzahl.get();
	 }
	 
	 public Integer getidProdukt(){
		 return idProdukt.get();
	 }
	 
	 public Integer getidPerkus(){
		 return idPerkus.get();
	 }
	 
	 public Integer getidFikus(){
		 return idFikus.get();
	 }
	 
	 public Integer getidLeasing(){
		 return idLeasing.get();
	 }
	 
	 public String toString(){
			return (leasingnummer+".Leasing:\nVertragsdatum: "+ vertragsdatum.get() 
			+"	Rechnungsdatum: "+ rechnungsdatum.get()
			+"	Rechnungsbetrag: "+rechnungsbetrag.get()+"  Anzahl Rechnungen: "+ anzahl_rechnungen.get()
			+"	Datum letzter Rechnungsbetrag: "+datum_letzter_rechnungsbetrag.get()
			+"	Datum naechster Rechnungsbetrag: "+datum_naechster_rechnungsbetrag.get()
			+"\nNutzerzahl: "+nutzerzahl.get()+"	LeasingId: "+idLeasing.get() +"	ProduktId: "+idProdukt.get()
			+"	PerkusId: "+idPerkus.get()+"	FikusId: "+idFikus.get());
		}
}
