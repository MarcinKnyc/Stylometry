package com.polsl.stylometry.view;

import com.polsl.stylometry.model.Analysis;

public class DisplayAnalysis {
    public String formatAnalysisResults(Analysis analysis){
        StringBuilder output = new StringBuilder();
        output.append("<h3>text:</h3>");
        output.append("<p>");
        output.append(analysis.getText());
        output.append("</p>");
        output.append("<h3>analysis results:</h3>");
        output.append("<ul>");

        for (String result : analysis.GetResults()){
            output.append("<li>").append(result).append("</li>");
        }
        output.append("</ul>");

        return output.toString();
    }
}
