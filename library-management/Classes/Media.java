package Classes;


public class Media extends Items{
	
	//Attribute
	//Explanation of access right: private because the attribute should not be directly accessible from outside the class; should be accessed and modified through accessors and mutators (encapsulation)
	private String type;
	
	//Constructors
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public Media() {
		super();
	}
	public Media(String name, String author, int yearOfPublication, String type) {
		super(name, author, yearOfPublication);
		this.type = type;
		this.ID = items_ID_Generator.generateMediaID();
	}
	public Media(Media otherMedia) {
		super(otherMedia);
		this.type = otherMedia.type;
		this.ID = items_ID_Generator.generateBookID();
	}
	
	//Accessor 
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public String getType() {
		return this.type;
	}
	
	//Mutator 
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public void setType(String type) {
		this.type = type;
	}
	
	//toString()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public String toString() {
		String mediaMessage = "ID: " + this.ID + "\nName: " + this.name + "\nAuthor: " + this.author + "\nYear of Publication: " + this.yearOfPublication + "\nType: " + this.type + "\n";
		return mediaMessage;
	}
	
	//equals()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public boolean equals(Media otherMedia) {
		return ((otherMedia != null) 
			&& (this.getClass() == otherMedia.getClass()) 
			&& (this.name.equals(otherMedia.name))
			&& (this.author.equals(otherMedia.author))
			&& (this.yearOfPublication == otherMedia.yearOfPublication)
			&& (this.type == otherMedia.type));
		}
}
