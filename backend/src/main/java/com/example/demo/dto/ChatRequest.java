package com.example.demo.dto;

public class ChatRequest {

    private String question;
    private String language; // "en" or "hi"

    public ChatRequest() {
    }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}