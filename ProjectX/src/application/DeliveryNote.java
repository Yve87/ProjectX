package application;

import java.sql.Date;
import java.text.DecimalFormat;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DeliveryNote {

	private IntegerProperty lieferscheinid;
	private StringProperty fikusname;
	private StringProperty produktname;
	private DoubleProperty gesamtprice;
	private FloatProperty rabatt;
	private IntegerProperty perkusid;
	private ObjectProperty<Date> lieferdatum;
	int deliverynotezaehler;
	
	DecimalFormat f = new DecimalFormat("#0.00"); 
	
	public DeliveryNote(int lieferscheinid, Date lieferdatum,String fikusname,String produktname,
			double gesamtprice,float rabatt,int perkusid){
		
		this.lieferscheinid = new SimpleIntegerProperty(lieferscheinid);
		this.fikusname = new SimpleStringProperty(fikusname);
		this.produktname = new SimpleStringProperty(produktname);
		this.gesamtprice = new SimpleDoubleProperty(gesamtprice);
		this.rabatt = new SimpleFloatProperty(rabatt);
		this.perkusid = new SimpleIntegerProperty(perkusid);
		this.lieferdatum = new SimpleObjectProperty<Date>(lieferdatum);
		deliverynotezaehler = lieferscheinid;

	}
	
	
	public Integer getlieferscheinid(){
		return lieferscheinid.get();
	}
	
	public String getfikusname(){
		return fikusname.get();
	}
	
	public String getproduktname(){
		return produktname.get();
	}
	
	public Double getgesamtprice(){
		return gesamtprice.get();
	}
	
	public Float getrabatt(){
		return rabatt.get();
	}
	
	public Integer getperkusid(){
		return perkusid.get();
	}
	
	public Date getlieferdatum(){
		return lieferdatum.get();
	}
	
	public String toString(){
		return (deliverynotezaehler+".DeliveryNote:\nFikus: "+fikusname.get()+"	Produkt: "+produktname.get()
		+"\nPrice: "+f.format(gesamtprice.get())+"	  Rabatt: "+rabatt.get()+"	Perkusid: "+perkusid.get()
		+"\nLieferdatum: "+lieferdatum.get());
	}
	
}
