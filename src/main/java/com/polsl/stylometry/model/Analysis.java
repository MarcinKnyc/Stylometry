/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.model;

import java.util.ArrayList;

/**
 *
 * @author Student ETO-A 18
 */
public class Analysis {
    String text;
    ArrayList<String> results = new ArrayList<String>();
    public Analysis(AnalysisBuilder builder){
        text = builder.getText();
        if (builder.wordFrequency){
            results.add("wordFrequency normal");
        }
        if (builder.vocabularyDiversity){
            results.add("vocabularyDiversity normal");
        }
        if (builder.sentenceLength){
            results.add("sentenceLength normal");
        }
        if (builder.paragraphLength){
            results.add("paragraphLength normal");
        }
    }
    public ArrayList<String> GetResults(){
        return results;
    }
}
