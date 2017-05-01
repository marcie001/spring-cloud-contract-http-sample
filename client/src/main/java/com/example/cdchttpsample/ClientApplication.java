package com.example.cdchttpsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ClientApplication.class);

	private final RestTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Autowired
	public ClientApplication(RestTemplateBuilder builder) {
		this.template = builder.build();
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(hello("Jane"));
	}

	public String hello(String name) {
		// @formatter:off 
		UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("127.0.0.1")
				.port(18080)
				.path("/hello")
				.queryParam("name", name);
		// @formatter:on

		ResponseEntity<GreetingDto> res = template.getForEntity(builder.build(false).toUri(), GreetingDto.class);
		return res.getBody().getMessage();
	}

}
