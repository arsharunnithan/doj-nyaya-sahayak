package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String questionEn;
    private String questionHi;
    private String questionMl;

    @Lob
    private String answerEn;
    @Lob
    private String answerHi;
    @Lob
    private String answerMl;

    private String relatedQuestionIds;

    public FAQ() {
    }

    public FAQ(String category, String questionEn, String questionHi, String questionMl,
                String answerEn, String answerHi, String answerMl, String relatedQuestionIds) {
        this.category = category;
        this.questionEn = questionEn;
        this.questionHi = questionHi;
        this.questionMl = questionMl;
        this.answerEn = answerEn;
        this.answerHi = answerHi;
        this.answerMl = answerMl;
        this.relatedQuestionIds = relatedQuestionIds;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getQuestionEn() { return questionEn; }
    public void setQuestionEn(String questionEn) { this.questionEn = questionEn; }

    public String getQuestionHi() { return questionHi; }
    public void setQuestionHi(String questionHi) { this.questionHi = questionHi; }

    public String getQuestionMl() { return questionMl; }
    public void setQuestionMl(String questionMl) { this.questionMl = questionMl; }

    public String getAnswerEn() { return answerEn; }
    public void setAnswerEn(String answerEn) { this.answerEn = answerEn; }

    public String getAnswerHi() { return answerHi; }
    public void setAnswerHi(String answerHi) { this.answerHi = answerHi; }

    public String getAnswerMl() { return answerMl; }
    public void setAnswerMl(String answerMl) { this.answerMl = answerMl; }

    public String getRelatedQuestionIds() { return relatedQuestionIds; }
    public void setRelatedQuestionIds(String relatedQuestionIds) { this.relatedQuestionIds = relatedQuestionIds; }

    public java.util.List<Long> getRelatedQuestionIdList() {
        java.util.List<Long> ids = new java.util.ArrayList<>();
        if (relatedQuestionIds != null && !relatedQuestionIds.isBlank()) {
            for (String part : relatedQuestionIds.split(",")) {
                ids.add(Long.parseLong(part.trim()));
            }
        }
        return ids;
    }
}