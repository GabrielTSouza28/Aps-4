package entidades;

public class Publisher {
	
	int id;
	String name;
	String url;
	
	public Publisher(int aId, String aName, String aUrl) {
		this.id = aId;
		this.name = aName;
		this.url = aUrl;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		return "Publisher(" + id + "): " + name + " " + url + "";
	}

}
