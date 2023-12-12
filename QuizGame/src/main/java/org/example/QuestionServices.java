package org.example;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class QuestionServices {

    private static final String API_BASE_URL = "https://opentdb.com/api.php?amount=10";
//    private static final String API_BASE_URL = "https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple";
    private final RestTemplate restTemplate = new RestTemplate();

    public SimpleQuestion[] getAll(int category, String difficulty) throws Exception {
        SimpleQuestion[] questions = null;
        try {
            questions = restTemplate.getForObject(API_BASE_URL, SimpleQuestion[].class);
//            questions = restTemplate.getForObject(API_BASE_URL + "&category=" + category + "&difficulty=" + difficulty + "&type=multiple", Question[].class);
        } catch (RestClientResponseException e) {
            throw new Exception (e.getRawStatusCode() + " : " + e.getStatusText());
        }
        catch (ResourceAccessException e) {
            throw new Exception (e.getMessage());
        }
        return questions;
    }

}