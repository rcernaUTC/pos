package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Register extends Model {
	private String register;
	private String cashier;
	@OneToOne(cascade = CascadeType.ALL)
	private Store store;
	@OneToOne(cascade = CascadeType.ALL)
	private Catalog catalog;
	@OneToOne(cascade = CascadeType.ALL)
	public Sale currentSale;

	public Register(String cashier, String register, Store store,
			Catalog catalog) {
		this.register = register;
		this.cashier = cashier;
		this.store = store;
		this.catalog = catalog;
		this.currentSale = null;
	}

	public Sale getCurrentSale() {
		return this.currentSale;
	}

	public void makeNewSale() {
		this.currentSale = new Sale();
		// this.currentSale.save();
	}

	public void enterItem(long code, int qty) {
		Product p = this.catalog.findProduct(code);
		if (this.currentSale.items.size() > 0)
			if (this.currentSale.verificarItemExistente(p) == true)
				return;
		this.currentSale.makeItem(p, qty);
	}

	public float endSale() {
		this.currentSale.becomeComplete();
		return this.currentSale.calculateTotal();
	}

	public float makeCashPayment(float amount) {
		float x = 3;
		return x;
	}

	public void makeCheckPayment(String number) {
	}

}
