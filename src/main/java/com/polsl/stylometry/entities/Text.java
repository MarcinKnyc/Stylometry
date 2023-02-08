/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.entities;

import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.EntityManagerSingleton;
import com.polsl.stylometry.model.InvalidTextInputException;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * in order to avoid anemic domain entities, database logic is included in this class.
 *
 * @author Student
 */
@Entity
public class Text implements Serializable {
    public void analyze(AnalysisBuilder builder) throws InvalidTextInputException {
        String text = this.getContent();

        //custom exception
        if (!containsLetters(text)){
            throw new InvalidTextInputException("The input text can't be empty, only digits, whitespace and special chars, it needs to include letters.");
        }

        if (EntityManagerSingleton.getInstance() == null) {
            EntityManagerSingleton.setInstance(new EntityManagerSingleton());
        }
        EntityManagerSingleton factory = EntityManagerSingleton.getInstance();
        //assert factory != null;
        EntityManager entityManager = factory.getEntityManager();

        //persist text = self
        entityManager.persist(this);

        if (builder.isWordFrequency()){
            WordFrequencyAnalysisResult analysisResult = new WordFrequencyAnalysisResult();
            analysisResult.setDateCreatedTimestamp(1673259100);
            analysisResult.setText(this);
            entityManager.persist(analysisResult);
        }
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









    private boolean containsLetters(String string) {
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
    private String content;

    /**
     * @return the value of content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content new value of content
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    @OneToMany(mappedBy = "text")
    private List<ParagraphLengthAnalysisResult> paragraphLengthAnalysisResults;

    public List<ParagraphLengthAnalysisResult> getParagraphLengthAnalysisResults() {
        return paragraphLengthAnalysisResults;
    }

    public void setParagraphLengthAnalysisResults(List<ParagraphLengthAnalysisResult> paragraphLengthAnalysisResults) {
        this.paragraphLengthAnalysisResults = paragraphLengthAnalysisResults;
    }
    
    @OneToMany(mappedBy = "text")
    private List<SentenceLengthAnalysisResult> sentenceLengthAnalysisResults;

    public List<SentenceLengthAnalysisResult> getSentenceLengthAnalysisResults() {
        return sentenceLengthAnalysisResults;
    }

    public void setSentenceLengthAnalysisResults(List<SentenceLengthAnalysisResult> sentenceLengthAnalysisResults) {
        this.sentenceLengthAnalysisResults = sentenceLengthAnalysisResults;
    }
    
    @OneToMany(mappedBy = "text")
    private List<VocabularyDiversityAnalysisResult> vocabularyDiversityAnalysisResults;

    public List<VocabularyDiversityAnalysisResult> getVocabularyDiversityAnalysisResults() {
        return vocabularyDiversityAnalysisResults;
    }

    public void setVocabularyDiversityAnalysisResults(List<VocabularyDiversityAnalysisResult> vocabularyDiversityAnalysisResults) {
        this.vocabularyDiversityAnalysisResults = vocabularyDiversityAnalysisResults;
    }
    
    @OneToMany(mappedBy = "text")
    private List<WordFrequencyAnalysisResult> wordFrequencyAnalysisResults;

    public List<WordFrequencyAnalysisResult> getWordFrequencyAnalysisResults() {
        return wordFrequencyAnalysisResults;
    }

    public void setWordFrequencyAnalysisResults(List<WordFrequencyAnalysisResult> wordFrequencyAnalysisResults) {
        this.wordFrequencyAnalysisResults = wordFrequencyAnalysisResults;
    }
    @Override
    public String toString() {
        return "";
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
        if (!(object instanceof Text)) {
            return false;
        }
        Text other = (Text) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}