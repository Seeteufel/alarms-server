package org.med.resource;

import org.med.service.Alarm;
import org.med.service.AlarmsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/alarms")
public class AlarmsResource {

    @Inject
    AlarmsRepository alarms;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Alarms resource!!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alarm> getAllAlarms() {
        return alarms.getAllAlarms();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Alarm getAlarm(@PathParam("id") String id) {
        return alarms.getSingleAlarm(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAlarm(Alarm alarm) {
        alarms.createAlarm(alarm);
        return Response
                .status(Response.Status.CREATED)
                .entity("Alarm was created in AlarmRepository.")
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeAlarm(@PathParam("id") String id) {
        alarms.deleteAlarm(id);
        return Response
                .status(Response.Status.NO_CONTENT)
                .entity("Alarm with id " + id + " was removed from AlarmRepository.")
                .build();
    }
}