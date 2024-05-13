package Classes;

//to generate the ID's for each item
class items_ID_Generator { //Explanation: package-private because it will only be used in this package
	//Attributes
	//Explanation of access right: private because the attribute should not be directly accessible from outside the class; should only get accessed and modified within this class
	private static int itemCounter = 0;
	private static int journalCounter = 0;
	private static int bookCounter = 0;
	private static int mediaCounter = 0;

	
	//Generating item ID
	//Explanation of access right: package-private because only used within the same package (Clients)
	static String generateItemID() {
		itemCounter++;
		return "I" + itemCounter;
	}
		
	//Generating journal ID
	//Explanation of access right: package-private because only used within the same package (Clients)
	static String generateJournalID() {
		journalCounter++;
		return "J" + journalCounter;
	}
	
	//Generating book ID
	//Explanation of access right: package-private because only used within the same package (Clients)
	static String generateBookID() {
		bookCounter++;
		return "B" + bookCounter;
	}
	
	//Generating media ID
	//Explanation of access right: package-private because only used within the same package (Clients)
	static String generateMediaID() {
		mediaCounter++;
		return "M" + mediaCounter;
	}
}
