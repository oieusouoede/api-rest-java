package br.contacts.resource.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.contacts.resource.Contact;
import br.contacts.resource.ContactHelper;
import br.contacts.resource.ContactResource;

// Tell junit to run this class with mockito
@RunWith(MockitoJUnitRunner.class)
public class ContactsResourceTest {

	// Injects mocked objects
	@InjectMocks
	ContactResource contactsResource = new ContactResource();

	// mocking the injected class with mockito (need a RunWith annotation)
	@Mock
	ContactHelper contactHelper;

	// Create object for mockito
	Contact contact;

	@Test
	public void listContactTest() {

		when(contactHelper.findContact(1)).thenReturn(contact);
		Response foundObj = contactsResource.listContact("1");
		assertEquals(200, foundObj.getStatus());

	}

	// This is an annotation that I can use to set things up before the test.
	// It will be executed before every method's test
	@Before
	public void beforeTest() {
		System.out.println("Initiating method test");

		// mocked object
		contact = new Contact();
		contact.setId(1);
		contact.setNome("Manoel");
		contact.setEmail("mail@mail.com");
		contact.setTelefone(965423214);
	}
	// This one will be executed after the method's test. Can be used to reset things up
	@After
	public void afterTest()	{
		System.out.println("Finished method test");
	}
}