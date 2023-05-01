package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        ISymptomWriter writerb = new WriteSymptomDataToFile();
        ISymptomReader readerb = new ReadSymptomDataFromFile("symptom.txt");
        AnalyticsCounter counter = new AnalyticsCounter(readerb,writerb);

    }







}