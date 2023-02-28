package com.cnu.devblog.service.valid.lesson2;

import com.cnu.devblog.repository.slang.SlangRepository;
import com.cnu.devblog.service.valid.PostValidService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@DataJpaTest
public class PostValidServiceWithSpringContextTest {
    @Autowired
    PostValidService postValidService;

    @Autowired
    SlangRepository slangRepository;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Spring Boot 환경에서 post 내용에 비속어가 있나 테스트")
    @Test
    void testValidPost() {
        // given
        String testInput = "비속어가 섞인 욕";
        List<String> slangEntities = postValidService.getSlangList();
        // when
        boolean validPost = postValidService.isValidPost(slangEntities, testInput);
        // then 검증
        assertThat(validPost).isEqualTo(false);
    }

}