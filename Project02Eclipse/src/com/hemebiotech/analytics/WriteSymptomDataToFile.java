package com.hemebiotech.analytics;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }
}
