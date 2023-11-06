package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uit.se122.ieltstinder.service.mapper.PostMapper;
import uit.se122.ieltstinder.repository.PostRepository;
import uit.se122.ieltstinder.service.PostService;
import uit.se122.ieltstinder.service.dto.PostDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(postMapper::toPostDto).toList();
    }

}
