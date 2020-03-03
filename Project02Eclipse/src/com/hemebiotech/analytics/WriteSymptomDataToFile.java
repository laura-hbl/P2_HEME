package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

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
