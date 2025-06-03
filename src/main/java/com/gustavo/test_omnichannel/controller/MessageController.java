package com.gustavo.test_omnichannel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.test_omnichannel.dto.MessageRequest;
import com.gustavo.test_omnichannel.dto.MessageResponse;
import com.gustavo.test_omnichannel.service.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    
    private final MessageService service;

    @PostMapping
    public ResponseEntity<MessageResponse> send(@RequestBody MessageRequest request) {
        return ResponseEntity.ok(service.sendMessage(request));
    }

    @GetMapping
    public ResponseEntity<List<MessageResponse>> getAll() {
        return ResponseEntity.ok(service.getAllMessages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getMessageById(id));
    }
}
