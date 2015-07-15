package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Store extends Model {
	private int nextSaleNumber;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Sale> completedSales;

	public Store() {
		this.nextSaleNumber = 1;
		this.completedSales = new HashSet<Sale>();
	}

	public void recordSale(String cashier, String register, Sale s) {
	}

}
