/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 *
 * @author Marcin Knyć
 * @version 0.2
 */
@Entity
public class WordFrequencyAnalysisResult implements Serializable {
    public WordFrequencyAnalysisResult(){

    }
    public WordFrequencyAnalysisResult(Text _text){
        dateCreatedTimestamp = 1673259100;
        mostCommonWords = "Me, Myself and Alicja";
        text = _text;
        analyzeFrequency();
    }

    public void analyzeFrequency() {
        PriorityQueue<String> pq = getListOfMostCommonWords(3);
        String word1 = pq.poll();
        String word2 = pq.poll();
        String word3 = pq.poll();
        this.mostCommonWords = word1 + ", " + word2 + ", " + word3;
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
                asList(text.getContent().split("[\\s.]"))
                        .parallelStream()
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        //System.out.println(freqMap.toString());
        return freqMap;
    }


    private String mostCommonWords;

    public String getMostCommonWords() {
        return mostCommonWords;
    }

    public void setMostCommonWords(String mostCommonWords) {
        this.mostCommonWords = mostCommonWords;
    }
    @Override
    public String toString() {
        return "Most common words: " + this.mostCommonWords;
    }

    //COMMON:

    @ManyToOne
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }    
    
    private int dateCreatedTimestamp;

    /**
     * @return the value of dateCreatedTimestamp
     */
    public int getDateCreatedTimestamp() {
        return dateCreatedTimestamp;
    }

    /**
     * @param dateCreatedTimestamp new value of dateCreatedTimestamp
     */
    public void setDateCreatedTimestamp(int dateCreatedTimestamp) {
        this.dateCreatedTimestamp = dateCreatedTimestamp;
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WordFrequencyAnalysisResult)) {
            return false;
        }
        WordFrequencyAnalysisResult other = (WordFrequencyAnalysisResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
