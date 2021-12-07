package com.example.demo;

import java.io.*;

public class DataHandler{
	
	public DataHandler(){
		//Initializes csv file with column headers.
		try{
			FileWriter results = new FileWriter("results.csv");
			results.append("Name,Result\n");
			results.flush();
			results.close();
		}
		catch (IOException e) {
			System.out.println("Error: Unable to initialize csv file");
		}
	}

	public void addEntry(String taker, String res){
		//Adds entry to csv file.
		try{
			FileWriter results = new FileWriter("results.csv",true);
			results.append(taker + "," + res + "\n");
			results.flush();
			results.close();
		}
		catch (IOException e) {
			System.out.println("Error: No csv file");
		}
	}

}