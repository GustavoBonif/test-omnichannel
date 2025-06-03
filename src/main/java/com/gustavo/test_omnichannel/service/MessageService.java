package com.gustavo.test_omnichannel.service;

import java.util.List;

import com.gustavo.test_omnichannel.dto.MessageRequest;
import com.gustavo.test_omnichannel.dto.MessageResponse;

public interface MessageService {
    MessageResponse sendMessage(MessageRequest request);
    List<MessageResponse> getAllMessages();
    MessageResponse getMessageById(Long id);
}
