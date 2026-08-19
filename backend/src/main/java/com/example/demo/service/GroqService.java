package com.example.demo.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GroqService {

    private static final String GROQ_URL = "https://api.groq.com/openai/v1/chat/completions";

    @Value("${groq.api.key}")
    private String apiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getAIAnswer(String context, String userQuestion, String language) throws Exception {
        String langInstruction;
        if ("hi".equals(language)) {
            langInstruction = "Respond in Hindi.";
        } else if ("ml".equals(language)) {
            langInstruction = "Respond in Malayalam.";
        } else {
            langInstruction = "Respond in English.";
        }

        String systemPrompt = "You are DoJ Nyaya Sahayak, an assistant for India's Department of Justice. "
                + "Answer ONLY using the information below. If the question is unclear or could match multiple "
                + "topics, ask a short clarifying question instead of guessing. If the question is unrelated to "
                + "the information below, say you don't have that information and suggest visiting doj.gov.in. "
                + langInstruction + "\n\n" + context;

        String jsonBody = """
                {
                  "model": "openai/gpt-oss-20b",
                  "messages": [
                    {"role": "system", "content": %s},
                    {"role": "user", "content": %s}
                  ]
                }
                """.formatted(toJsonString(systemPrompt), toJsonString(userQuestion));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GROQ_URL))
                .timeout(Duration.ofSeconds(3))
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Groq API returned status " + response.statusCode() + ": " + response.body());
        }

        return extractAnswerFromJson(response.body());
    }

    private String toJsonString(String text) {
        return "\"" + text.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n") + "\"";
    }

    private String extractAnswerFromJson(String json) throws Exception {
        JsonNode root = objectMapper.readTree(json);
        return root.path("choices").get(0).path("message").path("content").asText();
    }
}