package com.test.blog.service.impl;

import com.test.blog.dtos.PostDTO;
import com.test.blog.entity.Post;
import com.test.blog.repository.PostRepository;
import com.test.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createpost(PostDTO dto) {
        //convert DTO to Entity
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());

        Post newpost = postRepository.save(post);

        //convert Entity to DTO
        PostDTO postdto = new PostDTO();
        postdto.setId(newpost.getId());
        postdto.setTitle(newpost.getTitle());
        postdto.setDescription(newpost.getDescription());
        postdto.setContent(newpost.getContent());
        return postdto;
    }
}
