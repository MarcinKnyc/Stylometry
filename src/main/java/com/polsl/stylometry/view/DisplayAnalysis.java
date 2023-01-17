package com.polsl.stylometry.view;

import com.polsl.stylometry.model.Analysis;

public class DisplayAnalysis {
    public String formatAnalysisResults(Analysis analysis){
        StringBuilder output = new StringBuilder();
        output.append("<ul>");

        for (String result : analysis.GetResults()){
            output.append("<li>").append(result).append("</li>");
        }
        output.append("</ul>");

        return output.toString();
    }
}
