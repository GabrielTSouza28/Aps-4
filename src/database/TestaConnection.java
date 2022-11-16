package database;

import java.util.List;

import controller.Controller;
import entidades.Author;
import model.Dao;
import model.DaoDatabase;
import view.Janela;

public class TestaConnection {
	public static void main(String[] args) {
	DaoDatabase.testaConnection();
	
	Janela j = new Janela();
	Dao dao = new DaoDatabase();
	Controller controller = new Controller(dao, j);
	controller.init();
	
	//DaoDatabase CT = new DaoDatabase();
	//List<Author> authors = CT.getAllAuthors();
	//for(Author author: authors) {
		//System.out.println(author);
		//}
	}
}
