
// -----------------------------------------------
// Assignment 1
// Written by: Houda Filali 40276607 and Manel Hellou 40284245
// For COMP 249
// -----------------------------------------------

/*This program manages all items, clients and leases/returns of the FunReading library.
*It has 3 packages with the following classes:
*	- Classes
*		- Items
*		- Book (subclass of Items)
*		- Journal (subclass of Items)
*		- Media (subclass of Items)
*		- items_ID_Generator 
*		- Library
*	- Clients
*		- Client
*		- client_ID_Generator 
*	- Driver
*		- DriverClass
*
* ----- Below is a breakdown of each of the classes and their methods -----
*
*	- Items class:  
*		- 4 attributes:
*			- ID
*			- Name
*			- Author
*			- Year of publication
*		- 13 methods:
*			- 3 constructors (default, parametrized, copy)
*			- 4 accessors (one for each attribute)
*			- 4 mutators (one for each attribute)
*			- toString() method
*			- equals() method
*
*	- Book class:
*		- 1 attribute (it inherits ID, name, author and year of publication from Items class):
*			- Number of pages
*		- 7 methods:
*			- 3 constructors (default, parametrized, copy) each triggering the constructor of the Items class
*			- 1 accessor (for number of pages); it inherits the accessor methods for the other attributes from the Items class
*			- 1 mutator (for number of pages); it inherits the mutator methods for the other attributes from the Items class
*			- toString() method
*			- equals() method
*
*	- Journal class:
*		- 1 attribute (it inherits ID, name, author and year of publication from Items class):
*			- Volume number
*		- 7 methods:
*			- 3 constructors (default, parametrized, copy) each triggering the constructor of the Items class
*			- 1 accessor (for volume number); it inherits the accessor methods for the other attributes from the Items class
*			- 1 mutator (for volume number); it inherits the mutator methods for the other attributes from the Items class
*			- toString() method
*			- equals() method
*
*	- Media class:
*		- 1 attribute (it inherits ID, name, author and year of publication from Items class):
*			- Type
*		- 7 methods:
*			- 3 constructors (default, parametrized, copy) each triggering the constructor of the Items class
*			- 1 accessor (for type); it inherits the accessor methods for the other attributes from the Items class
*			- 1 mutator (for type); it inherits the mutator methods for the other attributes from the Items class
*			- toString() method
*			- equals() method
*
**	- items_ID_Generator class (is called in the constructor methods of each object to generate an ID):
*		- 4 attributes:
*			- Item counter
*			- Journal Counter
*			- Book Counter
*			- Media Counter
*		- 4 methods:
*			- generateItemID()
*			- generateJournalID()
*			- generateBookID()
*			- generateMediaID()
*
*	- Library class:
*		- 5 attributes
*			- Item array
*			- Journal array
*			- Book array
*			- Media array
*			- Client array
*		- 14 methods:
*			- getBookArray() (used for getting the biggest book and making a copy of the book array)
*			- addItem()
*			- deleteItem()
*			- changeItemInformation()
*			- listCategoryItems()
*			- listAllItems()
*			- addClient()
*			- changeClientInformation()
*			- deleteClient()
*			- leaseItem()
*			- returnItem()
*			- showClientLeasedItems() 
*			- showAllLeasedItems()
*			- closeScanner()
*
*	- Client class:
*		- 5 attributes:
*			- ID
*			- Name
*			- Phone number 
*			- Email address
*			- Leased items array
*		- 15 methods:
*			- 3 constructors (default, paramterized, copy)
*			- 5 accessors (one for each attribute)
*			- 5 mutators (one for each attribute)
* 			- toString()
* 			- equals()
* 
* 	- client_ID_Generator class (is called in the constructor methods of Client to generate an ID):
*		- 1 attribute:
*			- Client counter
*		- 1 method:
*			- generateClientID()
*
*	- DriverClass class
*		- 5 methods:
*			- menu()  (displays the menu and calls the appropriate methods from the Library class depending on the option chosen by the user)
*			- predefinedScenario()
*			- getBiggestBook()
*			- copyOfBooks()
*			- main method  (includes welcome message and asks user if they want menu or predefined scenario)
*/




package Classes;


public class Book extends Items{ //Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	
	//Attribute
	//Explanation of access right: private because the attribute should not be directly accessible from outside the class; should be accessed and modified through accessors and mutators (encapsulation)
	private int numberOfPages;
	
	//Constructors
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public Book() {
		super();
	}
	public Book(String name, String author, int yearOfPublication, int numberOfPages) {
		super(name, author, yearOfPublication);
		this.numberOfPages = numberOfPages;
		this.ID = items_ID_Generator.generateBookID();
	}
	public Book(Book otherBook) {
		super(otherBook);
		this.numberOfPages = otherBook.numberOfPages;
		this.ID = items_ID_Generator.generateBookID();
	}
	
	//Accessor 
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public int getNumberOfPages() {
		return this.numberOfPages;
	}
	
	//Mutator
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	//toString()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public String toString() {
		String bookMessage = "ID: " + this.ID + "\nName: " + this.name + "\nAuthor: " + this.author + "\nYear of Publication: " + this.yearOfPublication + "\nNumber of Pages: " + this.numberOfPages + "\n";
		return bookMessage;
	}
	
	//equals()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public boolean equals(Book otherBook) {
		return ((otherBook != null) 
			&& (this.getClass() == otherBook.getClass()) 
			&& (this.name.equals(otherBook.name))
			&& (this.author.equals(otherBook.author))
			&& (this.yearOfPublication == otherBook.yearOfPublication)
			&& (this.numberOfPages == otherBook.numberOfPages));
	}
}
