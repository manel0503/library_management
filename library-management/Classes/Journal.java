package Classes;


public class Journal extends Items{ //Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	
	//Attribute
	//Explanation of access right: private because the attribute should not be directly accessible from outside the class; should be accessed and modified through accessors and mutators (encapsulation)
	private int volumeNumber;
	
	//Constructors
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public Journal() {
		super();
	}
	public Journal(String name, String author, int yearOfPublication, int volumeNumber) {
		super(name, author, yearOfPublication);
		this.volumeNumber = volumeNumber;
		this.ID = items_ID_Generator.generateJournalID();
	}
	public Journal(Journal otherJournal) {
		super(otherJournal);
		this.volumeNumber = otherJournal.volumeNumber;
		this.ID = items_ID_Generator.generateJournalID();
	}
	
	//Accessor 
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public int getVolumeNumber() {
		return this.volumeNumber;
	}
	
	//Mutator 
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public void setVolumeNumber(int volumeNumber) {
		this.volumeNumber = volumeNumber;
	}
	
	//toString()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public String toString() {
		String journalMessage = "ID: " + this.ID + "\nName: " + this.name + "\nAuthor: " + this.author + "\nYear of Publication: " + this.yearOfPublication + "\nVolume Number: " + this.volumeNumber + "\n";
		return journalMessage;
	}
	
	//equals()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public boolean equals(Journal otherJournal) {
		return ((otherJournal != null) 
			&& (this.getClass() == otherJournal.getClass()) 
			&& (this.name.equals(otherJournal.name))
			&& (this.author.equals(otherJournal.author))
			&& (this.yearOfPublication == otherJournal.yearOfPublication)
			&& (this.volumeNumber == otherJournal.volumeNumber));
	}
}
