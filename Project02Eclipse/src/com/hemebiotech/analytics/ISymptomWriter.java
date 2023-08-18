package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Write symptoms in a file
     *
     * @param symptoms Map<String, Integer>
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
