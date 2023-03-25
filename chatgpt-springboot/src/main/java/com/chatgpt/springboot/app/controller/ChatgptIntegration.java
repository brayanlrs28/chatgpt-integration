package com.chatgpt.springboot.app.controller;

import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ChatgptIntegration {

    @Autowired
    private ChatgptService gptService;

    @PostMapping(value = "chatgpt",produces = MediaType.APPLICATION_JSON_VALUE)
    public String questionService(@RequestBody String question) {
        log.info("Question :: " + question);
        String value = gptService.sendMessage(question);
        log.info("Response : {} ", value);
        return value;
    }
}