package com.scbsena.demo.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinancialAdvisoryService {

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.key}")
    private String apiKey;

    public String getFinancialAdvice(String query) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        String requestBody = "{\n" +
                "  \"model\": \"text-davinci-003\",\n" +
                "  \"prompt\": \"" + query + "\",\n" +
                "  \"max_tokens\": 150\n" +
                "}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        String advice = response.getBody();
        return extractAdviceFromResponse(advice);
    }

    private String extractAdviceFromResponse(String response) {
        int startIndex = response.indexOf("\"text\":\"") + 8;
        int endIndex = response.indexOf("\"", startIndex);
        return response.substring(startIndex, endIndex).trim();
    }
}