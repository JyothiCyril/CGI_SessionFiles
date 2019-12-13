package com.qa.selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations {
	
	@BeforeMethod
	public void PreCondition() {
		System.out.println("Executing before method");
	}
	
	@AfterMethod
	
	public void PostCondition() {
		System.out.println("Executiing after method");
	}
	
	
	
	@BeforeTest
	public void Start_Test() {
		System.out.println("Test Started...");
	}
	
	@AfterTest
	public void End_Test() {
		System.out.println("Test ended...");
	}
	
	@Test(priority = 0)
	public void Login_Test() {
		System.out.println("Login test");
	}
	
	@Test(priority = 1)
	public void book_Flight() {
		System.out.println("Book a flight test");
	}

	@Test(priority = 2)
	public void Make_Payment() {
		System.out.println("Make Payment");
	}
	
	@Test(priority = 3)
	public void check_ack() {
		System.out.println("Print acknowledgement");
	}
	
	@Test(priority = 4)
	public void Logout() {
		System.out.println("User Logout the application");
		
	}
}
