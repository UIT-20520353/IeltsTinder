package uit.se122.ieltstinder.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uit.se122.ieltstinder.service.UserService;
import uit.se122.ieltstinder.service.criteria.UserCriteria;
import uit.se122.ieltstinder.service.dto.UserDto;
import uit.se122.ieltstinder.util.PaginationUtils;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/users")
@RequiredArgsConstructor
@Tag(name = "Admin User Resource")
public class UserAdminController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(UserCriteria criteria, @ParameterObject @PageableDefault Pageable pageable) {
        final Page<UserDto> page = userService.getAllUsers(criteria, pageable);
        final HttpHeaders headers = PaginationUtils
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}
