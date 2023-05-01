package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.*;

	public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;		
	private static int pupilCount = 0;	
	private ISymptomReader readera ;
	private ISymptomWriter writera;

	public AnalyticsCounter (ISymptomReader readera,ISymptomWriter writera)
    {
		this.readera = readera;
    	this.writera = writera; 
    }

	public List<String> getSymptoms() {
        return this.readera.getSymptoms();
    }

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String,Integer> mamap = new HashMap<String,Integer>();

		for (String currentSymptom : symptoms){
			if (mamap.get(currentSymptom) == null){
				mamap.put(currentSymptom,1);
			}
			else {
				int nouvelleValeur = mamap.get(currentSymptom) + 1;
				mamap.put(currentSymptom,nouvelleValeur);
			}
		}
		return mamap;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	 }
    
    public void writeSymptoms(Map<String, Integer> sortedMap) {
		this.writera = writera;
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) { 
         String symptom = entry.getKey(); 
         int count = entry.getValue(); 
         writera.writeSymptoms(sortedMap); 
        } 
	}


	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();

        ReadSymptomDataFromFile readera = new ReadSymptomDataFromFile("symptoms.txt"); 
        readera.getSymptoms();


	}


	
}