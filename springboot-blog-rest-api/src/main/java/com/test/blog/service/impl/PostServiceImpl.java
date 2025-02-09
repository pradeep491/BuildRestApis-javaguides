package com.test.blog.service.impl;

import com.test.blog.dtos.PostDTO;
import com.test.blog.entity.Post;
import com.test.blog.repository.PostRepository;
import com.test.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createpost(PostDTO dto) {
        Post post = mapToEntity(dto);
        Post newpost = postRepository.save(post);
        return mapToDto(newpost);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<PostDTO> listDto = new ArrayList<>();
        List<Post> list = postRepository.findAll();

       /* for (Post p : list) {
            PostDTO dto = mapToDto(p);
            listDto.add(dto);
        }*/
        listDto =  list.stream().map(post->mapToDto(post)).toList();
        return listDto;
    }
    //convert Entity to DTO
    private PostDTO mapToDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        return dto;
    }
    //convert DTO to Entity
    private Post mapToEntity(PostDTO dto){
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());
        return post;
    }
}
