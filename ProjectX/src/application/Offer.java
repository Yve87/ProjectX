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

public class Offer {

	private StringProperty produktname;
	private DoubleProperty gesamtprice;
	private FloatProperty rabatt;
	private ObjectProperty<Date> gueltig;
	private IntegerProperty perkusid;
	private IntegerProperty angebotsid;
	DecimalFormat f = new DecimalFormat("#0.00");
	int id;
	
	
	
	public Offer(int angebotsid,String produktname,double gesamtprice,float rabatt,Date gueltig,
			int perkusid){
		
		this.angebotsid = new SimpleIntegerProperty(angebotsid);
		this.produktname = new SimpleStringProperty(produktname);
		this.gesamtprice = new SimpleDoubleProperty(gesamtprice);
		this.rabatt = new SimpleFloatProperty(rabatt);
		this.gueltig = new SimpleObjectProperty<Date>(gueltig);
		this.perkusid = new SimpleIntegerProperty(perkusid);
		id = angebotsid;
	}
	
	public Integer getangebotsid(){
		return angebotsid.get();
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
	
	public Date getgueltig(){
		return gueltig.get();
	}
	
	public Integer getperkusid(){
		return perkusid.get();
	}
	
	public String toString(){
		return (id+".Offer: \nProduktname: " +produktname.get()+"	Price: "+f.format(gesamtprice.get())
		+"EUR\nRabatt: "+rabatt.get()+"%	Gültig: "+gueltig.get()+"	Perkusid: "+perkusid.get());
	}
}
