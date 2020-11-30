package com.jvision.admin.web.dto;


import com.jvision.admin.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsListResponeseDto {

    private Long id;
    private String title;
    private String author;

    public PostsListResponeseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
    }
}
