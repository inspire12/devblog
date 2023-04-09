package com.cnu.devblog.service.valid.lesson1;

import com.cnu.devblog.entity.Slang;
import com.cnu.devblog.repository.persistence.slang.SlangRepository;
import com.cnu.devblog.service.valid.PostValidService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MockBeans({@MockBean(PostValidService.class), @MockBean(SlangRepository.class)})
@SpringBootTest
class PostValidServiceTest {
    @Autowired
    PostValidService postValidService;

    @Autowired
    SlangRepository slangRepository;

    @BeforeEach
    void setUp() {
    }

    private List<Slang> getSlangEntities() {
        List<String> slangList = List.of("비속어", "비속어2");
        List<Slang> slangEntities = new ArrayList<>();
        for (String slangText: slangList) {
            slangEntities.add(new Slang(slangText));
        }
        return slangEntities;
    }

    @DisplayName("post 내용에 비속어가 있나 테스트 - mock 적용 O/X")
    @Test
    void testValidPostIncludeMockSlang() {
        // given 시나리오
        String testInput = "비속어가 섞인 욕";
        List<Slang> slangEntities = getSlangEntities();

        // when 에서 실행될 과정에서 나올 데이터를 mocking 해준다
        when(slangRepository.findAll()).thenReturn(slangEntities);
        // when 실행
        List<String> slangList = postValidService.getSlangList();
        boolean isPostValid = postValidService.isValidPost(slangList, testInput);
        // then 검증
        assertThat(isPostValid).isEqualTo(false);
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