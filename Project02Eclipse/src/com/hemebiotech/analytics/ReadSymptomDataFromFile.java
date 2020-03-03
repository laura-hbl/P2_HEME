package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads symptom data from a file that may contains duplicate symptoms, one per line.
 *
 * @see ISymptomReader
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	 private String filepath;

	/**
	 * Constructor of class ReadSymptomDataFromFile, initialize filepath.
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	 ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads each symptom from the file and adds it to an ArrayList.
	 *
	 * @return a list of all Symptoms obtained from a data source, duplicates are possible/probable.
	 */
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
