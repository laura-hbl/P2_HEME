package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

/**
 * Writes symptoms data and their occurrences to a new generated file.
 *
 * @see ISymptomWriter
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

     private String filepath;

    /**
     * Constructor of class WriteSymptomDataToFile, initialize filepath.
     *
     * @param filepath a full or partial path to file with symptom strings in it, one per line.
     */
     WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Write symptoms as well as the number of their occurrences to a new file, one per line.
     *
     * @param sortedSymptoms symptoms mapped to their number of occurrences.
     */
    public void writeSymptoms(Map<String, Integer> sortedSymptoms) {
        if (filepath != null) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath))) {
                bufferedWriter.write("List of symptoms encountered and their occurrences: " + "\n");
                for (Map.Entry symptom : sortedSymptoms.entrySet()) {
                    bufferedWriter.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
                }
            } catch (FileNotFoundException e) {
                System.err.println("Error while opening " + filepath);
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("Error while writing " + filepath);
                e.printStackTrace();
            }
        }
    }
}
