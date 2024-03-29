package com.polsl.stylometry.controller;

import com.polsl.stylometry.entities.Text;
import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.EntityManagerSingleton;
import com.polsl.stylometry.model.InvalidTextInputException;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcin Knyć
 * @version 0.1
 * Site to display analysis results.
 * Different functions for POST and GET since making them the same didn't make sense to me.
 */
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

        List<Text> texts = getTexts();

        request.setAttribute("results", texts);
        request.getRequestDispatcher("/WEB-INF/displayAnalysis.jsp").forward(request,response);
        response.sendRedirect("/WEB-INF/displayAnalysis.jsp");
    }

    private List<Text> getTexts(){
        if (EntityManagerSingleton.getInstance() == null) {
            EntityManagerSingleton.setInstance(new EntityManagerSingleton());
        }
        EntityManagerSingleton factory = EntityManagerSingleton.getInstance();
        //assert factory != null;
        EntityManager entityManager = factory.getEntityManager();

        List<Text> results = entityManager.createQuery("SELECT t FROM Text t")
                .getResultList();
        return results;
    }
}
