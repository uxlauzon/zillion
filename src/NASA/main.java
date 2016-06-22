package NASA;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class main {

	
	public static void main(String[] args) {
		String key0 = "7F9C9suffLRhJ9Mo6qubRaNDwSoVTGLdpy5UDyKg";	// Key needed to retrieve data from NASA
		String strTemp = "madam";									// Debug palindrome string 
		String strCategory = "materials and coatings";				// Category to search
		
        try{
			
        	URL url = new URL("https://api.nasa.gov/patents/content?query=temperature&limit=5&api_key=" + key0);
            Reader reader = new InputStreamReader(new URL(url.toString()).openStream()); //Read the json output
            
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            CJsonObj j0 = gson.fromJson(reader,  CJsonObj.class);            
            CPalindrome cp0 = new CPalindrome(j0);
            cp0.searchCategory(strCategory);
            
            cp0.createAnagrams(strTemp);	// Debug with test string //
            
            //System.out.println(cp0.getNamesArray().get(0));
            //cp0.createAnagrams(cp0.getNamesArray().get(0).replaceAll("\\s+",""));	// Remove white space with Regex

        	Set <String> set0 = new HashSet<String>();	// Create set to store anagrams
        	set0 = cp0.getAnagramsSet();				// Retrieve anagrams created
        	int nResult = cp0.getPalindromeCount();		// Check for palindromes
      
        	//System.out.println("Set size: " + set0.size());			// Debug Hash set size
        	//System.out.println("Total palindrome count: " + nResult);	// Debug palindrome count
        	
        	// Instantiate CJsonOutput class to store results to be sent to GSON library //
        	CJsonOutput jsonOut = new CJsonOutput();
        	jsonOut.setName(cp0.getNamesArray().get(0));
        	jsonOut.setCount(nResult);
        	
        	// Create GSON data
        	Gson g1 = new Gson();
        	g1.toJson(jsonOut);	// Input CJsonOutput class //
            
        }catch(Exception e){
            System.out.println(e);
        }			
		

	}

}
