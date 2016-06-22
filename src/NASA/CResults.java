package NASA;

import java.util.ArrayList;

public class CResults {
	
	private String category;					// Store category names, which will be needed for searching
	private ArrayList<CInnovator> innovator;	// Array of CInnovator classes, used to store innovator information
	
	public CResults() {
		//System.out.println("Calling CResults: ");	// Debug instantiation
	}	
	
	// Store NASA category data //
	public void setCategory(String s0){
		this.category = s0;
	}
	
	// Retrieve NASA category data //
	public String getCategory(){
		return category;
	}
	

	// Store child nodes from NASA JSON, place the data into the CInnovator class //
	public void setInnovator(ArrayList<CInnovator> i0){
		this.innovator = i0;
	}
	
	
	// Retrieve stored data from CInnovator class //
	public ArrayList<CInnovator> getInnovator() {
	    return this.innovator;
	}	
	

}
