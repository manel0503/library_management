package Clients;
//to generate the clients' IDs
class client_ID_Generator { //Explanation: package-private because it will only be used in this package
	
	//Attribute
	//Explanation of access right: private because the attribute should not be directly accessible from outside the class; should only get accessed and modified within this class
	private static int clientCounter = 0;
	
	//Generating client ID
	//Explanation of access right: package-private because only used within the same package (Clients) 
	static String generateClientID() {
		clientCounter++;
		return "C" + clientCounter;
	}
}
