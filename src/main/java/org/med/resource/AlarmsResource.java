package org.med.resource;

import org.med.service.Alarm;
import org.med.service.AlarmsRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/alarms")
public class AlarmsResource {

    @Inject
    AlarmsRepository alarms;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Alarms resource.";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alarm> getAllAlarms() {
        return alarms.getAllAlarms();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alarm> getAlarm(@PathParam("id") String id) {
        return null;
    }
}