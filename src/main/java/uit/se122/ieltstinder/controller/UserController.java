package uit.se122.ieltstinder.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.service.UserService;
import uit.se122.ieltstinder.service.criteria.UserCriteria;
import uit.se122.ieltstinder.service.dto.UserDto;
import uit.se122.ieltstinder.util.PaginationUtils;

import java.util.List;

@RequestMapping(value = "/api/users")
@RestController
@RequiredArgsConstructor
@Tag(name = "User Resources")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(UserCriteria criteria, @ParameterObject @PageableDefault Pageable pageable) {
        final Page<UserDto> page = userService.getAllUsers(criteria, pageable);
        final HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userService.findUserById(userId));
    }

}
