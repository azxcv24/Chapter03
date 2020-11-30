package com.jvision.admin.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HellowControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void get리턴_검증태스트코드() throws Exception{
        String test = "get을 쓰는방법 getmapping 쓰기";

        mvc.perform(get("/get"))
                .andExpect(status().isOk())
                .andExpect(content().string(test));
    }
    @Test
    public void dto리턴_검증태스트코드() throws Exception{
        String name ="홍길동";
        int amount = 2000;
        String address ="vision";

        mvc.perform(get("/dto").param("name",name).param("amount", String.valueOf(amount)).param("address",address))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.namee", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)))
                .andExpect(jsonPath("$.address", is(address)));
    }
}
