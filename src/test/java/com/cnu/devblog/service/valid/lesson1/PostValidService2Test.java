package com.cnu.devblog.service.valid.lesson1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.cnu.devblog.entity.Slang;
import com.cnu.devblog.repository.slang.SlangRepository;
import com.cnu.devblog.service.valid.PostValidService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PostValidService2Test {
    PostValidService postValidService;

    SlangRepository slangRepository;

    @BeforeEach
    void setUp() {
        slangRepository = mock(SlangRepository.class);
        postValidService = new PostValidService(slangRepository);
    }

    @DisplayName("post 내용에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeMockSlang() {
        // given 시나리오
        String testInput = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");
        List<Slang> slangEntities = new ArrayList<>();

        for (String slangText: slangList) {
            slangEntities.add(new Slang(slangText));
        }
        // when 에서 실행될 과정에서 나올 데이터를 mocking 해준다
        when(slangRepository.findAll()).thenReturn(slangEntities);
        // when 실행

        boolean validPost = postValidService.isValidPost(slangList, testInput);
        // then 검증
        assertThat(validPost).isEqualTo(true);
    }

    @DisplayName("post 내용에 비속어가 있나 테스트")
    @Test
    void testValidPostIncludeSlang() {
        // given 시나리오
        String testInput = "비속어가 섞인 욕";
        when(postValidService.getSlangList()).thenReturn(List.of("비속어", "비속어1", "비속어2"));
        List<String> slangList = postValidService.getSlangList();
        // when 실행
        boolean validPost = postValidService.isValidPost(slangList, testInput);
        // then 검증
        assertThat(validPost).isEqualTo(true);
    }
}