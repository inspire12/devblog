package com.cnu.devblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DevblogApplicationTests {

	@Test
	void contextLoads(ApplicationContext context) {
		assertThat(context).isNotNull();
	}

	@Test
	void hasPostControllerConfigured(ApplicationContext context) {
		assertThat(context.getBean("postController")).isNotNull();
	}
}
