/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.main;

/**
 *
 * @version 0.1
 * @author Marcin Knyć
 * Available command line arguments:
 * --checkWordFrequency
 * --checkVocabularyDiversity
 * --checkSentenceLength
 * --checkParagraphLength
 * --text "This is an example sentence. In an example paragraph. Funny word: Sesquipedalian."
 * Defaults: checks nothing.
 * Throws exception if no text is provided.
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
//        boolean isHelp = false;
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
            //there is no help for you yet :(
//            if ("--help".equals(Args[i]))
//                isHelp = true;
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
