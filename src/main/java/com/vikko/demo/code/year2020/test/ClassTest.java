package com.vikko.demo.code.year2020.test;

public class ClassTest extends Hello {

	public ClassTest() {
		System.out.println("Test create");
	}

	{
		System.out.println("I'm Test class");
	}

	static {
		System.out.println("static Test");
	}

	public static void main(String[] args) {
		new ClassTest();
	}
}