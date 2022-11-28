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
 * @version 0.1
 */
public class Analysis {
    String text;
    ArrayList<String> results = new ArrayList<String>();
    
    public Analysis(AnalysisBuilder builder) throws InvalidTextInputException {
        text = builder.getText();

        String regexCheckIfContainsLetters = ".*[a-zA-Z].*";
        if (! text.matches(regexCheckIfContainsLetters)){
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
        results.add("paragraphLength normal");
    }

    public void analyzeSentenceLength() {
        results.add("sentenceLength normal");
    }

    public void analyzeVocabularyDiversity() {
        results.add("vocabularyDiversity normal");
    }

    public void analyzeFrequency() {
        PriorityQueue<String> pq = getListOfMostCommonWords(3);
        String word1 = pq.poll();
        String word2 = pq.poll();
        String word3 = pq.poll();
        results.add("Most common words: " + word1 + ", " + word2 + ", " + word3);
    }

    private PriorityQueue<String> getListOfMostCommonWords(int size) {
        //source: https://www.javacodemonk.com/count-word-frequency-in-java-e6c2918a
        ConcurrentMap<String, Integer> freqMap =
                asList(text.split("[\\s.]"))
                        .parallelStream()
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        //System.out.println(freqMap.toString());

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

    public ArrayList<String> GetResults(){
        return results;
    }
}
