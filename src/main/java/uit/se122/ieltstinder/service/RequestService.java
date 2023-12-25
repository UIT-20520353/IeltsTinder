package uit.se122.ieltstinder.service;

import org.springframework.data.domain.Page;
import uit.se122.ieltstinder.service.dto.RequestDto;
import org.springframework.data.domain.Pageable;

public interface RequestService {

    void createRequest(Long userId, Long targetUserId);
    Page<RequestDto> getRequests(Long userId, Pageable pageable);
    void deleteRequest(Long requestId);
    void acceptRequest(Long requestId);
    void deleteRequestByUserId(Long sender, Long receiver);

}
