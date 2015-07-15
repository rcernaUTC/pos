
package models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Catalog extends Model {

	@OneToMany(cascade = CascadeType.ALL)
	@MapKey(name = "code")
	public Map<Long, Product> products;

	private static Catalog _instance = null;

	
	public Catalog() {
		this.products = new HashMap<Long, Product>();
	}
//busca el product segun el codigo 
	public Product findProduct(long code) {
		return this.products.get(code);
	}

	public void addProduct(long code, String description, int price, boolean stock, String nombreImagen, int numStock) {
		Product product = new Product(code, description, price, stock, nombreImagen, numStock);
		this.products.put(code, product);		
	}
	


}
