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
 * @version 0.5
 * All analysis results are stored in a field and returned with GetResults() in the end.
 * is now a singleton for uses of f4
 */
public class Analysis {
    //custom singleton logic:
    private static Analysis instance = null;

    public static Analysis getInstance(){
        return instance;
    }

    public static void setInstance(Analysis analysis) throws InvalidTextInputException {
        instance = analysis;
    }

    //actual analysis:
    String text;
    public String getText() {
        return text;
    }
    ArrayList<String> results = new ArrayList<String>();
    
    public Analysis(AnalysisBuilder builder) throws InvalidTextInputException {
        text = builder.getText();

//        //custom exception
//        if (!containsLetters(text)){
//            throw new InvalidTextInputException("The input text can't be empty, only digits, whitespace and special chars, it needs to include letters.");
//        }
//
////        if (builder.wordFrequency){
////            analyzeFrequency();
////        }
//        if (builder.vocabularyDiversity){
//            analyzeVocabularyDiversity();
//        }
//        if (builder.sentenceLength){
//            analyzeSentenceLength();
//        }
//        if (builder.paragraphLength){
//            analyzeParagraphLength();
//        }
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


    public ArrayList<String> getResults(){
        return results;
    }

}
