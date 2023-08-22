package com.hemebiotech.analytics;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;


	/**
	 * Public constructor of AnalyticsCounter
	 *
	 * @param reader ISymptomReader
	 * @param writer ISymptomWriter
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsCount = new HashMap<>();

		for (String symptom : symptoms) {
			symptomsCount.merge(symptom, 1, Integer::sum);
		}

		return symptomsCount;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}