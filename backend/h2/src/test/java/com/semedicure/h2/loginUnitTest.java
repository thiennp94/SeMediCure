package com.semedicure.h2;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.semedicure.h2.models.login;
import com.semedicure.h2.services.loginService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class loginUnitTest {
	@Autowired
	private login L;
	
	@SuppressWarnings("deprecation")
	@Test
	public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
		java.util.List<login> LR = loginService.list();
		
		Assert.assertEquals(LR.size(), 2);
}
}

