package com.familyfirstsoftware.GTPBotBackend.controller;

import com.familyfirstsoftware.GTPBotBackend.model.response.GPTResponse;
import com.familyfirstsoftware.GTPBotBackend.model.request.ChatBotInputRequest;
import com.familyfirstsoftware.GTPBotBackend.service.GPTChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GPTController {
    private GPTChatService gPTChatService;

    public GPTController(GPTChatService gPTChatService) {
        this.gPTChatService = gPTChatService;
    }

    @PostMapping("/chat")
    public ResponseEntity<GPTResponse> processInputRequest(@RequestBody ChatBotInputRequest chatbotInputRequest) {
        GPTResponse chatCPTResponse = gPTChatService.getChatCPTResponse(chatbotInputRequest.getMessage());
        return new ResponseEntity<>(chatCPTResponse, HttpStatus.OK);
    }
}
