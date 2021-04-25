package br.contacts.resource;

import java.util.ArrayList;
import java.util.List;

// This class generates an imaginary database and provides with methods for the resource class

public class ContactHelper {

	// Imaginary friends generator

	List<Contact> contacts = new ArrayList<Contact>();
	public void init() {
		contacts.add(new Contact(1,"Vladmir",954657458,"vlad@mail.com"));
		contacts.add(new Contact(2,"Mario",965842145,"mario@mail.com"));
		contacts.add(new Contact(3,"Antonio",965817895,"toninho@mail.com"));
		contacts.add(new Contact(4,"Walter",955478966,"waltinho@mail.com"));
	}

	// Get all contacts method

	public List<Contact> getContacts() {
		return contacts;
	}

	// Find contact method

	public Contact findContact(Integer id) {
		init();
		for (Contact index : contacts) {
			if(index.getId().equals(id)) {
				return index;
			}
		}
		return null;
	}

	// Include contact method
	
	public Contact includeContact(Contact input) {
		init();
		Contact included = null;
		if (input != null) {
			input.setId(getContacts().size()+1);
			included = input;
			getContacts().add(input);
		}
		return included;
	}

	// Update contact method

	public Contact updateContact(Contact input) {
		init();
		Contact updated = null;
		for (Contact record : getContacts()) {
			if(record.getId().equals(input.getId())) {
				record.setNome(input.getNome());
				record.setTelefone(input.getTelefone());
				record.setEmail(input.getEmail());
				updated = record;
			}
		}
		return updated;
	}

	// Remove contact method

	public Contact rmContact(Integer id) {
		init();
		Contact rm = null;
		for (Contact index : getContacts()) {
			if(index.getId().equals(new Integer(id))) {
				rm = index;
			}
		}
		return rm;
	}
}