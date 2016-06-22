package NASA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//======================================================== //
//														   //
//				CPalindrom class is used to check		   //
//				for palindromes. Anagrams are created	   //
//				in this class, along with searching		   //
//				the categories to retrieve first and	   //
//				last names to create the palindrome		   //
//				test string.							   //
//														   //
//======================================================== //

public class CPalindrome {
	
	private CJsonObj json0;												// Store JSON object data //
	private String strSearch;											// Store search string //
	private ArrayList<String> alNames = new ArrayList<String>();		// Array list of first and last names //
	private Set<String> setAnagrams = new HashSet<String>();			// Hash set of anagrams, this data structure was used to avoid duplicates //

	
	// Default Constructor //
	public CPalindrome() {
		//System.out.println("Calling Default CPalindrome: ");
	}
	
	// Constructor used if instantiating with JSON object, this object is a GSON object using the Google GSON library //
	public CPalindrome(CJsonObj cj0) {
		this.json0 = cj0;
	}	
	
	// Set JSON Object, this object is a GSON object using the Google GSON library //
	public void setJason(CJsonObj cj0){
		this.json0 = cj0;
	}
	
	
	
	   // ********************************************************* //
	   //															//
	   //					Function searchCategory					//
	   //					Parameters: 1 (String)					//
	   //					Return type: none						//
	   //															//
	   // ********************************************************* //	
	public void searchCategory(String strCategory){
		
		for(int i = 0; i < json0.getResults().size(); ++i){
			String strCat = json0.getResults().get(i).getCategory().replaceAll("\\s",""); 	// Remove white space
			String strCategoryInput = strCategory.replaceAll("\\s","");					  	// Remove white space
			
			if(strCategoryInput.contentEquals(strCat)){
				String strFirst = json0.getResults().get(i).getInnovator().get(0).getFname();
				String strLast = json0.getResults().get(i).getInnovator().get(0).getLname();
				String strFullName = strFirst.toLowerCase() + " " + strLast.toLowerCase();	// Lower case
				alNames.add(strFullName);
				
				// System.out.println(strCat + "  " + strFullName);							// Debug names
			}
		}
		
	}
	
	
	   // ********************************************************* //
	   //															//
	   //					Function getNamesArray					//
	   //					Parameters: none						//
	   //					Return type: ArrayList 					//
	   //															//
	   // ********************************************************* //		
	public ArrayList<String> getNamesArray(){
		return alNames;
	}
	
	   
	   
	   // ********************************************************* //
	   //															//
	   //					Function reverseString					//
	   //					Parameters: 1 (String)					//
	   //					Return type: String						//
	   //															//
	   // ********************************************************* //
	   
		public String reverseString(String s0){
			char[] tempArray = s0.toCharArray();
			String strResult = "";
			int left, right;
			right = tempArray.length - 1;
			
			for(left = 0; left < right; left++, right--){
				char temp0 = tempArray[left];
				tempArray[left] = tempArray[right];
				tempArray[right] = temp0;
			}
			for(char c : tempArray){
				strResult += c;
			}
			
			return strResult;
			//System.out.println(strOut);
		}	

		
		
		
		   // ********************************************************* //
		   //															//
		   //					Function isPalindrome					//
		   //					Parameters: 1 (String)					//
		   //					Return type: boolean					//															//
		   //															//
		   // ********************************************************* //
		
		// This was used to compare string 1 with its mirror //
		public boolean isPalindrome(String s1, String s2){
			//System.out.println("In: " + strIn + "  Out: " + strOut);
			
			return s2.equals(s1);
		}
		
		
		
		
		
		   // ********************************************************* //
		   //															//
		   //					Function setAnagram						//
		   //					Parameters: 1 (String)					//
		   //					Return type: none						//															//
		   //															//
		   // ********************************************************* //
		
		public void setAnagram(String s0){
			
			
			for(int i = 0; i < s0.length(); ++i){
				
			}
			
			Set<String> set0 = new HashSet<String>();
			if(set0.contains(s0)){
				set0.remove(s0);
			}
			else{
				set0.add(s0);
			}
			
			System.out.println(set0.toString());
			
		}
	    
	    

		   // ********************************************************* //
		   //															//
		   //					Function createAnagrams					//
		   //					Parameters: 1 (String)					//
		   //					Return type: none						//															//
		   //															//
		   // ********************************************************* //		
		public void createAnagrams(String word) {
			anagramGen("",word);
	    }	
		

		   // ********************************************************* //
		   //															//
		   //					Function anagramGen					//
		   //					Parameters: 2 (String, String)			//
		   //					Return type: none						//															//
		   //															//
		   // ********************************************************* //
		
	    private void anagramGen(String prefix, String word) {
	    	
	        if (word.length()<=1){
	        	String strAnagram = prefix.toLowerCase() + word.toLowerCase();
	        	
	        	if(!setAnagrams.contains(strAnagram)){
	        		setAnagrams.add(strAnagram);
	        		
	        	}            
	        }
	        else {
			      // do the recursion removing the first letter of word
	        	anagramGen(prefix+word.charAt(0),word.substring(1));
					// do the recursion removing each middle letter of word
	            for (int i=1; i<=word.length()-2; i++) {
	            	anagramGen(prefix+word.charAt(i),
	                word.substring(0,i)+word.substring(i+1));
	            }
			      // do the recursion removing the last letter of word
	            anagramGen(prefix+word.charAt(word.length()-1),
	                    word.substring(0, word.length()-1));
	        }
	    }			
		

	    
		   // ********************************************************* //
		   //															//
		   //					Function getAnagramsSet					//
		   //					Parameters: 0 (None)					//
		   //					Return type: Set						//															//
		   //															//
		   // ********************************************************* //
	    
	    public Set getAnagramsSet(){
	    	
	    	// System.out.println(setAnagrams.toString());
	    	return setAnagrams;
	    }
	    
	    
		
		   // ********************************************************* //
		   //															//
		   //					Function getPalindromeCount				//
		   //					Parameters: 0 (None)					//
		   //					Return type: int						//															//
		   //															//
		   // ********************************************************* //	    
	    public int getPalindromeCount(){
	    	
	    	int nPalindromeCount = 0;
	    	
	    	for(String s : setAnagrams){
	    		//System.out.println("Anagrams:  " + s);
    			if(isPalindrome(s, reverseString(s))){
    				System.out.println(s + " reverse: " + s);
    				nPalindromeCount++;
    			}
	    	}
	    	
	    	return nPalindromeCount;
	    }
	    
	    
		
	    
	    // --------------------------------------------------------------------------------- //
	    // Initial tests and experiments													 // 
		//																					 //
		// ================================================================================= //
		   // First attempt to create anagrams and test if it is a palindrome 
		
		   // print N! permutation of the characters of the string s (in order)
		
		   public void permutation1(String s) { permutation1("", s); }
		   public void permutation1(String prefix, String s) {
		       int N = s.length();
		       if (N == 0) {
		    	   
		    	   //System.out.println("Result: " + prefix);
		    	   String suffix = reverseString(prefix);

		    	   if(isPalindrome(prefix, suffix)){
		    		   System.out.println("Palindrome found: " + prefix);	// Debug to console //
		    	   }
		       }
		       else {
		           for (int i = 0; i < N; i++)
		        	   permutation1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
		       }
		   }	
		   
		   // This was used as a second test with no ordering //
		   // print N! permutation of the elements of array a (not in order)
		   public static void permutation2(String s) {
		       int N = s.length();
		       char[] a = new char[N];
		       for (int i = 0; i < N; i++)
		           a[i] = s.charAt(i);
		       permutation2(a, N);
		   }

		   
		   private static void permutation2(char[] a, int n) {
		       if (n == 1) {
		    	   System.out.println(a);
		           return;
		       }
		       for (int i = 0; i < n; i++) {
		           swap(a, i, n-1);
		           permutation2(a, n-1);
		           swap(a, i, n-1);
		       }
		   }  
		  
		   
		   
		   // swap the characters at indices i and j
		   private static void swap(char[] a, int i, int j) {
		       char c = a[i];
		       a[i] = a[j];
		       a[j] = c;
		   }		
		
		// ================================================================================= //
		// ================================================================================= //
	    
	    
}
