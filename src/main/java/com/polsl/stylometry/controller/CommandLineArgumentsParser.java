/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.controller;

/**
 *
 * @author Student ETO-A 18
 */
public class CommandLineArgumentsParser {
    String[] Args;
    public CommandLineArgumentsParser(String[] Args){
        this.Args = Args;
    }
    public ParsedCommandLineArguments Parse(){
        boolean wordFrequency = false;
        boolean vocabularyDiversity = false;
        boolean sentenceLength = false;
        boolean paragraphLength = false;
        boolean isHelp = false;
        String text = "";
        if (Args == null){
            throw new IllegalArgumentException("Please specify --text argument (use \"\")");
        }
        for (int i = 0; i < Args.length; i++){
            if ("--checkWordFrequency".equals(Args[i]))
                wordFrequency=true;
            if ("--checkVocabularyDiversity".equals(Args[i]))
                vocabularyDiversity=true;
            if ("--checkSentenceLength".equals(Args[i]))
                sentenceLength=true;
            if ("--checkParagraphLength".equals(Args[i]))
                paragraphLength=true;
            if ("--help".equals(Args[i]))
                isHelp = true;
            if ("--text".equals(Args[i])){
                i++;
                text = Args[i];
            }
        }
        if ("".equals(text))
            throw new IllegalArgumentException("Please specify --text argument (use \"\")");
        return new ParsedCommandLineArguments(
                wordFrequency, 
                vocabularyDiversity, 
                sentenceLength,
                paragraphLength, 
                text);
    }
}
