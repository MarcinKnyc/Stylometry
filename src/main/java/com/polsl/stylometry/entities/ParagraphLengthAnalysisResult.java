/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polsl.stylometry.entities;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author Student
 */
@Entity
public class ParagraphLengthAnalysisResult implements Serializable {

    public float getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(float averageLength) {
        this.averageLength = averageLength;
    }

    private float averageLength;
    public ParagraphLengthAnalysisResult() {}
    public ParagraphLengthAnalysisResult(Text _text) {
        dateCreatedTimestamp = 1673259100;
        text = _text;
        analyzeSentenceLength();
    }
    public void analyzeSentenceLength() {
        String[] lines = text.getContent().split("\\r?\\n|\\r");
        int numberOfLines = lines.length;
        averageLength = (float)text.getContent().length() / (float)numberOfLines;
    }

















    @Override
    public String toString() {
        return "Average paragraph length: " + averageLength + " characters.";
    }
    //COMMON:

    @ManyToOne
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }    
    
    private int dateCreatedTimestamp;

    /**
     * @return the value of dateCreatedTimestamp
     */
    public int getDateCreatedTimestamp() {
        return dateCreatedTimestamp;
    }

    /**
     * @param dateCreatedTimestamp new value of dateCreatedTimestamp
     */
    public void setDateCreatedTimestamp(int dateCreatedTimestamp) {
        this.dateCreatedTimestamp = dateCreatedTimestamp;
    }


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParagraphLengthAnalysisResult)) {
            return false;
        }
        ParagraphLengthAnalysisResult other = (ParagraphLengthAnalysisResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
