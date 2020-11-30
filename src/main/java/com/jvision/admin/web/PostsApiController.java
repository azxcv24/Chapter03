package com.jvision.admin.web;



import com.jvision.admin.service.PostsService;
import com.jvision.admin.web.dto.PostsResponseDto;
import com.jvision.admin.web.dto.PostsSaveRequestDto;
import com.jvision.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")  //저장
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") //수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.Update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") //조회
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}") //삭제
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @DeleteMapping("/api/v1/posts/all") //전부 삭제
    public void deleteAll(){
        postsService.deleteAll();

    }



}
