package org.med.service;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Alarm {

    private String notificationIdentifier;
    private PerceivedSeverity severity;
    private Date eventTime;
    private String probableCause;
    private String additionalText;

    public Alarm() {
    }

    public Alarm(String notificationIdentifier, PerceivedSeverity severity, Date eventTime, String probableCause, String additionalText) {
        this.notificationIdentifier = notificationIdentifier;
        this.severity = severity;
        this.eventTime = eventTime;
        this.probableCause = probableCause;
        this.additionalText = additionalText;
    }

    public PerceivedSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(PerceivedSeverity severity) {
        this.severity = severity;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getProbableCause() {
        return probableCause;
    }

    public void setProbableCause(String probableCause) {
        this.probableCause = probableCause;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    public String getNotificationIdentifier() {
        return notificationIdentifier;
    }

    public void setNotificationIdentifier(String notificationIdentifier) {
        this.notificationIdentifier = notificationIdentifier;
    }



    @Override
    public String toString() {
        return "Alarm{" +
                "NotificationIdentifier='" + notificationIdentifier + '\'' +
                ", Severity=" + severity +
                ", EventTime=" + eventTime +
                ", ProbableCause='" + probableCause + '\'' +
                ", AdditionalText='" + additionalText + '\'' +
                '}';
    }

}

