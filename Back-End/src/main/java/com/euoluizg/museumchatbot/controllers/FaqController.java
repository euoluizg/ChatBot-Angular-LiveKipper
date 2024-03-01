package com.euoluizg.museumchatbot.controllers;


import com.euoluizg.museumchatbot.dto.MessageResponse;
import com.euoluizg.museumchatbot.services.FaqService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.euoluizg.museumchatbot.dto.MessageRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/chat")
public class FaqController {
    final private FaqService faqService;

    public FaqController(FaqService faqService){
        this.faqService = faqService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> answerQuestion(@RequestBody MessageRequest request) {
        String answer = this.faqService.getAnswer(request.message());
        MessageResponse response = new MessageResponse(answer);
        return ResponseEntity.ok(response);
    }

}
