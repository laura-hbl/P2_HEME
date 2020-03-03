package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptoms data on a new file
 * The important part is, sortedSymptoms which is an ordered list of symptoms,
 * that doesn't contain duplications.
 */
public interface ISymptomWriter {
    /**
     * write symptoms data on a new file. Symptoms are mapped to their number of occurrences.
     */
    void writeSymptoms(Map<String, Integer> sortedSymptoms);
}
