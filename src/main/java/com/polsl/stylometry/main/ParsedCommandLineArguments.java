/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.main;

/**
 *
 * @author Marcin Knyć
 * @version 0.1
 */
public class ParsedCommandLineArguments {
    boolean wordFrequency, vocabularyDiversity, 
            sentenceLength, paragraphLength;
    String text;
    
    public ParsedCommandLineArguments(
            boolean wordFrequency, 
            boolean vocabularyDiversity,
            boolean sentenceLength,
            boolean paragraphLength,
            String text
    ) {
        this.wordFrequency = wordFrequency;
        this.vocabularyDiversity = vocabularyDiversity;
        this.sentenceLength = sentenceLength;
        this.paragraphLength = paragraphLength;
        this.text = text;
    }
}
