package uit.se122.ieltstinder.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se122.ieltstinder.entity.Post;
import uit.se122.ieltstinder.service.dto.PostDto;

@Component
@RequiredArgsConstructor
public class PostMapper {

    private final UserMapper userMapper;

    public PostDto toPostDto(Post post) {
        return new PostDto(
                post.getId(),
                userMapper.toUserDto(post.getUser()),
                post.getContent(),
                post.getVideoUrl()
        );
    }

}
