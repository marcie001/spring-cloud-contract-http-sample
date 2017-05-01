package com.example.cdchttpsample;

public class Hello {

	private String name;

	public Hello() {
	}

	public Hello(String name) {
		this.setName(name);
	}

	public String getMessage() {
		return String.format("Hello, %s!!", name);
	}

	public void setName(String name) {
		this.name = name;
	}

}
