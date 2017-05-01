package com.example.cdchttpsample;

import org.junit.Before;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

public class HelloBase {
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(new HelloController());
	}

}
