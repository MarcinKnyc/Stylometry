package com.polsl.stylometry.controller;

import com.polsl.stylometry.model.Analysis;
import com.polsl.stylometry.view.DisplayAnalysis;
import com.polsl.stylometry.view.Layout;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "displayAnalysisServlet", value = "/analysis-results")
public class DisplayAnalysisServlet extends HttpServlet {
    public void extractCookiesFromRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                switch (cookie.getName()) {
//                    case "affiliationVisits" -> request.setAttribute("affiliationVisits", cookie.getValue());
//                    case "pearsonCorrVisits" -> request.setAttribute("pearsonCorrVisits", cookie.getValue());
//                    case "strongestVisits" -> request.setAttribute("strongestVisits", cookie.getValue());
//                    default -> {
//                    }
//                }
//            }
//        }
//        request.getRequestDispatcher("/WEB-INF/CookiesPage.jsp").forward(request,response);
//        response.sendRedirect("/WEB-INF/CookiesPage.jsp");
    }

    private final Layout layout = new Layout();
    private final DisplayAnalysis displayAnalysis = new DisplayAnalysis();

    public void init() {

    }
    /**
     * Displays most recent analysis.
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //get Analysis HTML view
        Analysis analysis = Analysis.getInstance();
        String analysisHTML = "";
        if (analysis != null)
            analysisHTML = displayAnalysis.formatAnalysisResults(analysis);

        String header = "<h2>Here are your analysis results:</h2>";

        out.println(layout.header+analysisHTML+layout.footer);
    }
}
