/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 *
 * @author Marcin Knyć
 * @version 0.3
 * All analysis results are stored in a field and returned with GetResults() in the end.
 */
public class Analysis {
    String text;
    ArrayList<String> results = new ArrayList<String>();
    
    public Analysis(AnalysisBuilder builder) throws InvalidTextInputException {
        text = builder.getText();

        //custom exception
        if (!containsLetters(text)){
            throw new InvalidTextInputException("The input text can't be only digits, whitespace and special chars, it needs to include letters.");
        }

        if (builder.wordFrequency){
            analyzeFrequency();
        }
        if (builder.vocabularyDiversity){
            analyzeVocabularyDiversity();
        }
        if (builder.sentenceLength){
            analyzeSentenceLength();
        }
        if (builder.paragraphLength){
            analyzeParagraphLength();
        }
    }

    public void analyzeParagraphLength() {
        String[] lines = text.split("\\r?\\n|\\r");
        int numberOfLines = lines.length;
        float averageParagraphLength = (float)text.length() / (float)numberOfLines;
        results.add("Average paragraph length: " + averageParagraphLength + " characters.");
    }

    public void analyzeSentenceLength() {
        String[] sentences = text.split( "\\." );
        int numberOfSentences = sentences.length;
        float averageSentenceLength = (float)text.length() / (float)numberOfSentences;
        results.add("Average sentence length: " + averageSentenceLength + " characters.");
    }

    public void analyzeVocabularyDiversity() {
        String result = getVocabularyDiversityGrade();
        results.add("Vocabulary diversity was graded as " + result);
    }

    private String getVocabularyDiversityGrade(){
        ConcurrentMap<String, Integer> freqMap = getWordFrequencyMap();
        int wordCountSum = 0;
        for (ConcurrentMap.Entry<String, Integer> entry : freqMap.entrySet())
        {
            wordCountSum += entry.getValue();
        }
        float wordCountAverage = (float)wordCountSum / (float)freqMap.size();

        if (wordCountAverage > 3) return "Miserable";
        if (wordCountAverage > 2.5) return "Very bad";
        if (wordCountAverage > 2) return "Average";
        if (wordCountAverage > 1.75) return "Good";
        return "Amazing";
    }

    public void analyzeFrequency() {
        PriorityQueue<String> pq = getListOfMostCommonWords(3);
        String word1 = pq.poll();
        String word2 = pq.poll();
        String word3 = pq.poll();
        results.add("Most common words: " + word1 + ", " + word2 + ", " + word3);
    }

    private PriorityQueue<String> getListOfMostCommonWords(int size) {
        ConcurrentMap<String, Integer> freqMap = getWordFrequencyMap();

        //Priority queue that uses frequency as the comparator and size as 3
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        for(String key: freqMap.keySet()) {
            pq.add(key);
            if(pq.size() > size) {
                pq.poll();
            }
        }
        return pq;
    }

    private ConcurrentMap<String, Integer> getWordFrequencyMap() {
        //source: https://www.javacodemonk.com/count-word-frequency-in-java-e6c2918a
        ConcurrentMap<String, Integer> freqMap =
                asList(text.split("[\\s.]"))
                        .parallelStream()
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        //System.out.println(freqMap.toString());
        return freqMap;
    }

    public ArrayList<String> GetResults(){
        return results;
    }
    private static boolean containsLetters(String string) {
        //source: https://dirask.com/posts/Java-check-if-string-contains-any-letters-pVmeRD
        if (string == null || string.isEmpty()) {
            return false;
        }
        for (int i = 0; i < string.length(); ++i) {            
            if (Character.isLetter(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
