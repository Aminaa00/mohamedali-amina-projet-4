package com.hemebiotech.analytics; 
 
import java.util.List; 
 
/** 
 * Interface pour lire les données de symptômes à partir d'une source. La valeur 
 * de retour est une liste de chaînes de caractères qui peut contenir de 
 * nombreuses duplications. L'implémentation n'a pas besoin de trier la liste. 
 */ 
public interface ISymptomReader { 
 
  /** 
  * Si aucune donnée n'est disponible, retourne une liste vide. 
  *  
  * @return une liste brute de tous les symptômes obtenus à partir d'une source de données
  */
  public List<String> getSymptoms();
}