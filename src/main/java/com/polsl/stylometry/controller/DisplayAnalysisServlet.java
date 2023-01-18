package com.polsl.stylometry.controller;

import com.polsl.stylometry.model.Analysis;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "displayAnalysisServlet", value = "/analysis-results")
public class DisplayAnalysisServlet extends HttpServlet {
    /**
     * serves no purpose now, added for extensibility
     * */
    public ArrayList<String> getCookieNames(HttpServletRequest request) {
        ArrayList<String> cookieNames = new ArrayList<String>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "shouldAnalyzeWordFrequency":
                    case "shouldAnalyzeVocabularyDiversity":
                    case "shouldAnalyzeSentenceLength":
                    case "shouldAnalyzeParagraphLength":
                        cookieNames.add(cookie.getName());
                        break;
                }
            }
        }
        return cookieNames;
    }


    public void init() {

    }
    /**
     * Displays most recent analysis.
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        Analysis analysis = Analysis.getInstance();
        request.setAttribute("text", analysis.getText());
        request.setAttribute("results", analysis.getResults());
        request.getRequestDispatcher("/WEB-INF/displayAnalysis.jsp").forward(request,response);
        response.sendRedirect("/WEB-INF/displayAnalysis.jsp");
//        PrintWriter out = response.getWriter();

        //get Analysis HTML view
//        Analysis analysis = Analysis.getInstance();
//        ArrayList<String> cookieNames = getCookieNames(request);
//        String analysisHTML = "";
//        if (analysis != null)
//            analysisHTML = displayAnalysis.formatAnalysisResults(analysis);
//
//        String header = "<h2>Here are your analysis results:</h2>";

        //out.println(layout.header+analysisHTML+layout.footer);
    }
}
