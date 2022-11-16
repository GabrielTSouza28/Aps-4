package model;

import java.util.List;
import entidades.Author;
import entidades.Book;
import entidades.BooksAuthor;
import entidades.Publisher;

public interface Dao {
	public void init();
	public void close();
	public void addAuthor(Author author);
	public void addBooksAuthors(Book book, int id);
	public void removeAuthor(Author author);
	public void editAuthor(Author author);
	public List<Author> getAllAuthors();
	public List<Author> getAuthor(String nome);
	public void addPublisher(Publisher publisher);
	public void removePublisher(Publisher publisher);
	public void editPublisher(Publisher publisher);
	public List<Publisher> getAllPublishers();
	public List<Publisher> getPublisher(String nome);
	public void addbook(Book book);
	public void removeBook(Book book);
	public void editBook(Book book);
	public List<Book> getAllBooks();
	public List<Book> getBook(String nome);
	public List<BooksAuthor> getAllBooksAuthors();
	public List<BooksAuthor> getBooksAuthor(String nome);
	public void removeBooksAuthor(Author author);
	public Book getBookFromAuthor(int id);
	public List<Book> getBookFromPublisher(int id);
	public void removeBooksAuthor(Book book);
}
