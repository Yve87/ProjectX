package application;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class leasing {

	 private ObjectProperty<Date> vertragsdatum;
	 private ObjectProperty<Date> rechnungsdatum;
	 private StringProperty rechnungsbetrag;
	 private StringProperty anzahl_rechnungen;
	 private ObjectProperty<Date> datum_letzter_rechnungsbetrag;
	 private ObjectProperty<Date> datum_naechster_rechnungsbetrag;
	 private IntegerProperty nutzerzahl;
	 private IntegerProperty idLeasing;
}
