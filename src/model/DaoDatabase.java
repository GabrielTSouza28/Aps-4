package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Author;
import entidades.Book;
import entidades.BooksAuthor;
import entidades.Publisher;

public class DaoDatabase implements Dao{
	static private String USER = "root";
	static private String PASS = null;
	static private String DATABASE = "livraria";
	static private String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
	
	@Override
	public void init() {
		
		  try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
		    System.out.println("Conexao estabelecida");
		  }catch(Exception e) {
		    e.printStackTrace();
		  }
		
	}
	


	@Override
	public void addAuthor(Author author) {
		
		final String query = "INSERT INTO authors VALUES(?,?,?)";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setInt(1, 0);
			pstm.setString(2, author.getName());
			pstm.setString(3, author.getFName());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de adicionar " + author + ": " + result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Author> getAllAuthors() {
		  
		List<Author> authors = new ArrayList<>();
		final String query = "SELECT * FROM authors ORDER BY name ASC;";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
				  
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				
				int id = rs.getInt("author_id");
				String name = rs.getString("name");
				String fName = rs.getString("fname");
				Author author = new Author(id, name, fName);
				authors.add(author);
			  }
			  
		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return authors;
		}

	@Override
	public List<Author> getAuthor(String nome) {
		
		List<Author> authors = new ArrayList<>();
		
		final String query = "SELECT * FROM authors WHERE LOWER(name) LIKE LOWER(?);";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
				
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%" +  nome + "%");
			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("author_id");
				String name = rs.getString("name");
				String fName = rs.getString("fname");
				Author author = new Author(id, name, fName);
				authors.add(author);
			}

		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return authors;		
	}

	@Override
	public void addPublisher(Publisher publisher) {
		
		final String query = "INSERT INTO publishers VALUES(?,?,?)";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setInt(1, 0);
			pstm.setString(2, publisher.getName());
			pstm.setString(3, publisher.getUrl());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de adicionar " + publisher + ": " + result);
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		
	}

	@Override
	public List<Publisher> getAllPublishers() {
		
		List<Publisher> publishers = new ArrayList<>();
		final String query = "SELECT * FROM publishers ORDER BY name ASC;";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
				  
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				
				int id = rs.getInt("publisher_id");
				String name = rs.getString("name");
				String url = rs.getString("URL");
				Publisher publisher = new Publisher(id, name, url);
				publishers.add(publisher);
			  }
			  
		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return publishers;
	}


	@Override
	public List<Publisher> getPublisher(String nome) {
		
		List<Publisher> publishers = new ArrayList<>();
		
		final String query = "SELECT * FROM publishers WHERE LOWER(name) LIKE LOWER(?);";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
				
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1,"%" +  nome + "%");
			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("publisher_id");
				String name = rs.getString("name");
				String URL = rs.getString("URL");
				Publisher publisher = new Publisher(id, name, URL);
				publishers.add(publisher);
			}

		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return publishers;	
	}


	@Override
	public void addbook(Book book) {
		final String query = "INSERT INTO books VALUES(?,?,?,?)";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, book.getTitle());
			pstm.setString(2, book.getISBN());
			pstm.setInt(3, book.getPublisherId());
			pstm.setDouble(4, book.getPrice());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de adicionar " + book + ": " + result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Book> getAllBooks() {
		
		List<Book> books = new ArrayList<>();
		final String query = "SELECT * FROM books ORDER BY title ASC;";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
				  
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				
				String title = rs.getString("title");
				String isbn = rs.getString("isbn");
				int publisherId = rs.getInt("publisher_id");
				double price = rs.getDouble("price");
				Book book = new Book(title, isbn, publisherId, price);
				books.add(book);
			  }
			  
		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return books;
	}


	@Override
	public List<Book> getBook(String nome) {
		
		List<Book> books = new ArrayList<>();
		final String query = "SELECT * FROM books WHERE LOWER(title) LIKE LOWER(?);";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){

			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1,"%" +  nome + "%");
			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				
				String title = rs.getString("title");
				String isbn = rs.getString("isbn");
				int publisherId = rs.getInt("publisher_id");
				double price = rs.getDouble("price");
				Book book = new Book(title, isbn, publisherId, price);
				books.add(book);
			  }
			  
		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return books;
	}
	
	@Override
	public void addBooksAuthors(Book book, int id) {
		final String query = "INSERT INTO booksauthors VALUES(?,?,?)";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, book.getISBN());
			pstm.setInt(2, id);
			pstm.setDouble(3, 5);
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de adicionar " + book + " authorId: " + id +  ": " + result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeAuthor(Author author) {
		
		final String query =  "DELETE FROM authors WHERE author_id = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setInt(1,author.getId());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de remover" + author + ": " + result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void editAuthor(Author author) {
		final String query = "UPDATE authors SET Name = ?, FName = ? WHERE author_id = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getFName());
			pstm.setInt(3,author.getId());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de alterar " + author + ": " + result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removePublisher(Publisher publisher) {
		
		final String query =  "DELETE FROM publishers WHERE publisher_id  = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setInt(1,publisher.getId());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de remover " + publisher + ": " + result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editPublisher(Publisher publisher) {
		final String query = "UPDATE publishers SET Name = ?, URL = ? WHERE Publisher_Id = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, publisher.getName());
			pstm.setString(2, publisher.getUrl());
			pstm.setInt(3,publisher.getId());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de editar " + publisher + ": " + result );
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeBook(Book book) {

		final String query =  "DELETE FROM Books WHERE ISBN  = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1,book.getISBN());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de remover " + book + ": " + result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void editBook(Book book) {
		final String query = "UPDATE books SET Title = ?, Price = ? WHERE ISBN = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1, book.getTitle());
			pstm.setDouble(2, book.getPrice());
			pstm.setString(3,book.getISBN());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de editar " + book + ": " + result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<BooksAuthor> getAllBooksAuthors() {
		List<BooksAuthor> booksAuthors = new ArrayList<>();
		final String query = "SELECT authors.name, authors.fname, books.title,booksauthors.author_id,booksauthors.isbn, booksauthors.seq_no\r\n"
				+ "FROM books INNER JOIN booksauthors\r\n"
				+ "ON books.isbn = booksauthors.isbn\r\n"
				+ "INNER JOIN authors\r\n"
				+ "ON booksauthors.author_id = authors.author_id;";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(query);

			while(rs.next()) {
				
				String authorName = rs.getString("name");
				String authorFName = rs.getString("fname");
				String bookTitle = rs.getString("title");
				String isbn = rs.getString("isbn");
				int authorId = rs.getInt("author_id");
				int seq = rs.getInt("seq_no");
				BooksAuthor bookAuthor = new BooksAuthor(isbn, authorId, seq, authorName,authorFName, bookTitle);
				booksAuthors.add(bookAuthor);

			  }
		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return booksAuthors;
	}
	
	@Override
	public void removeBooksAuthor(Author author) {
		final String query =  "DELETE FROM Booksauthors WHERE author_id  = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setInt(1,author.getId());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de remover " + author + ": " + result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Book getBookFromAuthor(int id) {
		final String query = "SELECT * FROM booksauthors WHERE author_id = ?;";
		
		String title = null;
		String isbn = null;
		int publisherId = 0;
		double price = 0;
		
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				title = rs.getString("title");
				isbn = rs.getString("isbn");
				publisherId = rs.getInt("publisher_id");
				price = rs.getDouble("price");
			  }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		Book book = new Book(title, isbn, publisherId, price);
		return book;
	}

	@Override
	public List<BooksAuthor> getBooksAuthor(String nome) {
		List<BooksAuthor> booksAuthors = new ArrayList<>();
		final String query = "SELECT authors.name, authors.fname, books.title,booksauthors.author_id,booksauthors.isbn, booksauthors.seq_no\r\n"
				+ "FROM books INNER JOIN booksauthors\r\n"
				+ "ON books.isbn = booksauthors.isbn\r\n"
				+ "INNER JOIN authors\r\n"
				+ "ON booksauthors.author_id = authors.author_id\r\n"
				+ "WHERE LOWER(authors.name) LIKE LOWER(?) ;";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setString(1, "%" +  nome + "%");
			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				
				String authorName = rs.getString("name");
				String authorFName = rs.getString("fname");
				String bookTitle = rs.getString("title");
				String isbn = rs.getString("isbn");
				int authorId = rs.getInt("author_id");
				int seq = rs.getInt("seq_no");
				BooksAuthor bookAuthor = new BooksAuthor(isbn, authorId, seq, authorName,authorFName, bookTitle);
				booksAuthors.add(bookAuthor);

			  }
		  }catch(Exception e) {
		    e.printStackTrace();
		  }

		  return booksAuthors;
	}

	@Override
	public List<Book> getBookFromPublisher(int id) {
		List<Book> books = new ArrayList<>();
		final String query = "SELECT * FROM books WHERE publisher_id = ?;";
		
		String title = null;
		String isbn = null;
		int publisherId = 0;
		double price = 0;
		
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				title = rs.getString("title");
				isbn = rs.getString("isbn");
				publisherId = rs.getInt("publisher_id");
				price = rs.getDouble("price");
				Book book = new Book(title, isbn, publisherId, price);
				books.add(book);
			  }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void removeBooksAuthor(Book book) {
		final String query =  "DELETE FROM Booksauthors WHERE isbn  = ?";
		try (Connection c = DriverManager.getConnection(URL, USER, PASS)){
			
			PreparedStatement pstm = c.prepareStatement(query);
			
			pstm.setString(1,book.getISBN());
			
			int result = pstm.executeUpdate();
			
			System.out.println("Resultado de remover " + book + ": " + result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
