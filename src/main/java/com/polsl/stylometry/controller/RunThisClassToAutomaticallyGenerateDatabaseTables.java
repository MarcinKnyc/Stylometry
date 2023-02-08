package com.polsl.stylometry.controller;

import com.polsl.stylometry.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RunThisClassToAutomaticallyGenerateDatabaseTables {
    public static void main(String[] args){
        //prototype code
        Text text = new Text();
        text.setContent("This is an example sentence. In an example paragraph. Funny word: Fifnaffaffen.");

        ParagraphLengthAnalysisResult paragraphLengthAnalysisResult = new ParagraphLengthAnalysisResult();
        paragraphLengthAnalysisResult.setDateCreatedTimestamp(1673259100);
        paragraphLengthAnalysisResult.setText(text);

        SentenceLengthAnalysisResult sentenceLengthAnalysisResult = new SentenceLengthAnalysisResult();
        sentenceLengthAnalysisResult.setDateCreatedTimestamp(1673259100);
        sentenceLengthAnalysisResult.setText(text);

        VocabularyDiversityAnalysisResult vocabularyDiversityAnalysisResult = new VocabularyDiversityAnalysisResult();
        vocabularyDiversityAnalysisResult.setDateCreatedTimestamp(1673259100);
        vocabularyDiversityAnalysisResult.setText(text);

        WordFrequencyAnalysisResult wordFrequencyAnalysisResult = new WordFrequencyAnalysisResult();
        wordFrequencyAnalysisResult.setDateCreatedTimestamp(1673259100);
        wordFrequencyAnalysisResult.setText(text);
//        PersonMapped person = new PersonMapped();
//        person.setAge(12);
//        person.setFirstName("Frankie");
//        person.setLastName("Frank");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.persist(person);
        entityManager.persist(text);
        entityManager.persist(paragraphLengthAnalysisResult);
        entityManager.persist(wordFrequencyAnalysisResult);
        entityManager.persist(vocabularyDiversityAnalysisResult);
        entityManager.persist(sentenceLengthAnalysisResult);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
//        String text = request.getParameter("text");
    }
}
