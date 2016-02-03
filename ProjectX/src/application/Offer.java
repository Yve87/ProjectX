package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Offer {

	private IntegerProperty produktid;
	private StringProperty name;
	private DoubleProperty price;
	private DoubleProperty newprice;
	private FloatProperty rabatt;
	int offerzaehler;
	
	
	public Offer(int produktid,String name,double price,double newprice,float rabatt,int offerzaehler){
		
		this.produktid = new SimpleIntegerProperty(produktid);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		this.newprice = new SimpleDoubleProperty(newprice);
		this.rabatt = new SimpleFloatProperty(rabatt);
		this.offerzaehler = offerzaehler;
	}
	
	public Integer getproduktid(){
		return produktid.get();
	}
	
	public String getname(){
		return name.get();
	}
	
	public Double getprice(){
		return price.get();
	}
	
	public Double getnewprice(){
		return newprice.get();
	}
	
	public Float getrabatt(){
		return rabatt.get();
	}
	
	public String toString(){
		return ("");
	}
}
