package com.hemebiotech.analytics; 
 
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.List; 
 
/** 
 
Implémentation simple de l'interface ISymptomReader qui lit les symptômes à partir d'un fichier. 
 */ 
public class ReadSymptomDataFromFile implements ISymptomReader { 
 
  private String filePath; 
 
  /** 
 
    Crée une nouvelle instance de ReadSymptomDataFromFile pour lire des symptômes à partir
    d'un fichier.
    @param filePath le chemin complet ou partiel du fichier contenant les chaînes de symptômes
    un symptôme par ligne.
    */ 
  public ReadSymptomDataFromFile(String filePath) { 
    this.filePath = filePath; 
  } 
  /** 
 
Lit les données de symptômes à partir du fichier spécifié dans le constructeur. 
 
@return une liste brute de tous les symptômes obtenus à partir d'un fichier, les doublons
sont possibles/probables. 
  */ 
  @Override 
    public List<String> getSymptoms() { 
    ArrayList<String> result = new ArrayList<String>(); 
 
    if (filePath != null) { 
      try { 
        BufferedReader reader = new BufferedReader(new FileReader(filePath)); 
        String line = reader.readLine(); 
 
        while (line != null) { 
          result.add(line); 
          line = reader.readLine(); 
        } 
        reader.close(); 
      } catch (IOException e) { 
        e.printStackTrace(); 
      } 
    } 
 
    return result; 
  } 
 
}