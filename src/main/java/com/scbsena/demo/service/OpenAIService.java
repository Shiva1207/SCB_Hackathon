package com.scbsena.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OpenAIService {

    private final OpenAIConfig openAIConfig;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public OpenAIService(OpenAIConfig openAIConfig, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.openAIConfig = openAIConfig;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public String search(String query) throws Exception {
        String apiKey = openAIConfig.getApiKey();
        String endpoint = "https://api.openai.com/v1/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);

        // Create the JSON payload as a Java object
        OpenAIRequestPayload payload = new OpenAIRequestPayload("gpt-4o-mini", query, 100);

        // Convert the payload to a JSON string
        String jsonPayload = objectMapper.writeValueAsString(payload);

        HttpEntity<String> request = new HttpEntity<>(jsonPayload, headers);
        ResponseEntity<String> response = restTemplate.exchange(endpoint, HttpMethod.POST, request, String.class);

        return response.getBody();
    }

    // Inner class for the request payload
    static class OpenAIRequestPayload {
        private String model;
        private String prompt;
        private int max_tokens;

        public OpenAIRequestPayload(String model, String prompt, int max_tokens) {
            this.model = model;
            this.prompt = prompt;
            this.max_tokens = max_tokens;
        }

        public String getModel() {
            return model;
        }

        public String getPrompt() {
            return prompt;
        }

        public int getMaxTokens() {
            return max_tokens;
        }
    }
}