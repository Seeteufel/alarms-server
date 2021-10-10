package org.med.resource;

import org.med.service.subscription.Subscription;
import org.med.service.subscription.SubscriptionsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/subscription")
public class AlarmsSubscription {

    @Inject
    SubscriptionsRepository subscriptionsRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response subscribe(Subscription subscription) {
        subscriptionsRepository.create(subscription);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response subscribe(String host) {
        subscriptionsRepository.create(new Subscription(host));
        return Response
                .status(Response.Status.CREATED)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subscription> getAllSubscriptions() {
        return subscriptionsRepository.getAllSubscriptions();
    }

    @GET
    @Path("/{id}")
    public Response getStatus(@PathParam("id") UUID id) {
        if (subscriptionsRepository.find(id)) {
            return Response
                    .status(Response.Status.FOUND)
                    .build();
        }
        else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") UUID id) {
        subscriptionsRepository.delete(id);
        return Response
                .status(Response.Status.OK)
                .build();
    }
}
