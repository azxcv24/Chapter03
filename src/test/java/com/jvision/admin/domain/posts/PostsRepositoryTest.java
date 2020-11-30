package com.jvision.admin.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;


    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }


    @Test
    public void 개시글저장_불러오기(){
        String title ="테스트 게시글 타이틀값";
        String content = "dddd테스트글 본문 내용 값";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("azxcv24@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content); //테스트코드에서 위에 입력한 값이랑 코드를 수행하고 나온 값이 랑 같은 값인지 확인

    }

}

