package com.hemebiotech.analytics; 
 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Iterator; 
import java.util.Map; 
 
/** 
 
Une implémentation de l'interface ISymptomWriter qui écrit des données
de symptômes sur un fichier de sortie valide. 
 */ 
public class WriteSymptomDataToFile implements ISymptomWriter { 
 
  /** 
  * Écrit les symptômes et leur nombre associé sur un fichier de sortie. 
  *
  * @param listSymptoms une Map contenant les symptômes en tant que clés
  et leur nombre d'occurrences en tant que valeurs. 
  */ 
  @Override 
  public void writeSymptoms(Map<String, Integer> listSymptoms) { 
    try { 
      FileWriter writer = new FileWriter("result.out"); 
      for (String key : listSymptoms.keySet()) { 
        writer.write(key + " : " +  listSymptoms.get(key) + "\n"); 
      } 
      writer.close(); 
    } catch (IOException e) {
      e.printStackTrace(); 
    } 
  }
}