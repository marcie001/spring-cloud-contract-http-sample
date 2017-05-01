package com.example.cdchttpsample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = { "com.example.cdchttpsample:server:+:stubs:18080" }, workOffline = true)
@DirtiesContext
public class ClientApplicationTests {

	@Autowired
	private ClientApplication target;

	@Test
	public void contextLoads() {
	}

	@Test
	public void hello_太郎() {
		assertThat(target.hello("太郎"), is("Hello, 太郎!!"));
	}

}
