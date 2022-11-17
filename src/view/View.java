package view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ChangeListener;

import entidades.Author;
import entidades.Book;
import entidades.BooksAuthor;
import entidades.Publisher;

public interface View {
	
	public void init();
	public void close();
	
	public void listaAutores(List<Author> authors);
	public void listaEditoras(List<Publisher> publishers);
	public void listaLivros(List<Book> books);
	public void listaLivrosAutor(List<BooksAuthor> booksAuthor);
	public void addBusca(ActionListener al);
	public String getNomeBusca();
	public String filtroBusca();
	public Author getAddAuthor();
	public int getIdAuthor();
	public void addAuthor(ActionListener al);
	public Publisher getAddPublisher();
	public void addPublisher(ActionListener al);
	public Book getAddBook();
	public void addBook(ActionListener al);
	public void listaAutorEditora(ActionListener al);
	public void listaAutores2(List<Author> authors);
	public void listaEditoras2(List<Publisher> publishers);
	public void listaAutores3(List<Author> authors);
	public void listaEditoras3(List<Publisher> publishers);
	public void listaLivros2(List<Book> books);
	public void addEditBusca(ActionListener al);
	public Author getEditAuthor();
	public Publisher getEditPublisher();
	public Book getEditBook();
	public void editAuthor(ActionListener al);
	public void editPublisher(ActionListener al);
	public void editBook(ActionListener al);
	public void loadTables(ChangeListener cl);
	public void buscaGroupButton(ActionListener al);
	public Author getRemoveAuthor();
	public void removeAuthor(ActionListener al);
	public Publisher getRemovePublisher();
	public void removePublisher(ActionListener al);
	public Book getRemoveBook();
	public void removeBook(ActionListener al);
}
