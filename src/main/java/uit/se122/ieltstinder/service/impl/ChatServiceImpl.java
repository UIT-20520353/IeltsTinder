package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uit.se122.ieltstinder.service.ChatService;
import uit.se122.ieltstinder.socket.dto.MessageRequest;
import uit.se122.ieltstinder.socket.dto.MessageResponse;
import uit.se122.ieltstinder.socket.enumeration.MessageType;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    @Override
    public MessageResponse sendMessage(MessageRequest request) {
//        return new MessageResponse(123L, 2L, MessageType.MESSAGE, request.getMessage(), Instant.now());
        return null;
    }

}
