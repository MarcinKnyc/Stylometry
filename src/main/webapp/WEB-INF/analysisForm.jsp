<%--version 0.1--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stylometry</title>
    <link rel="stylesheet" type="text/css" href="screen.css">
</head>
<body>
<div id="container">
    <div id="header">
        <p><b>Stylometry</b> - A Simple Web App for Stylometric text analysis</p>
    </div>
    <div id="content">
        <h1>Analyze text:</h1> <form  method="POST" action="">
        <input type="checkbox" name="shouldAnalyzeWordFrequency"  id="shouldAnalyzeWordFrequency"/>
        <label for="shouldAnalyzeWordFrequency">Check word frequency?</label><br>
        <input type="checkbox" name="shouldAnalyzeVocabularyDiversity"  id="shouldAnalyzeVocabularyDiversity"/>
        <label for="shouldAnalyzeVocabularyDiversity">Check vocabulary diversity?</label><br>
        <input type="checkbox" name="shouldAnalyzeSentenceLength" id="shouldAnalyzeSentenceLength"/>
        <label for="shouldAnalyzeSentenceLength">Check sentence length?</label><br>
        <input type="checkbox" name="shouldAnalyzeParagraphLength" id="shouldAnalyzeParagraphLength"/>
        <label for="shouldAnalyzeParagraphLength">Check paragraph length?</label><br>
        <textarea id="text" name="text" rows="4" cols="50"> This is an example sentence. In an example paragraph. Funny word: sesquipedalian. </textarea> <br>
        <input type="submit" value="analyze" />
        </form>
    </div>
    <div id="footer">
        <p>(C) 2023 Marcin Knyć, MIT Licence</p>
    </div>
</div>
</body>
</html>