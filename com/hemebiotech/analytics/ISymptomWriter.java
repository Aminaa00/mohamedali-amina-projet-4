package com.hemebiotech.analytics; 
 
import java.util.Map; 
 
/** 
 * Interface pour écrire les données de symptômes dans un format de sortie de données valide. 
 * 
 */ 
public interface ISymptomWriter { 
 
  /** 
    * Écrit les données de symptômes dans un format de sortie de données valide. 
    *
    * @param listSymptoms une Map qui contient les symptômes et leurs occurrences respectif. 
    */
  public void writeSymptoms(Map<String, Integer> listSymptoms);
}