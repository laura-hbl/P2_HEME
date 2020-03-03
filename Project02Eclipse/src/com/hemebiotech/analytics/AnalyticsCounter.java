package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	public static void main(String args[])  {

		ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptoms = symptomReader.GetSymptoms();

		ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");
		Map<String, Integer> symptomMap = new TreeMap<>();

	}
}
