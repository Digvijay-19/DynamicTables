package com.TestNGTestCases;

import org.testng.annotations.Test;

public class TestCases {

	
	@Test
	public void methodOne(){
		System.out.println("Method One");
	}
	
	@Test
	public void methodTwo(){
		System.out.println("Method Two");
	}
	
	@Test
	public void methodThree(){
		System.out.println("Method Three");
	}
	
	@Test(enabled=false)
	public void methodFour(){
		System.out.println("Method Four");
	}
}
