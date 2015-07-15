package controllers;

import models.Catalog;
import models.Product;
import models.Register;
import models.Store;
import models.Temporal;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		// Catalog catalog = inicializar();
//
		// Product produ = catalog.products.get(1L);
		Catalog catalog = new Catalog();
		Register r = null;

		catalog = Catalog.find(
				"SELECT c FROM Catalog c ORDER BY id DESC LIMIT 1").first();

		if (catalog == null) {
			catalog = inicializar();
		} else {
			Store store = Catalog.find(
					"SELECT s FROM Store s ORDER BY id DESC LIMIT 1").first();

			r = Register
					.find("SELECT r FROM Register r WHERE store_id= ? ORDER BY id DESC LIMIT 1",
							store.id).first();
		}

		// sCatalog catalog = (Catalog) Catalog.findById(1516L);
		render(catalog, r);
	}

	// FUNCION QUE ENVIA OBJETO A HTML
	private static Catalog inicializar() {
		Store store = new Store();
		store.save();

		Catalog catalog = new Catalog();
		catalog.addProduct(1, "Coca-cola", 3, true, "cocaCola.png", 2);
		catalog.addProduct(2, "Fanta", 4, false, "fanta.jpg", 0);
		catalog.addProduct(3, "Sprite", 5, false, "sprite.png", 3);
		catalog.addProduct(4, "Fioravanti", 6, true, "fioravanti.jpg", 5);
		catalog.addProduct(5, "Inca Kola", 7, false, "incaKola.jpg", 6);
		catalog.addProduct(6, "Nestea", 3, false, "nestea.jpg", 0);
		catalog.save();

		return catalog;

	}

	// FUNCION QUE RECEPTA VALOR DE HTML Y LO RECEPTA EN JAVA
	public static void ingresarItem(String code, String description,
			String price, String cantidad) {

		long codeL = Long.parseLong(code);
		float priceF = Float.parseFloat(price);//xq trabajo los valores string en interfaz 
		int qty = Integer.parseInt(cantidad);//y al guardar me da erro x el tipo

		Catalog catalog = Catalog.find(
				"SELECT c FROM Catalog c ORDER BY id DESC LIMIT 1").first();
		Store store = Catalog.find(
				"SELECT s FROM Store s ORDER BY id DESC LIMIT 1").first();
		Register r = Register
				.find("SELECT r FROM Register r WHERE store_id= ? ORDER BY id DESC LIMIT 1",
						store.id).first();

		if (r == null)
			r = new Register("Fulano D'Tal", "SFU3773", store, catalog);
//es para crear la nueva venta solo aprimera vez solo cuando la venta no existe y cuando la venta esta incompleta
		if (r.currentSale == null || r.currentSale.complete == true) {
			r.makeNewSale();//luego ingresa el item
			// r.save();
			// 
		}

		r.enterItem(codeL, qty);
		r.save();

		render();
	}

	public static void test1() {
		render();
	}

}
