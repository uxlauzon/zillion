package NASA;

import java.util.ArrayList;

// ======================================================== //
//															//
//				This class is used to store 				//
//			JSON data using Google's GSON library			//
//		  Variable names must match JSON data names			//
//															//
//========================================================= //

public class CJsonObj {
	
	private int count;						// Count data 
	private ArrayList<CResults> results;	// Array list containing child nodes from NASA JSON
	
	public CJsonObj() {
		//System.out.println("Calling CJson: ");	// Debug instantiation
	}
	
	// This is used to store the incoming count data from NASA JSON //
	public void setCount(int n0){
		this.count = n0;
	}
	
	// This is used to retrieve the count data from NASA JSON //
	public int getCount(){
		return count;
	}
	
	// This is used to store the incoming results data from NASA JSON, which is in the format of an array //
	public void setResults(ArrayList<CResults> c0){
		this.results = c0;
	}
	
	// This is used to retrieve the results data from NASA JSON //
	public ArrayList<CResults> getResults() {
	    return this.results;
	}	
	
	
	
	// Debug all the data that is being captured from NASA and print to Console window //
	
	/*
    @Override
    public String toString()
    {   	
    	return "CJsonObj [Count = " + this.count + " " + this.results.get(0).getCategory() + 
    		   " First name: " + this.results.get(0).getInnovator().get(0).getFname()+ 
    		   " Last name: " + this.results.get(0).getInnovator().get(0).getLname()+"]";
    }  	
	*/
}
