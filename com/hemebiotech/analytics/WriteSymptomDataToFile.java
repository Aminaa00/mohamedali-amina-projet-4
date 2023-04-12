package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter("result.out");
            for (String key : symptoms.keySet()) {
                writer.write(key + " : " +  symptoms.get(key) + "\n");
            }
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}