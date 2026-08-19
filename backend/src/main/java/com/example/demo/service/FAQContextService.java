package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FAQ;
import com.example.demo.repository.FAQRepository;

@Service
public class FAQContextService {

    @Autowired
    private FAQRepository faqRepository;

    public String buildContext(String language) {
        List<FAQ> faqs = faqRepository.findAll();
        StringBuilder context = new StringBuilder();

        for (FAQ faq : faqs) {
            String question = pickByLanguage(faq.getQuestionEn(), faq.getQuestionHi(), faq.getQuestionMl(), language);
            String answer = pickByLanguage(faq.getAnswerEn(), faq.getAnswerHi(), faq.getAnswerMl(), language);
            context.append("Q: ").append(question).append("\n");
            context.append("A: ").append(answer).append("\n\n");
        }

        return context.toString();
    }

    public FAQ findBestMatch(String question) {
        List<FAQ> faqs = faqRepository.findAll();
        String lowerQuestion = question.toLowerCase();

        FAQ bestMatch = null;
        int bestScore = 0;

        for (FAQ faq : faqs) {
            String[] keywords = faq.getCategory().toLowerCase().split(",");
            int score = 0;
            for (String keyword : keywords) {
                if (lowerQuestion.contains(keyword.trim())) {
                    score++;
                }
            }
            if (score > bestScore) {
                bestScore = score;
                bestMatch = faq;
            }
        }

        return bestMatch;
    }

    public List<String> resolveRelatedQuestions(FAQ faq, String language) {
        List<String> questions = new ArrayList<>();
        for (Long relatedId : faq.getRelatedQuestionIdList()) {
            faqRepository.findById(relatedId).ifPresent(related -> {
                String q = pickByLanguage(related.getQuestionEn(), related.getQuestionHi(), related.getQuestionMl(), language);
                questions.add(q);
            });
        }
        return questions;
    }

    public String pickByLanguage(String en, String hi, String ml, String language) {
        if ("hi".equals(language)) return hi;
        if ("ml".equals(language)) return ml;
        return en;
    }
}