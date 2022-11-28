package com.polsl.stylometry.view;

public class HelpView {
    public void DisplayHelp(){
        System.out.println("""
                Available command line arguments:
                --checkWordFrequency
                --checkVocabularyDiversity
                --checkSentenceLength
                --checkParagraphLength
                --text "This is an example sentence. In an example paragraph. Funny word: Sesquipedalian."
                Defaults: checks nothing.
                Throws exception if no text is provided.
                """);
    }
}
