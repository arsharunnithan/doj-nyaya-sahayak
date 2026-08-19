package com.example.demo.dto;

import java.util.List;

public class ChatResponse {

    private String answer;
    private List<String> relatedQuestions;
    private String source; // "ai" or "fallback"

    public ChatResponse() {
    }

    public ChatResponse(String answer, List<String> relatedQuestions, String source) {
        this.answer = answer;
        this.relatedQuestions = relatedQuestions;
        this.source = source;
    }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }

    public List<String> getRelatedQuestions() { return relatedQuestions; }
    public void setRelatedQuestions(List<String> relatedQuestions) { this.relatedQuestions = relatedQuestions; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
}