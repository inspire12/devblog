package com.cnu.devblog.service.valid.lesson1;


import com.cnu.devblog.entity.Slang;
import com.cnu.devblog.repository.slang.SlangRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;


@DataJpaTest
@TestPropertySource("classpath:application-test.yml")  //
public class PostValidServiceRepositoryTest {

    @Autowired
    SlangRepository slangRepository;

    @DisplayName("비속어가 있나 테스트")
    @Test
    void testGetSlang() {
        List<Slang> all = slangRepository.findAll();
        System.out.println(all);
    }
}
