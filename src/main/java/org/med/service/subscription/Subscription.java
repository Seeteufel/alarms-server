package org.med.service.subscription;

import org.eclipse.microprofile.config.ConfigProvider;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


public class Subscription {

    String validityPeriod = ConfigProvider.getConfig().getValue("subscription.default.period", String.class);

    private Date createDate;
    private Date endDate;
    private UUID id;
    private String host;

    public Subscription() {}

    public Subscription(String host) {
        Date creationDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(creationDate);
        calendar.add(Calendar.SECOND, Integer.parseInt(validityPeriod));

        this.createDate = creationDate;
        this.endDate = calendar.getTime();
        this.id = UUID.randomUUID();
        this.host = host;
    }

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
