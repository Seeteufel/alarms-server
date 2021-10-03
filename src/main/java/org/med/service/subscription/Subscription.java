package org.med.service.subscription;

import java.util.Date;
import java.util.UUID;


public class Subscription {

    private Date createDate;
    private Date endDate;
    private UUID id;
    private String host;

    public Subscription() {}

    public Subscription(Date createDate, Date endDate, UUID id, String host) {
        this.createDate = createDate;
        this.endDate = endDate;
        this.id = id;
        this.host = host;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
