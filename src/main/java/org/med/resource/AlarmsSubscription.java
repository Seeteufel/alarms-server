package org.med.resource;

import org.med.service.subscription.SubscriptionsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/subscription")
public class AlarmsSubscription {

    @Inject
    SubscriptionsRepository subscriptionsRepository;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response createSubscription() {

        if (subscriptionsRepository.addSubscription()) {
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        }
        else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }
}
