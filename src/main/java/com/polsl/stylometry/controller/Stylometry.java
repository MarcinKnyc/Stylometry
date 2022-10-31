/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.polsl.stylometry.controller;
import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.Analysis;


/**
 *
 * @author Student ETO-A 18
 */
public class Stylometry {

    public static void main(String[] args) {
        CommandLineArgumentsParser parser = new CommandLineArgumentsParser(args);
        ParsedCommandLineArguments arguments = parser.Parse();
        
        AnalysisBuilder builder = new AnalysisBuilder("This is an example sentence. In an example paragraph. Funny word: Sesquipedalian.");
        if (arguments.wordFrequency)
            builder.AnalyzeWordFrequency();
        if (arguments.vocabularyDiversity)
            builder.AnalyzeVocabularyDiversity();
        if (arguments.sentenceLength)
            builder.AnalyzeSentenceLength();
        if (arguments.paragraphLength)
            builder.AnalyzeParagraphLength();
        
        Analysis analysis = builder.Build();
        for (String result : analysis.GetResults()){
            System.out.println(result);
        }
    }
}
