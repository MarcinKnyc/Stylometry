package com.polsl.stylometry.controller;

import java.io.*;

import com.polsl.stylometry.model.Analysis;
import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.InvalidTextInputException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AnalysisServlet", value = "/analyze-text")
public class AnalysisServlet extends HttpServlet {
    //source: https://turngeek.github.io/javaeeinaday/chapter/3-the-rise-of-server-side-java-java-servlets/
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.getRequestDispatcher("/WEB-INF/analysisForm.jsp").forward(request,response);
        response.sendRedirect("/WEB-INF/analysisForm.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String text = request.getParameter("text");
        analyzeText(
                text,
                request.getParameter("shouldAnalyzeWordFrequency") != null,
                request.getParameter("shouldAnalyzeVocabularyDiversity") != null,
                request.getParameter("shouldAnalyzeSentenceLength") != null,
                request.getParameter("shouldAnalyzeParagraphLength") != null
        );

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

            return "";
            //display results
            //return displayAnalysis.formatAnalysisResults(analysis);
        } catch (InvalidTextInputException exception){
            //display error
            return "<h1>An error occured: " + exception.getMessage() + "</h1>";
        }
    }

    public void destroy() {
    }
}