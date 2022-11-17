package main;


import controller.Controller;
import model.Dao;
import model.DaoDatabase;
import view.Janela;

public class Main {
	public static void main(String[] args) {
	
	Janela j = new Janela();
	Dao dao = new DaoDatabase();
	Controller controller = new Controller(dao, j);
	controller.init();
	
	}
}
