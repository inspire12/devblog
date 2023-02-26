package com.cnu.devblog.service.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class PostValidServiceTest {
    PostValidService postValidService = new PostValidService();

    @DisplayName("post 내용에 비속어가 있나")
    @Test
    void testValidPostIncludeSlang() {
        // given 시나리오
        String testInput = "비속어가 섞인 욕";
        List<String> slangList = List.of("비속어", "비속어2");

        // when 실행
        boolean validPost = postValidService.isValidPost(slangList, testInput);

        // then 검증
        assertThat(validPost).isEqualTo(true);
    }
}