package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {

		ArrayList<String> symptomsList = new ArrayList<>();

		if (filepath != null) {
			try (BufferedReader bufferedReader = new BufferedReader (new FileReader(filepath))) {
				String line = bufferedReader.readLine();
				while (line != null) {
					symptomsList.add(line);
					line = bufferedReader.readLine();
				}
				for (String symptom : symptomsList) {
					System.out.println("symptom from file: " + symptom);
				}
			} catch (FileNotFoundException e) {
				System.err.println("Error while opening " + filepath);
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error while reading " + filepath);
				e.printStackTrace();
			}
		}

		return symptomsList;
	}
}
