package br.contacts.resource;

import java.util.List;
import javax.inject.Inject;
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
public class ContactResource {

	// Injects my helper class with all my friends on it

	@Inject
	ContactHelper contactHelper;

	// Get all contacts

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response allContacts() {
		contactHelper.init();
		List<Contact> allofthem = contactHelper.getContacts();
		if(allofthem != null) {
			return Response.status(Status.OK).entity(allofthem).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	// Find by ID

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("find/{id}")
	public Response listContact(@PathParam("id") String id) {
		Contact contactObj = contactHelper.findContact(new Integer(id));
		if(contactObj != null) {
			return Response.status(Status.OK).entity(contactObj).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	// Include new contact

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("new")
	public Response newContact(Contact input) {
		Contact included = contactHelper.includeContact(input);
		if(included != null ) {
			return Response.status(Status.CREATED).entity(contactHelper.getContacts()).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	// Update contact

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update")
	public Response updateContact(Contact input) {
		Contact updated = contactHelper.updateContact(input);
		if(updated != null ) {
			return Response.status(Status.OK).entity(contactHelper.getContacts()).build();
		} else {
			return Response.status(Status.NO_CONTENT).build();
		}
	}

	// Delete by ID

	@DELETE
	@Produces
	@Path("remove/{id}")
	public Response rmContact(@PathParam("id") String id) {
		Contact rm = contactHelper.rmContact(new Integer(id));
		if(contactHelper.getContacts().remove(rm)) {
			return Response.status(Status.OK).entity(contactHelper.getContacts()).build();
		} else {
		return Response.status(Status.NO_CONTENT).build();
		}
	}
}