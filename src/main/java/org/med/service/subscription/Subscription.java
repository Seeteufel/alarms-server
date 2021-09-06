package org.med.service.subscription;

import java.util.Date;
import java.util.UUID;

public class Subscription {

    private UUID id;
    private Date creationDate;

    public Subscription() {
        id = UUID.randomUUID();
        creationDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                '}';
    }
}
