package uit.se122.ieltstinder.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.service.UserService;
import uit.se122.ieltstinder.service.dto.UserDto;

import java.util.List;

@RequestMapping(value = "/api/users")
@RestController
@RequiredArgsConstructor
@Tag(name = "Users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userService.findUserById(userId));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.noContent().build();
    }

}
