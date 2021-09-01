package org.med.service;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Alarm {

    private String NotificationIdentifier;
    private PerceivedSeverity Severity;
    private Date EventTime;
    private String ProbableCause;
    private String AdditionalText;

    public Alarm() {
    }

    public Alarm(String notificationIdentifier, PerceivedSeverity severity, Date eventTime, String probableCause, String additionalText) {
        NotificationIdentifier = notificationIdentifier;
        Severity = severity;
        EventTime = eventTime;
        ProbableCause = probableCause;
        AdditionalText = additionalText;
    }

    public String getNotificationIdentifier() {

        return NotificationIdentifier;
    }

    public PerceivedSeverity getSeverity() {

        return Severity;
    }

    public void setSeverity(PerceivedSeverity severity) {

        Severity = severity;
    }

    public Date getEventTime() {

        return EventTime;
    }

    public String getProbableCause() {

        return ProbableCause;
    }

    public void setProbableCause(String probableCause) {
        ProbableCause = probableCause;
    }

    public String getAdditionalText() {

        return AdditionalText;
    }

    public void setAdditionalText(String additionalText) {

        AdditionalText = additionalText;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "NotificationIdentifier='" + NotificationIdentifier + '\'' +
                ", Severity=" + Severity +
                ", EventTime=" + EventTime +
                ", ProbableCause='" + ProbableCause + '\'' +
                ", AdditionalText='" + AdditionalText + '\'' +
                '}';
    }
}

