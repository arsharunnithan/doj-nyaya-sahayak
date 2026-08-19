package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ChatResponse;
import com.example.demo.entity.FAQ;

@Service
public class FallbackMatchService {

    @Autowired
    private FAQContextService faqContextService;

    public ChatResponse getFallbackAnswer(String userQuestion, String language) {
        FAQ bestMatch = faqContextService.findBestMatch(userQuestion);

        ChatResponse response = new ChatResponse();
        response.setSource("fallback");

        if (bestMatch != null) {
            String answer = faqContextService.pickByLanguage(
                    bestMatch.getAnswerEn(), bestMatch.getAnswerHi(), bestMatch.getAnswerMl(), language);
            response.setAnswer(answer);
            response.setRelatedQuestions(faqContextService.resolveRelatedQuestions(bestMatch, language));
        } else {
            String noMatchMsg;
            if ("hi".equals(language)) {
                noMatchMsg = "मुझे सटीक उत्तर नहीं मिला। कृपया अधिक जानकारी के लिए doj.gov.in पर जाएं।";
            } else if ("ml".equals(language)) {
                noMatchMsg = "കൃത്യമായ ഉത്തരം കണ്ടെത്താനായില്ല. കൂടുതൽ വിവരങ്ങൾക്ക് doj.gov.in സന്ദർശിക്കുക.";
            } else {
                noMatchMsg = "I couldn't find an exact answer. Please visit doj.gov.in for more information.";
            }
            response.setAnswer(noMatchMsg);
        }

        return response;
    }
}