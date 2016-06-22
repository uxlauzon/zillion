package NASA;

//======================================================== //
//														   //		
//		This class is used to store JSON data for output   //
//		This class is constructed to work with Google	   //
//		GSON library class								   //
//														   //
//======================================================== //


public class CJsonOutput {
	
	private String name;	// First and last names with a space separating the two
	private int count;		// Palindrome count data
	
	
	// Retrive first and last name //
	public String getName() {
		return name;
	}
	
	// Store the first and last name data //
	public void setName(String name) {
		this.name = name;
	}
	
	// Get the palindrome count //
	public int getCount() {
		return count;
	}
	
	
	// Store the palindrome count //
	public void setCount(int nPalindromeCount) {
		this.count = nPalindromeCount;
	}

	
}
