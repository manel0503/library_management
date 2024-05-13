package Clients;
import Classes.Items;

public class Client { //Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	
	//Attributes
	//Explanation of access right: private because the attribute should not be directly accessible from outside the class; should be accessed and modified through accessors and mutators (encapsulation)
	private Items[] client_leased_items_array;
	private String ID;
	private String name;
	private String phoneNumber;
	private String emailAddress;
	
	//Constructors
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public Client(){
		
	}
	public Client(String name, String phoneNumber, String emailAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.ID = client_ID_Generator.generateClientID();
		this.client_leased_items_array = null;
	}
	public Client(Client otherClient) {
		this.name = otherClient.name;
		this.phoneNumber = otherClient.phoneNumber;
		this.emailAddress = otherClient.emailAddress;
		this.ID = client_ID_Generator.generateClientID();
		this.client_leased_items_array = null;
	}
	
	//Accessors 
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public Items[] getClientItems() {
		return this.client_leased_items_array;
	}
	public String getID() {
		return this.ID;
	}
	public String getName() {
		return this.name;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	//Mutators
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public void setClientItems(Items[] client_items_array) {
		this.client_leased_items_array = client_items_array;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	//toString()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public String toString() {
		String clientMessage = "ID: " + this.ID + "\nName: " + this.name + "\nPhone Number: " + this.phoneNumber + "\nEmail Address: " + this.emailAddress + "\n";
		return clientMessage;
	}
	
	//equals()
	//Explanation of access right: public because will be used outside of the Classes package (will be used in Driver package)
	public boolean equals(Client otherClient) {
		return ((otherClient != null) 
				&& (this.getClass() == otherClient.getClass()) 
				&& (this.name.equals(otherClient.name))
				&& (this.phoneNumber.equals(otherClient.phoneNumber))
				&& (this.emailAddress.equals(otherClient.emailAddress)))
				&& (this.client_leased_items_array == otherClient.client_leased_items_array);
	}
	
	
}
