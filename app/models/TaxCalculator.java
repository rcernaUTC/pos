package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class TaxCalculator extends Model {

	
	private static TaxCalculator _instance = null;
	
	public float calculateTaxes(long code, float price, int qty)
	{
		return price * qty * 1.12f;
	}

	public static TaxCalculator getInstance() {
		if (_instance == null) {
			_instance = new TaxCalculator();
		}

		return _instance;
	}

}





