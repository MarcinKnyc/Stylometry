/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertThat;
//import static org.junit.matchers.JUnitMatchers.*;

/**
 *
 * @author Student ETO-A 18
 */
public class AnalysisTest {
    private AnalysisBuilder builder;

    @BeforeEach
    public void setUp() {
        builder = new AnalysisBuilder("Not a real sentence.");
    }
    
    @Test
    public void testWordFrequencyAnalysis() {
        builder.AnalyzeWordFrequency();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.GetResults(), hasItem("wordFrequency normal"));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }
    }
    @Test
    public void testVocabularyDiversityAnalysis() {
        builder.AnalyzeVocabularyDiversity();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.GetResults(), hasItem("vocabularyDiversity normal"));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }    
    }
    @Test
    public void testSentenceLengthAnalysis() {
        builder.AnalyzeSentenceLength();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.GetResults(), hasItem("sentenceLength normal"));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }    
    }
    @Test
    public void testParagraphLengthAnalysis() {
        builder.AnalyzeParagraphLength();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.GetResults(), hasItem("paragraphLength normal"));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }    
    }
    
}
