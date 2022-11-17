package entidades;

public class Book {

	String title;
	String ISBN;
	int publisherId;
	double price;

	public Book(String aTitle, String aISBN, int aPublisherId, double aPrice) {
		this.title = aTitle;
		this.ISBN = aISBN;
		this.publisherId = aPublisherId;
		this.price = aPrice;
	}

	public String getTitle() {
		return title;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", ISBN=" + ISBN + ", publisherId=" + publisherId + ", price=" + price + "]";
	}

	
}
