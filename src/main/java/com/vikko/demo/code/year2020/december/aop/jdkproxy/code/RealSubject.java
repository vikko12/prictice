package com.vikko.demo.code.year2020.december.aop.jdkproxy.code;

public class RealSubject implements Subject {

	public void doSomething() {
		System.out.println("call doSomething()");
	}
}
