package controllers;
import models.Product;
import play.db.Model;
import play.db.Model.Factory;
import play.exceptions.TemplateNotFoundException;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Router;
import play.utils.Java;

@CRUD.For(Product.class)
public class Products extends CRUD {

}
