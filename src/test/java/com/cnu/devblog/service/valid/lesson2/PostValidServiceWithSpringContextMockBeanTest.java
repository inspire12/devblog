package com.cnu.devblog.service.valid.lesson2;

import com.cnu.devblog.entity.Slang;
import com.cnu.devblog.repository.persistence.slang.SlangRepository;
import com.cnu.devblog.service.valid.PostValidService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostValidServiceWithSpringContextMockBeanTest {
    @Autowired
    PostValidService postValidService;

    @MockBean
    SlangRepository slangRepository;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("MockBean을 통해 post 내용에 비속어가 있나 테스트")
    @Test
    void testValidPost() {
        // given
        String testInput = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");
        List<Slang> slangEntities = new ArrayList<>();

        for (String slangText: slangList) {
            slangEntities.add(new Slang(slangText));
        }
        when(slangRepository.findAll()).thenReturn(slangEntities);

        List<String> slangTexts = postValidService.getSlangList();
        // when
        boolean validPost = postValidService.isValidPost(postValidService.getSlangList(), testInput);
        // then 검증
        assertThat(validPost).isEqualTo(true);
    }

}