package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Counting symptoms's occurrences from the raw list.Then add to a TreeMap for a alphabetically sorting.
 * Symptoms as key and their occurrences as values.
 */
public class AnalyticsCounter {
	
	public static void main(String args[])  {

		ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = symptomReader.GetSymptoms();

		ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");
		Map<String, Integer> symptomMap = new TreeMap<>();

		//loop through the ArrayList in order to detect symptoms's duplicate by counting their occurrences.
        for (String symptom : symptoms) {
            String symptomLowerCase = symptom.toLowerCase();

            if (symptomMap.containsKey(symptomLowerCase)) {
                int count = symptomMap.get(symptomLowerCase);
                count++;
                symptomMap.put(symptomLowerCase, count);
            } else {
                symptomMap.put(symptomLowerCase, 1);
            }
        }

        symptomWriter.writeSymptoms(symptomMap);
	}
}