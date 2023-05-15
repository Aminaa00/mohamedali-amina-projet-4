package com.hemebiotech.analytics; 
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
 
/** 
 * Cette classe fournit une méthode de comptage des symptômes à partir d'une liste de symptômes 
 * et une méthode pour trier les symptômes dans l'ordre alphabétique.
 * Elle écrit également les résultats triés 
 * dans un fichier de sortie.
 */
public class AnalyticsCounter { 
     
  // Interface pour la lecture de données de symptômes 
  private ISymptomReader read; 
     
  // Interface pour l'écriture des données de symptômes 
  private ISymptomWriter write; 

  /** 
     * Constructeur de la classe AnalyticsCounter. 
     * @param read Interface pour la lecture de données de symptômes 
     * @param write Interface pour l'écriture des données de symptômes 
     */ 
  public AnalyticsCounter(ISymptomReader read, ISymptomWriter write) { 
    this.read = read; 
    this.write = write; 
  } 
     
  /**
     * Méthode pour obtenir la liste de tous les symptômes.
     * @return {@link List} of {@link String} Liste de tous les symptômes 
     */ 
  public List<String> getSymptoms() { 
    return this.read.getSymptoms(); 
  } 
     
  /** 
     * Méthode pour compter les occurrences de chaque symptôme.
     * @param symptoms Liste de symptômes 
     * @return Map contenant le nombre d'occurrences de chaque symptôme 
     */ 
  public Map<String, Integer> countSymptoms(List<String> symptoms) { 
    Map<String, Integer> symptomMap = new HashMap<String, Integer>(); 
         
    for (String currentSymptom : symptoms) { 
      if (symptomMap.get(currentSymptom) == null) { 
        symptomMap.put(currentSymptom, 1); 
      } else { 
        int newValue = symptomMap.get(currentSymptom) + 1; 
        symptomMap.put(currentSymptom, newValue); 
      } 
    } 
         
    return symptomMap; 
  } 
     
  /** 
  * Méthode pour trier les symptômes dans l'ordre alphabétique.
  * @param symptoms Map contenant le nombre d'occurrences de chaque symptôme 
  * @return Map triée dans l'ordre alphabétique 
  */ 
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms); 
    return sortedSymptoms; 
  } 
     
  /** 
     * Méthode pour écrire les symptômes triés dans un fichier de sortie.
     * @param sortedMap Map triée des symptômes 
     */ 
  public void writeSymptoms(Map<String, Integer> sortedMap) { 
    this.write = write; 
    for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) { 
      String symptom = entry.getKey(); 
      int count = entry.getValue(); 
      write.writeSymptoms(sortedMap); 
    } 
  }
}