package com.polsl.stylometry.controller;

import java.io.*;

import com.polsl.stylometry.model.Analysis;
import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.InvalidTextInputException;
import com.polsl.stylometry.view.DisplayAnalysis;
import com.polsl.stylometry.view.Layout;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AnalysisServlet", value = "/analyze-text")
public class AnalysisServlet extends HttpServlet {
    //source: https://turngeek.github.io/javaeeinaday/chapter/3-the-rise-of-server-side-java-java-servlets/
    private final String form = "<div id=\"content\">"
                    + "<h1>Analyze text:</h1>" + "<form  method=\"POST\" action=\"\">"
                    + "<input type=\"checkbox\" name=\"shouldAnalyzeWordFrequency\" />"
                    + "<label for=\"shouldAnalyzeWordFrequency\">Check word frequency?</label><br>"
                    + "<input type=\"checkbox\" name=\"shouldAnalyzeVocabularyDiversity\" />"
                    + "<label for=\"shouldAnalyzeVocabularyDiversity\">Check vocabulary diversity?</label><br>"
                    + "<input type=\"checkbox\" name=\"shouldAnalyzeSentenceLength\" />"
                    + "<label for=\"shouldAnalyzeSentenceLength\">Check sentence length?</label><br>"
                    + "<input type=\"checkbox\" name=\"shouldAnalyzeParagraphLength\" />"
                    + "<label for=\"shouldAnalyzeParagraphLength\">Check paragraph length?</label><br>"
                    //+ "<input type=\"textarea\" name=\"text\" placeholder=\"This is an example sentence. In an example paragraph. Funny word: sesquipedalian.\" />"
                    + "<textarea id=\"text\" name=\"text\" rows=\"4\" cols=\"50\"> This is an example sentence. In an example paragraph. Funny word: sesquipedalian. </textarea> <br>"
                    + "<input type=\"submit\" value=\"analyze\" />"
                    + "</form>" + "</div>";

    private final Layout layout = new Layout();
    private final DisplayAnalysis displayAnalysis = new DisplayAnalysis();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(layout.header+form+layout.footer);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = request.getParameter("text");
//        String httpResponse = layout.header;
        analyzeText(
                text,
                request.getParameter("shouldAnalyzeWordFrequency") != null,
                request.getParameter("shouldAnalyzeVocabularyDiversity") != null,
                request.getParameter("shouldAnalyzeSentenceLength") != null,
                request.getParameter("shouldAnalyzeParagraphLength") != null
        );
//        httpResponse += layout.footer;

        response.sendRedirect("/StylometryServlets-1.0-SNAPSHOT/analysis-results");
    }

    private String analyzeText(
            String text,
            boolean shouldAnalyzeWordFrequency,
            boolean shouldAnalyzeVocabularyDiversity,
            boolean shouldAnalyzeSentenceLength,
            boolean shouldAnalyzeParagraphLength
    ){
        AnalysisBuilder builder = new AnalysisBuilder(text);

        if (shouldAnalyzeWordFrequency)
            builder.AnalyzeWordFrequency();
        if (shouldAnalyzeVocabularyDiversity)
            builder.AnalyzeVocabularyDiversity();
        if (shouldAnalyzeSentenceLength)
            builder.AnalyzeSentenceLength();
        if (shouldAnalyzeParagraphLength)
            builder.AnalyzeParagraphLength();

        try {
            //create model
            Analysis analysis = builder.Build();
            Analysis.setInstance(analysis);

            //display results
            return displayAnalysis.formatAnalysisResults(analysis);
        } catch (InvalidTextInputException exception){
            //display error
            return "<h1>An error occured: " + exception.getMessage() + "</h1>";
        }
    }

    public void destroy() {
    }
}