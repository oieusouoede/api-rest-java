package br.contacts.resource.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.contacts.resource.Contact;
import br.contacts.resource.ContactHelper;

public class ContactHelperTest {
	
	// Im importing the class im intending to test
	ContactHelper contactHelper = new ContactHelper();
	
	// This how one can limit the execution time for tests
	public static final long LIMIT = 20000;
	
	// This is an annotation that I can use to set things up before the test. 
	// It will be executed before every method's test
	@Before
	public void beforeTest() {
		System.out.println("Initiating method test");
	}
	// This one will be executed after the method's test
	@After
	public void afterTest()	{
		System.out.println("Finished method test");
	}
	// Same but at class level (the methods inside it have to be static)
	@BeforeClass
	public static void beforeClassTest() {
		System.out.println("Initiating class test");
	}
	@AfterClass
	public static void afterClassTest() {
		System.out.println("Finished class test");
	}
	
	
	// Test case (with timout limit)
	@Test(timeout = LIMIT)
	public void findContactTest() {
		Contact foundObj = contactHelper.findContact(1);
		assertEquals(new Integer(1), foundObj.getId());
	}
	
	// Test with non existing value
	@Test
	public void findContactTestNull() {
		Contact foundObj = contactHelper.findContact(10);
		assertEquals(null, foundObj);
	}
	
}
