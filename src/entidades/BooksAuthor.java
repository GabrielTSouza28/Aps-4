package entidades;

public class BooksAuthor {
	
	String authorName;
	String authorFName;
	String bookName;
	String ISBN;
	int id;
	int seq;
	
	public BooksAuthor(String aISBN, int aId, int aSeq, String aAuthorName, String aAuthorFName, String aBookName) {
		this.ISBN = aISBN;
		this.id = aId;
		this.seq = aSeq;
		this.authorName = aAuthorName;
		this.authorFName = aAuthorFName;
		this.bookName = aBookName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public String getAuthorFname() {
		return authorFName;
	}
	
	public String getBookName(){
		return bookName;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public int getId() {
		return id;
	}
	
	public int getSeq() {
		return seq;
	}

}
