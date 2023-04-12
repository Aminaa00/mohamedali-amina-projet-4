package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    
    @Override
    public void writeSymptom(Map<String, Integer> symptom) {
        try {
        	// On crée l'objet FileWriter pour écrire dans notre fichier
            FileWriter writer = new FileWriter("result.out");
            
         // On parcours Map des symptômes et on écrit chaque entrée dans result.out
         // avec la clé (symptôme) et la valeur (quantité)
            for (Map.Entry<String, Integer> entry : symptom.entrySet())
            {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}