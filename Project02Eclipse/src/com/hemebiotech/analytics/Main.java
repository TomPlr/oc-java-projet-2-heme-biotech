package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    /**
     * Main entry of the app
     * @param args String[]
     */
    public static void main(String[] args)  {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader,writer);

        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> symptomsCount = counter.countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomsCount);

        counter.writeSymptoms(sortedSymptoms);
    }

}