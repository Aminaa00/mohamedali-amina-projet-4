package com.hemebiotech.analytics; 
 
import java.util.List; 
import java.util.Map; 
 
/** 
 
Point d'entrée de l'application qui lit les symptômes depuis un fichier texte, 
 
compte leur occurrence et écrit les résultats dans un fichier de sortie. 
 */ 
public class Main {
  /** 
  * Méthode principale de l'application. 
  * Elle crée les instances des classes ReadSymptomDataFromFile, WriteSymptomDataToFile 
  * et AnalyticsCounter pour lire les données de symptômes, les analyser et les écrire 
  * dans un fichier de sortie. 
  * 
  * @param args Les arguments de la ligne de commande (non utilisés dans cette application). 
  */
  public static void main(String[] args) { 
    // Initialisation des objets Writer, Reader et Counter 
    ISymptomWriter writer = new WriteSymptomDataToFile(); 
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt"); 
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer); 

    List<String> symptoms = reader.getSymptoms();
 
    // Récupération des symptômes et comptage de leur occurrence 
    Map<String, Integer> symptomByNumber = counter.countSymptoms(symptoms); 
 
    // Trier les symptoms
    Map<String,Integer> symptomByNumberSorted = counter.sortSymptoms(symptomByNumber);

    // Écriture des résultats dans le fichier de sortie 
    writer.writeSymptoms(symptomByNumberSorted);
  } 
}