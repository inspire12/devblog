package com.cnu.devblog.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class PostControllerRestDocsTest {

    MockMvc mockMvc;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider provider) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply(documentationConfiguration(provider).snippets())
            .alwaysDo(print())
            .build();
    }

    protected OperationResponsePreprocessor getResponsePreprocessor() {
        //응답에 대한 json 문장을 예쁘게 줄맞춰 준다.
        return preprocessResponse(prettyPrint());
    }

    protected OperationRequestPreprocessor getRequestPreprocessor() {
        //요청에 대한 json 문장을 예쁘게 줄맞춰 준다.
        return preprocessRequest(prettyPrint());
    }



    @Test
    void createPost() {
    }

    @Test
    void getPost() {
    }

    @Test
    void getPosts() {
    }

    @Test
    void testGetPosts() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }
}