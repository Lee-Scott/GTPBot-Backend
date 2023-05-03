package com.familyfirstsoftware.GTPBotBackend.service;

import com.familyfirstsoftware.GTPBotBackend.model.request.GPTRequest;
import com.familyfirstsoftware.GTPBotBackend.model.response.GPTResponse;
import com.familyfirstsoftware.GTPBotBackend.model.common.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
    This service class uses the OpenAI Chat/Completions API endpoint to get a response to a prompt.
    It takes a prompt string as input and returns an object that represents the response from the
    API endpoint.

    The “getChatGPTResponse” method constructs the request body using the model, prompt, and maxTokens
    parameters. It then sends a POST request to the OpenAI Chat/Completions API endpoint with the request
    body and the API key in the Authorization header. Finally, it retrieves the response body as a
    ChatGPTResponse object.

    For ChatGPT request and response, we have created a few model/POJO classes for sending a request in a
    format that is required for Chat/Completions API Endpoint and also, for mapping response into Java
    objects from ChatGPT API.

 */
@Service
public class GPTChatService {

    @Value("${openai.api.key}")
    private String apiKey;

    private static final String OPEN_AI_CHAT_ENDPOINT = "https://api.openai.com/v1/chat/completions";

    private RestTemplate restTemplate;

    public GPTChatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GPTResponse getChatCPTResponse(String prompt) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        GPTRequest chatGPTRequest = new GPTRequest();
        chatGPTRequest.setModel("gpt-3.5-turbo"); // Most capable GPT-3.5 model and optimized for chat.
        chatGPTRequest.setMessages(List.of(new Message("user", prompt))); // Input prompt for ChatGPT
        chatGPTRequest.setMax_tokens(2000); // The maximum number of tokens to generate in the chat completion.

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<GPTRequest> request = new HttpEntity<>(chatGPTRequest, headers);

        return restTemplate.postForObject(OPEN_AI_CHAT_ENDPOINT, request, GPTResponse.class);
    }
}
