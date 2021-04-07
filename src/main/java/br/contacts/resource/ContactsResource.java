package br.contacts.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path(value = "/contacts")
public class ContactsResource {
	
	List<Contact> contacts = new ArrayList<Contact>();
	public void init() {
		contacts.add(new Contact(1,"Vladmir",954657458,"vlad@mail.com"));
		contacts.add(new Contact(2,"Mario",965842145,"mario@mail.com"));
		contacts.add(new Contact(3,"Antonio",965817895,"toninho@mail.com"));
		contacts.add(new Contact(4,"Walter",955478966,"waltinho@mail.com"));
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public List<Contact> contacts() {
		init();
		return contacts;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("find/{id}")
	public Response listContact(@PathParam("id") String id) {
		init();
		for (Contact index : contacts) {
			if(index.getId().equals(new Integer(id))) {
				return Response.status(Status.OK).entity(index).build();
			}
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("new")
	public Response newContact(Contact contact) {
		init();
		contact.setId(contacts.size()+1);
		contacts.add(contact);
		return Response.status(Status.CREATED).entity(contact).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update")
	public Response updateContact(Contact contact) {
		init();
		Contact update = null;
		for (Contact index : contacts) {
			if(index.getId().equals(contact.getId())) {
				update = index;		
			}
		}
		if(update != null ) {			
			update.setNome(contact.getNome());
			update.setTelefone(contact.getTelefone());
			update.setEmail(contact.getEmail());		
			return Response.status(Status.OK).entity(contact).build();			
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
		
	}	
	
	@DELETE
	@Produces
	@Path("remove/{id}")
	public Response rmContact(@PathParam("id") String id) {
		init();
		Contact rm = null;
		for (Contact index : contacts) {
			if(index.getId().equals(new Integer(id))) {
				rm = index;
			}
			if(contacts.remove(rm)) {
				return Response.status(Status.OK).entity("Removed").build();				
			}
		}
		return Response.status(Status.NO_CONTENT).build();
		
	}
}
