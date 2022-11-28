/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.model;

/**
 *
 * @author Marcin Knyć
 * @version 0.1
 */
public class AnalysisBuilder {
    boolean wordFrequency = false, vocabularyDiversity = false, 
            sentenceLength = false, paragraphLength = false;
    String text;
    
    public AnalysisBuilder(String _text){
        text = _text;
    }
    public AnalysisBuilder AnalyzeWordFrequency(){
        wordFrequency = true;
        return this;
    }
    public AnalysisBuilder AnalyzeVocabularyDiversity(){
        vocabularyDiversity = true;
        return this;
    }
    public AnalysisBuilder AnalyzeSentenceLength(){
        sentenceLength = true;
        return this;
    }
    public AnalysisBuilder AnalyzeParagraphLength(){
        paragraphLength = true;
        return this;
    }
    public Analysis Build() throws InvalidTextInputException {
        return new Analysis(this);
    }
    
    public boolean isWordFrequency() {
        return wordFrequency;
    }

    public boolean isVocabularyDiversity() {
        return vocabularyDiversity;
    }

    public boolean isSentenceLength() {
        return sentenceLength;
    }

    public boolean isParagraphLength() {
        return paragraphLength;
    }

    public String getText() {
        return text;
    }
}
