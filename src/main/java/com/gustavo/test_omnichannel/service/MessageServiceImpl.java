package com.gustavo.test_omnichannel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gustavo.test_omnichannel.dto.MessageRequest;
import com.gustavo.test_omnichannel.dto.MessageResponse;
import com.gustavo.test_omnichannel.model.Message;
import com.gustavo.test_omnichannel.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    @Override
    public MessageResponse sendMessage(MessageRequest request) {
        Message message = Message.builder()
            .recipient(request.getRecipient())
            .channels(request.getChannels())
            .content(request.getContent())
            .status("SENT") // Assuming a default status
            .build();

        Message saved = repository.save(message);
        return mapToResponse(saved);
    }

    @Override
    public List<MessageResponse> getAllMessages() {
        return repository.findAll()
            .stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
    }

    @Override
    public MessageResponse getMessageById(Long id) {
        return repository.findById(id)
            .map(this::mapToResponse)
            .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
    }

    private MessageResponse mapToResponse(Message message) {
        return MessageResponse.builder()
            .id(message.getId())
            .recipient(message.getRecipient())
            .channels(message.getChannels())
            .content(message.getContent())
            .status(message.getStatus())
            .build();
    }
}
