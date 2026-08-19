package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChatRequest;
import com.example.demo.dto.ChatResponse;
import com.example.demo.entity.FAQ;
import com.example.demo.service.FAQContextService;
import com.example.demo.service.FallbackMatchService;
import com.example.demo.service.GroqService;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private FAQContextService contextService;

    @Autowired
    private GroqService groqService;

    @Autowired
    private FallbackMatchService fallbackService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String language = request.getLanguage() != null ? request.getLanguage() : "en";

        try {
            String context = contextService.buildContext(language);
            String aiAnswer = groqService.getAIAnswer(context, request.getQuestion(), language);

            ChatResponse response = new ChatResponse();
            response.setAnswer(aiAnswer);
            response.setSource("ai");

            FAQ relatedFaq = contextService.findBestMatch(request.getQuestion());
            if (relatedFaq != null) {
                response.setRelatedQuestions(contextService.resolveRelatedQuestions(relatedFaq, language));
            }

            return response;

        } catch (Exception e) {
            e.printStackTrace(); // TEMP — remove before demo
            return fallbackService.getFallbackAnswer(request.getQuestion(), language);
        }
    }
}