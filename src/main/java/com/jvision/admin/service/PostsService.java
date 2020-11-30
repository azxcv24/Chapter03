package com.jvision.admin.service;

import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.jvision.admin.domain.posts.Posts;
import com.jvision.admin.domain.posts.PostsRepository;
import com.jvision.admin.web.dto.PostsListResponeseDto;
import com.jvision.admin.web.dto.PostsResponseDto;
import com.jvision.admin.web.dto.PostsSaveRequestDto;
import com.jvision.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long Update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("헤당 게시글이 없습니다 id = " + id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다 id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponeseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponeseDto::new).collect(Collectors.toList());

    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

    @Transactional
    public void deleteAll(){
        postsRepository.deleteAll();
    }


}
