package uit.se122.ieltstinder.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uit.se122.ieltstinder.service.ChatService;
import uit.se122.ieltstinder.socket.dto.MessageRequest;
import uit.se122.ieltstinder.socket.dto.MessageResponse;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Chat Resource")
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public MessageResponse receiveMessage(@Payload MessageRequest request) {
        return chatService.sendMessage(request);
    }

}
