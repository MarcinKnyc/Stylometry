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
        builder = new AnalysisBuilder("Not not a a real real sentence.");
    }
    
    @Test
    public void testWordFrequencyAnalysis() {
        builder.AnalyzeWordFrequency();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.getResults(), hasItem("Most common words: real, not, a"));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }
    }
    @Test
    public void testVocabularyDiversityAnalysis() {
        builder.AnalyzeVocabularyDiversity();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.getResults(), hasItem("Vocabulary diversity was graded as Amazing"));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }    
    }
    @Test
    public void testSentenceLengthAnalysis() {
        builder.AnalyzeSentenceLength();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.getResults(), hasItem("Average sentence length: 31.0 characters."));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }    
    }
    @Test
    public void testParagraphLengthAnalysis() {
        builder.AnalyzeParagraphLength();
        try {
            Analysis analysis = builder.Build();
            assertThat(analysis.getResults(), hasItem("Average paragraph length: 31.0 characters."));
        } catch (InvalidTextInputException e) {
            fail("An exception occured.");
        }    
    }
    
}
