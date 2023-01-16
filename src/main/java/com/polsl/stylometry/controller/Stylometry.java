/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.polsl.stylometry.controller;
import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.Analysis;
import com.polsl.stylometry.model.InvalidTextInputException;
import com.polsl.stylometry.view.AnalysisView;
import com.polsl.stylometry.view.ErrorView;
import com.polsl.stylometry.view.HelpView;

/**
 *
 * @version 0.1
 * @author Marcin Knyć
 * The view and model classes are instantiated in the code and not as fields, because the controller is stateless for now.
 * A stateless controller will be easier to update and maintain.
 */
public class Stylometry {
//    public void PerformStylometricAnalysis(
//            String text,
//            boolean shouldAnalyzeWordFrequency,
//            boolean shouldAnalyzeVocabularyDiversity,
//            boolean shouldAnalyzeSentenceLength,
//            boolean shouldAnalyzeParagraphLength
//    ) {
//        AnalysisBuilder builder = new AnalysisBuilder(text);
//
//        if (shouldAnalyzeWordFrequency)
//            builder.AnalyzeWordFrequency();
//        if (shouldAnalyzeVocabularyDiversity)
//            builder.AnalyzeVocabularyDiversity();
//        if (shouldAnalyzeSentenceLength)
//            builder.AnalyzeSentenceLength();
//        if (shouldAnalyzeParagraphLength)
//            builder.AnalyzeParagraphLength();
//
//
//        try {
//            //create model
//            Analysis analysis = builder.Build();
//            //display results
//            AnalysisView analysisView = new AnalysisView();
//            analysisView.ViewAnalysis(analysis);
//        } catch (InvalidTextInputException exception){
//            //display error
//            ErrorView errorView = new ErrorView();
//            errorView.DisplayError(exception.getMessage());
//        }
//    }
//
//    public void DisplayHelp(){
//        HelpView helpView = new HelpView();
//        helpView.DisplayHelp();
//    }
}
