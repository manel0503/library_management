package Classes;


public class Items { //Explanation of access right: public because will be used outside of the Classes package (will be used in Driver and Clients packages)
	
	//Attributes
	//Explanation of access right: Protected so that these attributes can be accessed by subclasses (Book, Journal, Media)
	protected String ID;
	protected String name;
	protected String author;
	protected int yearOfPublication;
	
	//Constructors
	//Explanation of access right: Protected so that these attributes can be accessed by subclasses (Book, Journal, Media)
	protected Items(){
		
	}
	protected Items(String name, String author, int yearOfPublication) {
		this.name = name;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
		this.ID = items_ID_Generator.generateItemID();
	}
	protected Items(Items otherItem) {
		this.name = otherItem.name;
		this.author = otherItem.author;
		this.yearOfPublication = otherItem.yearOfPublication;
		this.ID = items_ID_Generator.generateItemID();
	}
	
	//Accessors 
	//Explanation of access right: Protected so that these attributes can be accessed by subclasses (Book, Journal, Media)
	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public int getYearOfPublication() {
		return this.yearOfPublication;
	}
	
	//Mutators
	//Explanation of access right: Protected so that these attributes can be accessed by subclasses (Book, Journal, Media)
	protected void setID(String ID) {
		this.ID = ID;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected void setAuthor(String author) {
		this.author = author;
	}
	protected void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	
	//toString()
	//Explanation of access right: Public because cannot reduce the visibility of the inherited method from "Object" class, so cannot put it in "protected"
	public String toString() {
		String itemMessage = "ID: " + this.ID + "\nName: " + this.name + "\nAuthor: " + this.author + "\nYear of Publication: " + this.yearOfPublication + "\n";
		return itemMessage;
	}
	
	//equals()
	//Explanation of access right: Protected so that these attributes can be accessed by subclasses (Book, Journal, Media)
	public boolean equals(Items otherItem) {
		return ((otherItem != null) 
				&& (this.getClass() == otherItem.getClass()) 
				&& (this.name.equals(otherItem.name))
				&& (this.author.equals(otherItem.author))
				&& (this.yearOfPublication == otherItem.yearOfPublication));
	}
	
}
