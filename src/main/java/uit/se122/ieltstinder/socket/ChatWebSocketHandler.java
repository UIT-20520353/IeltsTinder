package uit.se122.ieltstinder.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.handler.TextWebSocketHandler;;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(@Nonnull WebSocketSession session) throws Exception {
        log.info("id: {}", session.getId());
//        sessions.put(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(@Nonnull WebSocketSession session, TextMessage message) throws IOException {
        // Message format: "recipientId:message"
        String[] parts = message.getPayload().split(":", 2);
        if (parts.length == 2) {
            String recipientId = parts[0];
            String msg = parts[1];

            WebSocketSession recipientSession = sessions.get(recipientId);
            if (recipientSession != null && recipientSession.isOpen()) {
                recipientSession.sendMessage(new TextMessage(msg));
            }
        }
    }

    @Override
    public void afterConnectionClosed(@Nonnull WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
    }

}
