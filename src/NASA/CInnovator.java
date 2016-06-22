package NASA;

//========================================================= //
//															//
//				This class is used to store					//
//			data from a child node of the JSON data			//
//					from NASA JSON data						//
//															//
//========================================================= //

public class CInnovator {
	
	private String fname;		// First name data
	private String lname;		// Last name data
	private String fullName;	// Concatenation of both first and last names
	
	// Default Constructor //
	public CInnovator() {
		//System.out.println("Calling CInnovator: ");		// Debug instantiation
	}
	
	// This is used to store the incoming first name data from NASA JSON //
	public void setFname(String s1){
		this.fname = s1;
	}
	
	// This is used to retrieve the first name data from NASA JSON //
	public String getFname(){
		return fname;
	}
	
	// This is used to store the incoming last name data from NASA JSON //
	public void setLname(String s2){
		this.lname = s2;
	}
	
	// This is used to retrieve the last name data from NASA JSON //
	public String getLname(){
		return lname;
	}	
	
	// This is used to concatenate and retrieve the first and last name data from NASA JSON //
	public String getFullName(){
		return fname + lname;
	}

}
