/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 *
 * @author Student
 */
@Entity
public class VocabularyDiversityAnalysisResult implements Serializable {
    public String grade;
    public VocabularyDiversityAnalysisResult(){}
    public VocabularyDiversityAnalysisResult(Text _text){
        dateCreatedTimestamp = 1673259100;
        text = _text;
        calculateVocabularyDiversityGrade();
    }
    
    private void calculateVocabularyDiversityGrade(){
        ConcurrentMap<String, Integer> freqMap = getWordFrequencyMap();
        int wordCountSum = 0;
        for (ConcurrentMap.Entry<String, Integer> entry : freqMap.entrySet())
        {
            wordCountSum += entry.getValue();
        }
        float wordCountAverage = (float)wordCountSum / (float)freqMap.size();

        if (wordCountAverage > 3) grade =  "Miserable";
        else if (wordCountAverage > 2.5) grade =  "Very bad";
        else if (wordCountAverage > 2) grade =  "Average";
        else if (wordCountAverage > 1.75) grade =  "Good";
        else grade =  "Amazing";
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
    @Override
    public String toString() {
        return "Vocabulary diversity was graded as " + grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    //COMMON:


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

    @ManyToOne
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
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
        if (!(object instanceof VocabularyDiversityAnalysisResult)) {
            return false;
        }
        VocabularyDiversityAnalysisResult other = (VocabularyDiversityAnalysisResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    
}
