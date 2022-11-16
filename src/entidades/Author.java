package entidades;

public class Author {
	int id;
	String name;
	String fName;
	
	public Author(int aId, String aName, String aFName) {
		this.id = aId;
		this.name = aName;
		this.fName = aFName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFName() {
		return fName;
	}

	
	@Override
	public String toString() {
		return "Autor(" + id + "): " + name + " " + fName + "";
	}
}
