package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import entidades.Author;
import entidades.Book;
import entidades.BooksAuthor;
import entidades.Publisher;
import model.Dao;
import view.View;

public class Controller {
	
	Dao model;
	View view;
	
	public Controller(Dao aModel, View aView) {
		this.model = aModel;
		this.view = aView;
	}
	
	public void init() {
		this.model.init();
		view.addBusca(new AcaoBuscar());
		view.addAuthor(new AcaoAddAuthor());
		view.addPublisher(new AcaoAddPublisher());
		view.listaAutorEditora(new AcaoAddBookSelection());
		view.addEditBusca(new AcaoEditBusca());
		view.addBook(new AcaoAddBook());
		view.editAuthor(new AcaoEditAuthor());
		view.editPublisher(new AcaoEditPublisher());
		view.editBook(new AcaoEditBook());
		view.loadTables(new AcaoLoadTables());
		view.buscaGroupButton(new AcaoGroupButton());
		view.removeAuthor(new AcaoRemoveAuthor());
		view.removePublisher(new AcaoRemovePublisher());
		view.removeBook(new AcaoRemoveBook());
		this.view.init();
	}
	
	class AcaoBuscar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = view.getNomeBusca();
			String filtro = view.filtroBusca();
			
			if (filtro == "author") {
				List<Author> authors;
				if (nome.equals("")) {
					authors = model.getAllAuthors();
				}else {
					authors = model.getAuthor(nome);
				}
				view.listaAutores(authors);
			}else if(filtro == "publisher") {
				List<Publisher> publishers;
				if(nome.equals("")) {
					publishers = model.getAllPublishers();
				}else {
					publishers = model.getPublisher(nome);
				}
				view.listaEditoras(publishers);
			}else if(filtro == "book") {
				List<Book> books;
				if(nome.equals("")) {
					books = model.getAllBooks();
				}else {
					books = model.getBook(nome);
				}
				view.listaLivros(books);
			}else if(filtro == "booksAuthor") {
				List<BooksAuthor> booksAuthor;
				if (nome.equals("")) {
					booksAuthor = model.getAllBooksAuthors();
				}else {
					booksAuthor = model.getBooksAuthor(nome);
				}
				view.listaLivrosAutor(booksAuthor);
			}

			
			
		}
		
	}
	
	class AcaoAddAuthor implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Author author = view.getAddAuthor();
			if(author.getName().equals("") && author.getFName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios");
			}else if(author.getName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Nome vazio");
			}else if(author.getFName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Sobrenome vazio");
			}else {
				model.addAuthor(author);
			}
			
		}
		
	}
	
	class AcaoAddPublisher implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Publisher publisher = view.getAddPublisher();
			if(publisher.getName().equals("") && publisher.getUrl().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios");
			}else if(publisher.getName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Nome vazio");
			}else if(publisher.getUrl().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: URL vazia");
			}else {
				model.addPublisher(publisher);
			}
			
		}
		
	}
	
	class AcaoAddBookSelection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Author> authors = model.getAllAuthors();
			List<Publisher> publishers = model.getAllPublishers();
			view.listaAutores2(authors);
			view.listaEditoras2(publishers);
		}
		
	}
	
	class AcaoAddBook implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Book book = view.getAddBook();
			int id = view.getIdAuthor();
			if(book.getTitle().equals("") && book.getISBN().equals("") && book.getPrice() == -1 && book.getPublisherId() == -1 && id == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios e nenhuma seleção feita");
			}else if(book.getTitle().equals("") && book.getISBN().equals("") && book.getPrice() == -1 && book.getPublisherId() == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios e editora não selecionada");
			}else if(book.getTitle().equals("") && book.getISBN().equals("") && book.getPrice() == -1 &&  id == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios e nenhum autor selecionado");
			}else if(book.getTitle().equals("") && book.getISBN().equals("") && book.getPrice() == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios");
			}else if(book.getTitle().equals("") && book.getISBN().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Título e ISBN vazios");
			}else if(book.getTitle().equals("")&& book.getPrice() == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Título e preço vazios");
			}else if(book.getISBN().equals("") && book.getPrice() == -1) {
				JOptionPane.showMessageDialog(null, "Erro: ISBN e preço vazios");
			}else if(book.getTitle().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Título vazio");
			}else if(book.getISBN().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: ISBN vazio");
			}else if(book.getPrice() == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Preço vazio");
			}else if(book.getPublisherId() == -1 && id == -1){
				JOptionPane.showMessageDialog(null, "Erro: Nenhuma seleção feita");
			}else if(book.getPublisherId() == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Editora não selecionada");
			}else if(id == -1) {
				JOptionPane.showMessageDialog(null, "Erro: Nenhum autor selecionado");
			}else {
				model.addbook(book);
				model.addBooksAuthors(book, id);	
			}

		}
		
	}
	
	class AcaoEditBusca implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Author> authors = model.getAllAuthors();
			List<Publisher> publishers = model.getAllPublishers();
			List<Book> books = model.getAllBooks();
			view.listaAutores3(authors);
			view.listaEditoras3(publishers);
			view.listaLivros2(books);
		}
		
	}
	
	class AcaoEditAuthor implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Author author = view.getEditAuthor();
			if(author.getName().equals("") && author.getFName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios");
			}else if(author.getName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Nome vazio");
			}else if(author.getFName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Sobrenome vazio");
			}else {
				model.editAuthor(author);
				List<Author> authors = model.getAllAuthors();
				view.listaAutores3(authors);
			}
			
		}
		
	}
	
	class AcaoEditPublisher implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Publisher publisher = view.getEditPublisher();
			if(publisher.getName().equals("") && publisher.getUrl().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Campos vazios");
			}else if(publisher.getName().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: Nome vazio");
			}else if(publisher.getUrl().equals("")) {
				JOptionPane.showMessageDialog(null, "Erro: URL vazia");
			}else {
				model.editPublisher(publisher);
				List<Publisher> publishers = model.getAllPublishers();
				view.listaEditoras3(publishers);
			}
			
		}
		
	}

	class AcaoEditBook implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Book book = view.getEditBook();
			if(book.getTitle().equals("") && book.getPrice() == -1) {
				
			}else if(book.getTitle().equals("")) {
				
			}else if(book.getPrice() == -1) {
				
			}else {
				model.editBook(book);
				List<Book> books = model.getAllBooks();
				view.listaLivros2(books);
			}
			
		}
		
	}
	class AcaoLoadTables implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			List<Author> authors = model.getAllAuthors();
			view.listaAutores(authors);
			view.listaAutores2(authors);
			view.listaAutores3(authors);
			List<Publisher> publishers = model.getAllPublishers();
			view.listaEditoras(publishers);
			view.listaEditoras2(publishers);
			view.listaEditoras3(publishers);
			List<Book> books = model.getAllBooks();
			view.listaLivros(books);
			view.listaLivros2(books);
			List<BooksAuthor> booksAuthors = model.getAllBooksAuthors();
			view.listaLivrosAutor(booksAuthors);
		}
		
	}
	
	class AcaoGroupButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Author> authors = model.getAllAuthors();
			view.listaAutores(authors);
			List<Publisher> publishers = model.getAllPublishers();
			view.listaEditoras(publishers);
			List<Book> books = model.getAllBooks();
			view.listaLivros(books);
			List<BooksAuthor> booksAuthors = model.getAllBooksAuthors();
			view.listaLivrosAutor(booksAuthors);
		}
		
	}
	
	class AcaoRemoveAuthor implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			List<BooksAuthor> bks = model.getAllBooksAuthors();
			Author author = view.getRemoveAuthor();
			int i = 0;
			
			
			for(BooksAuthor b: bks) {
				if(b.getId() == author.getId()) {
					i++;
				}
			}
			if(i==1) {
				JFrame frame = new JFrame();
				int result = JOptionPane.showConfirmDialog(frame,"Um ou mais livros dependem desse autor, tem certeza que deseja apaga-los?", "Cuidado",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) {
					Book book = model.getBookFromAuthor(author.getId());
					model.removeBook(book);
					model.removeBooksAuthor(author);
					model.removeAuthor(author);
				}else {
					JOptionPane.showMessageDialog(null, "Nada removido");
				}
			}else if(i == 0) {
				model.removeAuthor(author);
			}else {
				model.removeBooksAuthor(author);
				model.removeAuthor(author);
			}
			List<Author>authors = model.getAllAuthors();
			view.listaAutores3(authors);
		}
		
	}
	
	class AcaoRemovePublisher implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Book> books = model.getAllBooks();
			Publisher publisher = view.getRemovePublisher();
			List<Book> booksRemove = model.getBookFromPublisher(publisher.getId());
			int i = 0;
			
			for(Book b: books) {
				if(b.getPublisherId() == publisher.getId()) {
					i++;
				}
			}
			if(i >=1) {
				JFrame frame = new JFrame();
				int result = JOptionPane.showConfirmDialog(frame,"Um ou mais livros dependem dessa editora,, tem certeza que deseja apaga-los?", "Cuidado",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) {
					for(Book b: booksRemove) {
						model.removeBooksAuthor(b);
						model.removeBook(b);
					}
					model.removePublisher(publisher);
				}else {
					JOptionPane.showMessageDialog(null, "Nada removido");
				}
			}else  {
				model.removePublisher(publisher);
			}
			List<Publisher> publishers = model.getAllPublishers();
			view.listaEditoras3(publishers);
		}
		
	}
	
	class AcaoRemoveBook implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Book book = view.getRemoveBook();
			model.removeBooksAuthor(book);
			model.removeBook(book);
			
			List<Book> books = model.getAllBooks();
			view.listaLivros2(books);
		}
		
	}
	
}
