package uit.se122.ieltstinder.socket.dto;

import uit.se122.ieltstinder.socket.enumeration.MessageType;

import java.time.Instant;

public record MessageResponse (
        Long id,
        Long userId,
        MessageType type,
        String message,
        Instant date
) {
}
