package com.cnu.devblog.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cnu.devblog.entity.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@WebMvcTest(PostControllerTest.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {


    /**
     * 웹 API 테스트할 때 사용 스프링 MVC 테스트의 시작점 HTTP GET,POST 등에 대해 API 테스트 가능
     */
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @DisplayName("")
    @Test
    void testGetPost() throws Exception {
        // given
        Post post = mapper.readValue("", Post.class);
        // when
        mvc.perform(MockMvcRequestBuilders.get("/posts"))
        // then
            .andExpect(status().isOk());
    }

    @DisplayName("")
    @Test
    void testPostPost() throws Exception {
        // given
        Post post = mapper.readValue("", Post.class);
        // when
        mvc.perform(MockMvcRequestBuilders.post("/posts"))
            // then
            .andExpect(status().isOk());
    }
}
