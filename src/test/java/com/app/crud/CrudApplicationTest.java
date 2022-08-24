package com.app.crud;

import com.app.crud.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CrudApplicationTest {

	@Autowired
	private MainController mainController;

	@Test
	public void contextLoads() {
		assertThat(mainController).isNotNull();
	}

}
