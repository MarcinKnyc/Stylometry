package com.polsl.stylometry.controller;

import java.io.*;

import com.polsl.stylometry.entities.*;
import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.InvalidTextInputException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 *
 * @author Marcin Knyć
 * @version 0.2
 * Form to submit text for analysis
 * Different functions for POST and GET since making them the same didn't make sense to me.
 */
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            analyzeText(
                    request.getParameter("text"),
                    request.getParameter("shouldAnalyzeWordFrequency") != null,
                    request.getParameter("shouldAnalyzeVocabularyDiversity") != null,
                    request.getParameter("shouldAnalyzeSentenceLength") != null,
                    request.getParameter("shouldAnalyzeParagraphLength") != null
            );
        } catch (InvalidTextInputException e) {
            request.setAttribute("message", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/displayError.jsp").forward(request,response);
            response.sendRedirect("/WEB-INF/displayError.jsp");
        }

        response.sendRedirect("/StylometryServlets-1.0-SNAPSHOT/analysis-results");
    }

    private void analyzeText(
            String _text,
            boolean shouldAnalyzeWordFrequency,
            boolean shouldAnalyzeVocabularyDiversity,
            boolean shouldAnalyzeSentenceLength,
            boolean shouldAnalyzeParagraphLength
    ) throws InvalidTextInputException {
        AnalysisBuilder builder = new AnalysisBuilder(_text);

        if (shouldAnalyzeWordFrequency)
            builder.analyzeWordFrequency();
        if (shouldAnalyzeVocabularyDiversity)
            builder.analyzeVocabularyDiversity();
        if (shouldAnalyzeSentenceLength)
            builder.analyzeSentenceLength();
        if (shouldAnalyzeParagraphLength)
            builder.analyzeParagraphLength();

        Text text = new Text();
        text.setContent(_text);
        text.analyzeAndSave(builder);
    }

    public void destroy() {
    }
}