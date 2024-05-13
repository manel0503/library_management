package Classes;
import java.util.Scanner;
import Clients.Client;

public class Library { 	//Explanation of access right: public because used outside of this class and package (used in Driver package)
	static Scanner in = new Scanner(System.in);
	//Attributes
	//Explanation of access right: private because the attribute should not be directly accessible from outside the class; only used within this class
	private static Items[] item_array; 
	private static Journal[] journal_array;
	private static Book[] book_array;
	private static Media[] media_array;
	private static Client[] client_array;
	
	//Explanation of access right of all the following methods: public because used outside of this class and package (used in Driver package)
	
	//Accessing the book_array 
	public static Book[] getBookArray() {
		return book_array;
	}
	
	//Adding an item 
	public static void addItem() {
		
		//Variables
		int journalVolumeNumber = 0;
		int bookNumberOfPages = 0;
		String mediaType = null;
		Items[] new_item_array = null;
		Journal[] new_journal_array = null;
		Book[] new_book_array = null;
		Media[] new_media_array = null;
		int itemType;
		
		//Asking for type of item to add (journal, book, media) and checking input validity
		do {
			System.out.println("\nPlease enter the number of the item you wish to add: \n1. Journal \n2. Book \n3. Media");
			itemType = in.nextInt();
			in.nextLine(); //consuming nextline character
				
			if (itemType < 1 || itemType > 3) {  
				System.out.println("This is not a valid option. Please try again.");
			}		
		}
		while (itemType < 1 || itemType > 3);
		
		//Asking the user for the new item's information
		System.out.println("\nPlease enter the following informations: ");
			
		System.out.println("\nName: ");
		String itemName = in.nextLine();
			
		System.out.println("Author: ");
		String itemAuthor = in.nextLine();
			
		System.out.println("Year of Publication: ");
		int itemYearOfPublication = in.nextInt();
		in.nextLine(); //consuming newline character
				
		if (itemType == 1) { //if it's a journal
			System.out.println("Volume Number: ");
			journalVolumeNumber = in.nextInt();
			in.nextLine();
		}
		else if (itemType == 2) { //if it's a book
			System.out.println("Number of Pages: ");
			bookNumberOfPages = in.nextInt();
			in.nextLine();
		}
		else if (itemType == 3) { //if it's a media
			System.out.println("Type: ");
			mediaType = in.nextLine();
		}
		
		//Adding an item if it is the first item to be added (there were no items before)
		if (item_array == null || item_array.length == 0) {  //checking if there was no item before
			item_array = new Items[1]; //assigning a new array of length one to the array that was null to be able to add an item in it
			//if it's a journal
			if (itemType == 1) {
				journal_array = new Journal[1]; //making the journal have a length of 1 too
				Journal newJournal = new Journal(itemName, itemAuthor, itemYearOfPublication, journalVolumeNumber); //creating the journal
				item_array[0] = newJournal; //adding the journal to the item array
				journal_array[0] = newJournal; //adding the journal to the journal array
				//making the journal in the item array, and in the journal array have the same reference, so when we change it later, it changes in both arrays
			}
			//if it's a book
			//same process as for journals
			else if (itemType == 2) {
				book_array = new Book[1];
				Book newBook = new Book(itemName, itemAuthor, itemYearOfPublication, bookNumberOfPages);
				item_array[0] = newBook;
				book_array[0] = newBook;
			}
			//if it's a media
			//same process as for journals and books
			else if (itemType == 3) {
				media_array = new Media[1];
				Media newMedia = new Media(itemName, itemAuthor, itemYearOfPublication, mediaType);
				item_array[0] = newMedia;
				media_array[0] = newMedia;
			}
			
			//checking if item was added successfully
			if (item_array.length == 1) { //array length was 0 before, so if it is 1 now, it means the item was added 
				System.out.println("\nItem added successfully! \nYou will be brought back to the menu.");
			}
		}
		
		//Adding an item if it is not the first item to be added (there were items before)
		else { 
			int initialCount = item_array.length; //will use later down for checking if item was added succesfully
			new_item_array = new Items[item_array.length + 1]; //creating a new array that has one more slot for the new item
			
			//deep copying the item array into the new one 
			for (int i=0; i<item_array.length; i++) {  
				new_item_array[i] = item_array[i];
			}
			//if it's a journal
			if (itemType == 1) {
				//adding a journal if there were no journals before
				if (journal_array == null || journal_array.length == 0) {
					journal_array = new Journal[1]; //assigning a new array of length one to the array that was null to be able to add an item in it
					Journal newJournal = new Journal(itemName, itemAuthor, itemYearOfPublication, journalVolumeNumber);
					journal_array[0] = newJournal; //adding new journal to journal array
					new_item_array[item_array.length] = newJournal; //adding new journal to item array
					//making the journal in the item array, and in the journal array have the same reference, so when we change it later, it changes in both arrays 
				}
				//adding a journal if there were journals before
				else {
					new_journal_array = new Journal[journal_array.length + 1]; //creating a new array that has one more slot for the new journal
					//deep copying the journal array into the new one 
					for (int i=0; i<journal_array.length; i++) {  
						new_journal_array[i] = journal_array[i];
					}
					Journal newJournal = new Journal(itemName, itemAuthor, itemYearOfPublication, journalVolumeNumber);
					new_item_array[item_array.length] = newJournal; //adding new journal to journal array
					new_journal_array[journal_array.length] = newJournal; //adding new journal to item array
					journal_array = new_journal_array; //assigning the new journal array to the original one (to update the original one)
				}
	
			}
			//if it's a book
			//same process as for journal
			if (itemType == 2) {
				if (book_array == null) {
					book_array = new Book[1];
					Book newBook = new Book(itemName, itemAuthor, itemYearOfPublication, bookNumberOfPages);
					book_array[0] = newBook;
					new_item_array[item_array.length] = newBook;
				}
				else {
					new_book_array = new Book[book_array.length + 1];
					for (int i=0; i<book_array.length; i++) {  
						new_book_array[i] = book_array[i];
					}
					Book newBook = new Book(itemName, itemAuthor, itemYearOfPublication, bookNumberOfPages);
					new_item_array[item_array.length] = newBook;
					new_book_array[book_array.length] = newBook;
					book_array = new_book_array;
				}
			}
			//if it's a media 
			//same process as for journal and book
			if (itemType == 3) {
				if (media_array == null) {
					media_array = new Media[1];
					Media newMedia = new Media(itemName, itemAuthor, itemYearOfPublication, mediaType);
					media_array[0] = newMedia;
					new_item_array[item_array.length] = newMedia;
				}
				else {
					new_media_array = new Media[media_array.length + 1];
					for (int i=0; i<media_array.length; i++) {  
						new_media_array[i] = media_array[i];
					}
					Media newMedia = new Media(itemName, itemAuthor, itemYearOfPublication, mediaType);
					new_item_array[item_array.length] = newMedia;
					new_media_array[media_array.length] = newMedia;
					media_array = new_media_array;
				}
			}	
		
			item_array = new_item_array; //assigning the new item array to the original one (to update the original one)
			
			//checking if item was added successfully
			if (item_array.length == (initialCount+1)) { //if the item array's length incremented by 1, the item has been added successfully
				System.out.println("\nItem added successfully! \nYou will be brought back to the menu.");
			}
		}
		
				
}
	//Deleting an item
	public static void deleteItem(){
		
		//Variables
		boolean validID = false;
		int new_index = 0;
		int new_specific_index = 0;
		boolean successfulRemoval = false;
		String itemID = null;
		String comparableID;
		
		//Asking for ID of item to remove (journal, book, media) and checking input validity
		do {
			System.out.println("\nPlease enter the ID of the item you wish to remove:");
			itemID = in.next();
			in.nextLine(); //consuming newline character
			comparableID = (itemID.substring(0,1).toUpperCase())+itemID.substring(1, itemID.length()); //making the ID have the first letter as capital (in case the user inputs the first letter as lowercase)

			if ((comparableID.charAt(0) =='J') && (journal_array == null || journal_array.length == 0)) { //if user wants to remove a journal and there is no journal
				break;
			}
			else if ((comparableID.charAt(0) =='B')&& (book_array == null || book_array.length == 0)) { //if user wants to remove a book and there is no book
				break;
			}
			else if ((comparableID.charAt(0) =='M')&& (media_array == null || media_array.length == 0)) { //if user wants to remove a media and there is no media
				break;
			}
			
			for (int i=0; i<item_array.length; i++) {
				if (item_array[i].getID().equals(comparableID)){
					validID = true;
				}
			}

				
			if (!validID) {  
				System.out.println("This is not a valid ID. Please try again.");
			}
			
		}
		while (validID == false);

		//Messages if there is 0 of the item the user wants to remove
		if ((comparableID.charAt(0) =='J') && (journal_array == null || journal_array.length == 0)) { //if user wants to remove a journal and there is no journal
			System.out.println("\nThere is no journal to remove. \nYou will be brought back to the menu.");
		}
		else if ((comparableID.charAt(0) =='B')&& (book_array == null || book_array.length == 0)) { //if user wants to remove a book and there is no book
			System.out.println("\nThere is no book to remove. \nYou will be brought back to the menu.");
		}
		else if ((comparableID.charAt(0) =='M')&& (media_array == null || media_array.length == 0)) { //if user wants to remove a media and there is no media
			System.out.println("\nThere is no media to remove. \nYou will be brought back to the menu.");
		}
		
		//Removal of item 
		else {
			Items[] new_item_array = new Items[item_array.length - 1];  //creating a new array with one less slot
			
			//making the item entered by the user null in the array (removing it)
			for (int i=0; i<item_array.length; i++) {
				if (item_array[i].getID().equals(comparableID)) {
					item_array[i] = null;
				}
			}
			
			//copying all item slots from the original array that are not empty to the new one
			for (int i=0; i<item_array.length; i++) {
				if (item_array[i] != null) {  
					new_item_array[new_index++] = item_array[i]; //using "new_index" instead of "i", because if user wants to remove the last item, the index in the old array [i] and the index in the new array [new_index] will not be the same, so cannot replace "new_index" by "i"
				}	
			}
			//assigning the new array to the original one (to update the original one)
			item_array = new_item_array;
			
			//doing the same thing as above in the specific arrays (ex: removing in the journal array too, if user is removing a journal)
			//if it's a journal
			if (comparableID.charAt(0) =='J') {
				Journal[] new_journal_array = new Journal[journal_array.length - 1];
				for (int i=0; i<journal_array.length; i++) {
					if ((journal_array[i].getID()).equals(comparableID)) {
						journal_array[i] = null;
					}
				}
				
				for (int i=0; i<journal_array.length; i++) {
					if (journal_array[i] != null) { 
						new_journal_array[new_specific_index] = journal_array[i]; 
					}	
				}
				journal_array = new_journal_array;
			}
			//if it's a book
			if (comparableID.charAt(0) =='B') {
				Book[] new_book_array = new Book[book_array.length - 1];
				for (int i=0; i<book_array.length; i++) {
					if ((book_array[i].getID()).equals(comparableID)) {
						book_array[i] = null;
					}
				}
				
				for (int i=0; i<book_array.length; i++) {
					if (book_array[i] != null) { //copying all prepaid cards slots that are not empty 
						new_book_array[new_specific_index] = book_array[i]; //using new_index instead of i, because if user wants to remove the last item, the index in the old array [i] and the index in the new array [new_index] will not be the same, so cannot replace new_index by i
					}	
				}
				book_array = new_book_array;
			}
			//if it's a media
			if (comparableID.charAt(0) =='M') {
				Media[] new_media_array = new Media[media_array.length - 1];
				for (int i=0; i<media_array.length; i++) {
					if ((media_array[i].getID()).equals(comparableID)) {
						media_array[i] = null;
					}
				}
				
				for (int i=0; i<media_array.length; i++) {
					if (media_array[i] != null) { //copying all prepaid cards slots that are not empty 
						new_media_array[new_specific_index] = media_array[i]; //using new_index instead of i, because if user wants to remove the last item, the index in the old array [i] and the index in the new array [new_index] will not be the same, so cannot replace new_index by i
					}	
				}
				media_array = new_media_array;
			}
			
			//checking if removal was successfull
			if (item_array.length == new_item_array.length) {  //both arrays should have the same length as the new one has been assigned to the first one
		        successfulRemoval = true;  //if they have the same length, the removal was successful 
		    }

		    if (successfulRemoval) {  //printing success message 
		        System.out.println("\nItem was removed successfully! \nYou will be brought back to the menu.");
		    }
		}
		
	}
	
	//Change information of item
	public static void changeItemInformation() {
		String itemID;
		boolean validID = false;
		Journal journalToChange = null;
		Book bookToChange = null;
		Media mediaToChange = null;
		int informationToChange;
		String newID;
		String newName;
		String newAuthor;
		int newYearOfPublication;
		int newVolumeNumber;
		int newNumberOfPages; 
		String newType;
		String comparableID;
		String settableID;
		
		//Asking for ID of item to modify (journal, book, media) and checking input validity
		//This part is the same as for removing an item (see above)
		do {
			System.out.println("\nPlease enter the ID of the item you wish to modify:");
			itemID = in.next();
			in.nextLine(); //consuming newline character
			comparableID = (itemID.substring(0,1).toUpperCase())+itemID.substring(1, itemID.length()); 

			if ((comparableID.charAt(0) =='J') && (journal_array == null || journal_array.length == 0)) { 
				break;
			}
			else if ((comparableID.charAt(0) =='B')&& (book_array == null || book_array.length == 0)) { 
				break;
			}
			else if ((comparableID.charAt(0) =='M')&& (media_array == null || media_array.length == 0)) { 
				break;
			}
			
			for (int i=0; i<item_array.length; i++) {
				if (item_array[i].getID().equals(comparableID)){
					validID = true;
				}
			}
				
			if (!validID) {  
				System.out.println("This is not a valid ID. Please try again.");
			}
			
		}
		while (validID == false);
		
		//Messages if there is 0 of the item the user wants to modify 
		if ((comparableID.charAt(0) =='J') && (journal_array == null || journal_array.length == 0)) { 
			System.out.println("\nThere is no journal to modify. \nYou will be brought back to the menu.");
		}
		else if ((comparableID.charAt(0) =='B')&& (book_array == null || book_array.length == 0)) { 
			System.out.println("\nThere is no book to modify. \nYou will be brought back to the menu.");
		}
		else if ((comparableID.charAt(0) =='M')&& (media_array == null || media_array.length == 0)) { 
			System.out.println("\nThere is no media to modify. \nYou will be brought back to the menu.");
		}
		
		//Modification of item
		else {
			//finding the item the user wants to change and what type it is (journal, book, media)
			for (int i=0; i<item_array.length; i++) {
				if (item_array[i].getID().equals(comparableID)) {
					if(comparableID.charAt(0) =='J') {
						journalToChange = (Journal)item_array[i];
					}
					else if(comparableID.charAt(0) =='B') {
						bookToChange = (Book)item_array[i];
					}
					else if(comparableID.charAt(0) =='M') {
						mediaToChange = (Media)item_array[i];
					}
					
				}
			}
			
			//Asking user for which information they want to change and checking for input validity
			do {
				System.out.println("\nPlease enter the number of the information you wish to change: \n1. ID \n2. Name \n3. Author \n4. Year of Publication");
				if(comparableID.charAt(0) =='J') {
					System.out.println("5. Volume Number");
				}
				else if(comparableID.charAt(0) =='B') {
					System.out.println("5. Number of Pages");
				}
				else if(comparableID.charAt(0) =='M') {
					System.out.println("5. Type");
				}
				informationToChange = in.nextInt();
				in.nextLine();
					
				if (informationToChange < 1 || informationToChange > 5) {  
					System.out.println("\nThis is not a valid option. Please try again.");
				}
				
			}
			while (informationToChange < 1 || informationToChange > 5);
			
			//Changing ID
			if(informationToChange == 1) {
				System.out.println("\nPlease enter the new ID:");
				newID = in.next();
				in.nextLine(); //consuming nextline character
				settableID = (newID.substring(0,1).toUpperCase())+newID.substring(1, newID.length()); //making the ID uppercase in case user put it lowercase
				boolean existentID = false;
				
				//if its a journal
				if(comparableID.charAt(0) =='J') {
					//checking if that ID is already used (because two different items cannot have same ID)
					for (int i=0; i<journal_array.length; i++) {
						if(journal_array[i].getID().equals(settableID)) {
							existentID = true;
						}
					}
					//if ID is not used
					if (!existentID) {
						journalToChange.setID(settableID);
						System.out.println("ID change successfull! \nYou will be brought back to the menu.");
					}
					//if ID is already used
					else {
						System.out.println("\nSorry, this ID already exists. You will be brought back to the menu.");
					}
				}
				//if it's a book
				//same process as for a journal
				else if(comparableID.charAt(0) =='B') {
					for (int i = 0; i<book_array.length; i++) {
						if(book_array[i].getID().equals(settableID)) {
							existentID = true;
						}
					}
					if (existentID == false) {
						bookToChange.setID(settableID);
						System.out.println("ID change successfull! \nYou will be brought back to the menu.");
					}
					else {
						System.out.println("\nSorry, this ID already exists. You will be brought back to the menu.");
					}
					
				}
				//if it's a media
				//same process as for a journal or a book
				else if(comparableID.charAt(0) =='M') {
					for (int i = 0; i<media_array.length; i++) {
						if(media_array[i].getID().equals(settableID)) {
							existentID = true;
						}
					}
					if (existentID == false) {
						mediaToChange.setID(settableID);
						System.out.println("ID change successfull! \nYou will be brought back to the menu.");
					}
					else {
						System.out.println("\nSorry, this ID already exists. You will be brought back to the menu.");
					}
					
				}
			}
			//Changing name
			else if(informationToChange == 2) {
				System.out.println("\nPlease enter the new name:");
				newName = in.nextLine();
				//if it's a journal
				if(comparableID.charAt(0) =='J') {
					journalToChange.setName(newName);
				}
				//if it's a book
				else if(comparableID.charAt(0) =='B') {
					bookToChange.setName(newName);
				}
				//if it's a media
				else if(comparableID.charAt(0) =='M') {
					mediaToChange.setName(newName);
				}
				System.out.println("Name change successfull! \nYou will be brought back to the menu.");
			}
			//Changing author 
			else if(informationToChange == 3) {
				System.out.println("\nPlease enter the new author:");
				newAuthor = in.nextLine();
				//if it's a journal
				if(comparableID.charAt(0) =='J') {
					journalToChange.setAuthor(newAuthor);
				}
				//if it's a book
				else if(comparableID.charAt(0) =='B') {
					bookToChange.setAuthor(newAuthor);
				}
				//if it's a media
				else if(comparableID.charAt(0) =='M') {
					mediaToChange.setAuthor(newAuthor);
				}
				System.out.println("Author change successfull! \nYou will be brought back to the menu.");
			}
			//Changing the year of publication
			else if(informationToChange == 4) {
				System.out.println("\nPlease enter the new year of publication:");
				newYearOfPublication = in.nextInt();
				in.nextLine();
				//if it's a journal
				if(comparableID.charAt(0) =='J') {
					journalToChange.setYearOfPublication(newYearOfPublication);
				}
				//if it's a book
				else if(comparableID.charAt(0) =='B') {
					bookToChange.setYearOfPublication(newYearOfPublication);
				}
				//if it's a media
				else if(comparableID.charAt(0) =='M') {
					mediaToChange.setYearOfPublication(newYearOfPublication);
				}
				System.out.println("Year of publication change successfull! \nYou will be brought back to the menu.");
			}
			//Changing the volume number (journal), the number of pages (book) or type (media)
			else if(informationToChange == 5) {
				//if it's a journal
				if(comparableID.charAt(0) =='J') {
					System.out.println("\nPlease enter the new volume number:");
					newVolumeNumber = in.nextInt();
					in.nextLine();
					journalToChange.setVolumeNumber(newVolumeNumber);
					System.out.println("Volume number change successfull! \nYou will be brought back to the menu.");
				}
				//if it's a book
				else if(comparableID.charAt(0) =='B') {
					System.out.println("\nPlease enter the new number of pages:");
					newNumberOfPages = in.nextInt();
					in.nextLine();
					bookToChange.setNumberOfPages(newNumberOfPages);
					System.out.println("Number of pages change successfull! \nYou will be brought back to the menu.");
				}
				//if it's a media
				else if(comparableID.charAt(0) =='M') {
					System.out.println("\nPlease enter the new type:");
					newType = in.nextLine();
					mediaToChange.setType(newType);
					System.out.println("Type change successfull! \nYou will be brought back to the menu.");
				}
			}
		}
	
	}
	
	//List all items in a specific category
	public static void listCategoryItems() {
		int category; 
		
		//Asking user for category (journal, book, media) they wish to view and checking for input validity
		do {
			System.out.println("\nPlease enter the number of the category you wish to view: \n1. Journal \n2. Book \n3. Media");
			category = in.nextInt();
			in.nextLine();
				
			if (category < 1 || category > 3) {  
				System.out.println("\nThis is not a valid option. Please try again.");
			}
			
		}
		while (category < 1 || category > 3);
		
		//Checking if there are items in the category they wish to view
		if(category==1 && (journal_array == null || journal_array.length == 0)) {
			System.out.println("\nThere are no journals. \nYou will be brought back to the menu.");
		}
		else if(category==2 && (book_array == null || book_array.length == 0)) {
			System.out.println("\nThere are no books. \nYou will be brought back to the menu.");
		}
		else if(category==3 && (media_array == null || media_array.length == 0)) {
			System.out.println("\nThere are no medias. \nYou will be brought back to the menu.");
		}
		//If there are items in the category they wish to view
		//if they want to view the journals
		else if (category == 1 && (journal_array != null || journal_array.length != 0)) {
			System.out.println("\n-----Journals-----");
			for (int i = 0; i<journal_array.length ; i++) {
				System.out.println((i+1) + ". " + journal_array[i].toString());
			}
		}
		//if they want to view the journals
		else if (category == 2 && (book_array != null || book_array.length != 0)) {
			System.out.println("\n-----Books-----");
			for (int i = 0; i<book_array.length ; i++) {
				System.out.println((i+1) + ". " + book_array[i].toString());
			}
		}
		//if they want to view the journals
		else if (category == 3 && (media_array != null || media_array.length != 0)) {
			System.out.println("\n-----Medias-----");
			for (int i = 0; i<media_array.length ; i++) {
				System.out.println((i+1) + ". " + media_array[i].toString());
			}
		}

	}
	
	//List all items
	public static void listAllItems() {
		System.out.println("");
		for (int i = 0; i< item_array.length ; i++) {
			//if it's a journal
			if(item_array[i].getID().charAt(0) =='J') {
				System.out.println((i+1) + ". " + ((Journal)(item_array[i])).toString()); //casting it as journal to get the appropriate toString() method 
			}
			//if it's a book
			else if(item_array[i].getID().charAt(0) =='B') {
				System.out.println((i+1) + ". " + ((Book)(item_array[i])).toString()); //casting it as book to get the appropriate toString() method
			}
			//if it's a media
			else if(item_array[i].getID().charAt(0) =='M') {
				System.out.println((i+1) + ". " + ((Media)(item_array[i])).toString()); //casting it as media to get the appropriate toString() method
			}
		}
		
	}
	
	//Add a client
	public static void addClient() {
	
	//Asking user about the new client's information
	System.out.println("\nPlease enter the following informations: ");
					
	System.out.println("Name: ");
	String clientName = in.nextLine();
					
	System.out.println("Phone Number: ");
	String clientPhoneNumber = in.nextLine();
					
	System.out.println("Email Address: ");
	String clientEmailAddress = in.nextLine();
				
	//Adding a client if there were none before			
	if (client_array == null || client_array.length == 0) {  
		client_array = new Client[1]; //assigning a new array of length one to the array that was null
		Client newClient = new Client(clientName, clientPhoneNumber, clientEmailAddress);
		client_array[0] = newClient; //adding the new client to that array
		
		//Checking if client was added successfully
		if (client_array.length == 1) { //if the length of the array originally was 0, and it is now 1, the client has been added successfully
			System.out.println("\nClient added successfully! \nYou will be brought back to the menu.");
		}
	}
	//Adding a client if there already were clients before
	else {
		Client[] new_client_array = new Client[client_array.length + 1]; //creating an array with one more slot than the original one
		int initialCount = client_array.length; //will be used later to check if client was added successfully
		
		//deep copying the original array into the new one
		for (int i=0; i<client_array.length; i++) {  
			new_client_array[i] = client_array[i];
		}
					
		Client newClient = new Client(clientName, clientPhoneNumber, clientEmailAddress);
		new_client_array[client_array.length] = newClient; //adding the new client at the end of the new array
				
		client_array = new_client_array;  //assigning the new array to the original one (to update the original array)
		
		//checking if client was added successfully
		if (client_array.length == (initialCount+1)) { //if the length of the original array has incremented by 1, client has been addded successfully
			System.out.println("\nClient added successfully! \nYou will be brought back to the menu.");
		}
	}

}
	
	//Edit a client 
	public static void changeClientInformation() {
		String clientID;
		String comparableID;
		String settableID;
		boolean validID = false;
		Client clientToChange = null;
		int informationToChange;
		String newID;
		String newName;
		String newPhoneNumber;
		String newEmailAddress;
		
		//Asking the user for the ID of the client they wish to update and checking input validity 
		do {
			System.out.println("\nPlease enter the ID of the client you wish to update:");
			clientID = in.next();
			in.nextLine();
			comparableID = (clientID.substring(0,1).toUpperCase())+clientID.substring(1, clientID.length());
			
			if (client_array == null || client_array.length == 0) { //checking if there are no clients
				break;
			}
			
			for (int i=0; i<client_array.length; i++) {
				if (client_array[i].getID().equals(comparableID)) {
					validID = true;
				}
			}
	
			if (!validID) {  
				System.out.println("This is not a valid ID. Please try again.");
			}
			
		}
		while (validID == false);
		
		//Message if there are no clients
		if (client_array == null || client_array.length == 0) { 
			System.out.println("\nThere is no client to modify. \nYou will be brought back to the menu.");
		}
		//Update of client information
		else {
			//getting the client the user wants to change
			for (int i=0; i<client_array.length; i++) {
				if (client_array[i].getID().equals(comparableID)) {
						clientToChange = client_array[i];
				}
			}
			
			//asking the user which information they wish to change and checking for input validity
			do {
				System.out.println("\nPlease enter the number of the information you wish to change: \n1. ID \n2. Name \n3. Phone Number \n4. Email Address");
				informationToChange = in.nextInt();
				in.nextLine();
					
				if (informationToChange < 1 || informationToChange > 4) {  
					System.out.println("This is not a valid option. Please try again.");
				}
				
			}
			while (informationToChange < 1 || informationToChange > 4);
			
			//Changing ID
			if(informationToChange == 1) {
				System.out.println("\nPlease enter the new ID:");
				newID = in.next();
				in.nextLine();
				settableID = (newID.substring(0,1).toUpperCase())+newID.substring(1, newID.length());
				boolean existentID = false;
				//checking if the ID is not already used
				for (int i=0; i<client_array.length; i++) {
					if(client_array[i].getID().equals(settableID)) {
						existentID = true;
					}
				}
				//if ID is not used
				if (!existentID) {
					clientToChange.setID(settableID);
					System.out.println("\nID change successfull! \nYou will be brought back to the menu.");
				}
				//if ID is already used
				else {
					System.out.println("\nSorry, this ID already exists. You will be brought back to the menu.");
				}
			}
			//Changing name
			else if(informationToChange == 2) {
				System.out.println("\nPlease enter the new name:");
				newName = in.nextLine();
				clientToChange.setName(newName);
				System.out.println("\nName change successfull! \nYou will be brought back to the menu.");
			}
			//Changing phone number
			else if(informationToChange == 3) {
				System.out.println("\nPlease enter the new phone number:");
				newPhoneNumber = in.nextLine();
				clientToChange.setPhoneNumber(newPhoneNumber);
				System.out.println("\nPhone number change successfull! \nYou will be brought back to the menu.");
			}
			//Changing email address
			else if(informationToChange == 4) {
				System.out.println("\nPlease enter the new email address:");
				newEmailAddress = in.nextLine();
				clientToChange.setEmailAddress(newEmailAddress);
				System.out.println("\nEmail address change successfull! \nYou will be brought back to the menu.");
			}
		}
	
	}
	
	
	//Remove a client 
	public static void deleteClient() {
		String clientID;
		String comparableID;
		boolean validID = false;
		int new_index = 0;
		boolean successfulRemoval = false;
		
		//Asking user the ID of the client they wish to remove and checking for input validity 
		do {
			System.out.println("\nPlease enter the ID of the client you wish to remove:");
			clientID = in.next();
			in.nextLine();
			comparableID = (clientID.substring(0,1).toUpperCase())+clientID.substring(1, clientID.length());
			
			if (client_array == null || client_array.length == 0) { //checking if there are clients
				break;
			}
			
			for (int i=0; i<client_array.length; i++) {
				if (client_array[i].getID().equals(comparableID)) {
					validID = true;
				}
			}
				
			if (!validID) {  
				System.out.println("\nThis is not a valid ID. Please try again.");
			}
			
		}
		while (validID == false);
		
		//Message if there are no clients
		if (client_array == null || client_array.length == 0) { //telling user that there is no client
			System.out.println("\nThere is no client to remove. \nYou will be brought back to the menu.");
		}
		
		//Removal of client
		else {
			Client[] new_client_array = new Client[client_array.length - 1]; //creating an array with one less slot
			//getting the client that the user wants to remove and setting it to null (removing it)
			for (int i=0; i<client_array.length; i++) {
				if (client_array[i].getID().equals(comparableID)) {
					client_array[i] = null;
				}
			}
			//copying all items from the original array to the new one (except the one removed)
			for (int i=0; i<client_array.length; i++) {
				if (client_array[i] != null) { 
					new_client_array[new_index++] = client_array[i]; 
				}	
			}
			//assigning the new array to the original one (to update the original array)
			client_array = new_client_array;
			
			//Checking if removal was successfull
			if (client_array.length == new_client_array.length) {  //both arrays should have the same length as the new one has been assigned to the first one
		        successfulRemoval = true;  //if they have the same length, the removal was successful 
		    }

		    if (successfulRemoval) {  //printing success message 
		        System.out.println("\nClient was removed successfully! \nYou will be brought back to the menu.");
		    }
		}
	
	}
	
	//Lease an item to a client
	public static void leaseItem() {
		String clientID;
		String comparableClientID;
		String itemID;
		String comparableItemID;
		boolean itemAlreadyLeased = false;
		boolean validClientID = false;
		boolean validItemID = false;
		Items[] new_client_leased_items_array = null;
		Client client = null;
		Items item = null;
		
		//Checking if there are clients
		if(client_array == null || client_array.length == 0) {
			System.out.println("\nThere is no client to lease an item to. \nYou will be brought back to menu.");
		}
		
		//Checking if there are items to lease
		else if(item_array == null || item_array.length == 0) {
			System.out.println("\nThere is no item to lease. \nYou will be brought back to menu.");
		}
		//Leasing 
		else {
			//Asking the user for the ID of the client to which the item will be leased and checking for input validity
			do {
				System.out.println("\nPlease enter the ID of the client you wish to lease the item to:");
				clientID = in.next();
				in.nextLine();
				comparableClientID = (clientID.substring(0,1).toUpperCase())+clientID.substring(1, clientID.length());
				
				for (int i=0; i<client_array.length; i++) {
					if (client_array[i].getID().equals(comparableClientID)) {
						validClientID = true;
						client = client_array[i]; //getting the client to which the item will be leased
					}
				}
					
				if (!validClientID) {  
					System.out.println("This is not a valid ID. Please try again.");
				}
				
			}
			while (validClientID == false);
			
			//Asking the user for the ID of the item that will be leased and checking for input validity
			do {
				System.out.println("\nPlease enter the ID of the item you wish to lease to the client:");
				itemID = in.next();
				in.nextLine();
				comparableItemID = (itemID.substring(0,1).toUpperCase())+itemID.substring(1, itemID.length());
				
				for (int i=0; i<item_array.length; i++) {
					if (item_array[i].getID().equals(comparableItemID)) {
						validItemID = true;
						item = item_array[i]; //getting the item that will be leased
					}
				}
					
				if (!validItemID) {  
					System.out.println("This is not a valid ID. Please try again.");
				}
				
			}
			while (validItemID == false);
			
			//checking if item has already been leased
			for (int i = 0; i<client_array.length; i++) {
				if(client_array[i].getClientItems() != null && client_array[i].getClientItems().length != 0) {
					for (int j = 0; j<client_array[i].getClientItems().length; j++) {
						if (client_array[i].getClientItems()[j].getID().equals(comparableItemID)){
							itemAlreadyLeased = true;
							break;
						}
					}
				}
				if(itemAlreadyLeased) {
					break;  //breaking out of the outer loop
				}
			}
			
			//getting the array of the client's leased items (items that are currently leased to the client)
			Items[] client_leased_items_array = client.getClientItems();
			
			//Message if item has already been leased
			if(itemAlreadyLeased) {
				System.out.println("\nThis item has already been leased. \nYou will be brought back to the menu.");
			}
			//Adding the item to the client's leased items array if the client had no items
			else if(client_leased_items_array == null || client_leased_items_array.length == 0) {
				client_leased_items_array = new Items[1]; //assigning a new array of length one to the array that was null
				client_leased_items_array[0] = item; //adding the item to the array
				client.setClientItems(client_leased_items_array); //updating the client's leased items array
				System.out.println("\nItem leased successfully! \nYou will be brought back to the menu."); //success message
			}
			//Adding the item to the client's leased items array if the client had items
			else {
				int initialCount = client_leased_items_array.length; //will be used later to check for success
				new_client_leased_items_array = new Items[client_leased_items_array.length + 1]; //creating a new array with one more slot than the original one

				//deep copying the original array into the new one 
				for (int i=0; i<client_leased_items_array.length; i++) {  
					new_client_leased_items_array[i] = client_leased_items_array[i];
				}
				//adding the item at the end of the new array
				new_client_leased_items_array[client_leased_items_array.length] = item;

				//assigning the new array to the original one to update the original one
				client_leased_items_array = new_client_leased_items_array; 
				//updating the client's leased items array
				client.setClientItems(client_leased_items_array);
				
				//checking if item was successfully leased
				if (client_leased_items_array.length == (initialCount+1)) { //if the client's leased items array's length has incremented by 1, lease was successfull
					System.out.println("\nItem leased successfully! \nYou will be brought back to the menu.");
				}
			}
		}

		
	}
	
	//Return an item from a client 
	public static void returnItem() {
		String clientID;
		String comparableClientID;
		String itemID;
		String comparableItemID;
		boolean clientHasItem = false;
		boolean validClientID = false;
		boolean validItemID = false;
		Client client = null;
		Items[] new_client_leased_items_array = null;
		int new_index = 0;
		boolean successfulRemoval = false;

		//Asking user for ID of client who is returning item and checking for input validity
		do {
			System.out.println("Please enter the ID of the client you wish to return the item from:");
			clientID = in.next();
			in.nextLine();
			comparableClientID = (clientID.substring(0,1).toUpperCase())+clientID.substring(1, clientID.length());
			
			for (int i=0; i<client_array.length; i++) {
				if (client_array[i].getID().equals(comparableClientID)) {
					validClientID = true;
					client = client_array[i]; //getting the client who is returning the item
				}
			}
				
			if (!validClientID) {  
				System.out.println("This is not a valid ID. Please try again.");
			}
			
		}
		while (validClientID == false);
		
		//Asking user for ID of item that is being returned and checking for input validity
		do {
			System.out.println("Please enter the ID of the item you wish to return from the client:");
			itemID = in.next();
			in.nextLine();
			comparableItemID = (itemID.substring(0,1).toUpperCase())+itemID.substring(1, itemID.length());
			
			for (int i=0; i<item_array.length; i++) {
				if (item_array[i].getID().equals(comparableItemID)) {
					validItemID = true;
				}
			}
				
			if (!validItemID) {  
				System.out.println("This is not a valid ID. Please try again.");
			}
			
		}
		while (validItemID == false);
		
		//getting the client's leased items array
		Items[] client_leased_items_array = client.getClientItems();
		
		//checking if the item was actually leased to that client
		for (int i=0; i<client_leased_items_array.length; i++) {
			if (client_leased_items_array[i].getID().equals(comparableItemID)) {
				clientHasItem = true;
			}
		}
		
		//If the client has no items
		if (client_leased_items_array == null || client_leased_items_array.length == 0) { 
			System.out.println("\nThere is no item to return. \nYou will be brought back to the menu.");
		}
		
		//if the client does not have that particular item 
		else if(clientHasItem == false) {
			System.out.println("The client currently has no item with the ID " + comparableItemID);
		}
		//Return
		else {
			new_client_leased_items_array = new Items[client_leased_items_array.length - 1]; //creating an array with one less slot
			
			//removing the item from the client's leased items array (setting it to null)
			for (int i=0; i<client_leased_items_array.length; i++) {
				if (client_leased_items_array[i].getID().equals(comparableItemID)) {
					client_leased_items_array[i] = null;
				}
			}
			
			//copying the original array into the old array (except for the removed item; the null)
			for (int i=0; i<client_leased_items_array.length; i++) {
				if (client_leased_items_array[i] != null) { 
					new_client_leased_items_array[new_index++] = client_leased_items_array[i]; 
				}	
			}
			
			//assigning the new array to the original one to udate the original one 
			client_leased_items_array = new_client_leased_items_array;
			
			//updating the client's leased items array
			client.setClientItems(client_leased_items_array);
			
			//Checking if return was successful
			if (client_leased_items_array.length == new_client_leased_items_array.length) {  //both arrays should have the same length as the new one has been assigned to the first one
		        successfulRemoval = true;  //if they have the same length, the removal (so the return) was successful 
		    }

		    if (successfulRemoval) {  //printing success message 
		        System.out.println("\nItem was returned successfully! \nYou will be brought back to the menu.");
		    }
		}
	
	}
	
	//Show all items leased by a client 
	public static void showClientLeasedItems() {
		String clientID;
		String comparableClientID;
		boolean validClientID = false;
		Client client = null;
		
		//If there are no clients
		if(client_array == null || client_array.length == 0) {
			System.out.println("\nThere is currently no client. \nYou will be brought back to the menu.");
		}
		else {
			//Asking the user for the ID of the client they wish to see and checking for input validity
			do {
				System.out.println("Please enter the ID of the client whose leased items you wish to see:");
				clientID = in.next();
				in.nextLine();
				comparableClientID = (clientID.substring(0,1).toUpperCase())+clientID.substring(1, clientID.length());
				
				for (int i=0; i<client_array.length; i++) {
					if (client_array[i].getID().equals(comparableClientID)) {
						validClientID = true;
						client = client_array[i]; //get the client
					}
				}
					
				if (!validClientID) {  
					System.out.println("This is not a valid ID. Please try again.");
				}
				
			}
			while (validClientID == false);
			
			//getting the client's leased items array
			Items[] client_leased_items_array = client.getClientItems();
			
			//if the client has no items
			if(client_leased_items_array == null || client_leased_items_array.length == 0) {
				System.out.println("\nThis client currently has no item. \nYou will be brought back to menu.");
			}
			//if the client has items
			else {
				for (int i = 0; i<client_leased_items_array.length ; i++) {
					if(client_leased_items_array[i].getID().charAt(0) =='J') {
						System.out.println((i+1) + ". " + ((Journal)(client_leased_items_array[i])).toString());
					}
					else if(client_leased_items_array[i].getID().charAt(0) =='B') {
						System.out.println((i+1) + ". " + ((Book)(client_leased_items_array[i])).toString());
					}
					else if(client_leased_items_array[i].getID().charAt(0) =='M') {
						System.out.println((i+1) + ". " + ((Media)(client_leased_items_array[i])).toString());
					}
				}
			}
		}
	

	}
	
	//Show all leased items by all clients
	public static void showAllLeasedItems() {
		boolean thereAreLeasedItems = false;
		
		//If there no clients, there are no leased items
		if(client_array == null || client_array.length == 0) {
			System.out.println("\nThere are no leased items, because there are no clients. \nYou will be brought back to the menu.");
		}
		else {
			//checking if there are leased items (because there can be clients, but no leased items yet)
			for (int i = 0; i<client_array.length; i++) {
				if(client_array[i].getClientItems() != null && client_array[i].getClientItems().length != 0) {
					thereAreLeasedItems = true;
				}
			}
			//if there are no leased items
			if (!thereAreLeasedItems) {
				System.out.println("\nThere are currently no leased items. \nYou will be brought back to the menu.");
			}
			else {
				//Displaying the client's name and ID, followed by all the items they have and doing the same for each client
				for (int i = 0; i<client_array.length; i++) {
					System.out.println("-----Client's name and ID: " + client_array[i].getName() + " " + client_array[i].getID() + " -----");
					if((client_array[i].getClientItems() != null) && (client_array[i].getClientItems().length != 0)){
						for (int j = 0; j<client_array[i].getClientItems().length ; j++) {
							if(client_array[i].getClientItems()[j].getID().charAt(0) =='J') {
								System.out.println((j+1) + ". " + ((Journal)(client_array[i].getClientItems()[j])).toString());
							}
							else if(client_array[i].getClientItems()[j].getID().charAt(0) =='B') {
								System.out.println((j+1) + ". " + ((Book)(client_array[i].getClientItems()[j])).toString());
							}
							else if(client_array[i].getClientItems()[j].getID().charAt(0) =='M') {
								System.out.println((j+1) + ". " + ((Media)(client_array[i].getClientItems()[j])).toString());
							}
						}
					}
				}
			}
		}

	}
	
	//Closing the scanner
	public static void closeScanner() {
		in.close();
	}
	
	
	}

