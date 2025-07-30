package com.example.demo.mapper;

import com.example.demo.dto.post.PostDTO;
import com.example.demo.dto.post.CreatePostDTO;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;

public class PostMapper {

    public static PostDTO toDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setUserId(post.getUser().getId());
        return dto;
    }

    public static Post toEntity(CreatePostDTO dto, User user) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setUser(user);
        return post;
    }
}
