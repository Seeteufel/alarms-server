package org.med.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class AlarmsGenerator {
    private static final int maxStringLen = 10;
    private static final TimeUnit maxAgeOfAlarmUnit = TimeUnit.HOURS;
    private static final int maxAgeOfAlarm = 5;

    private final List<Alarm> alarms;
    private final Faker faker;
    private final Date referenceDate;

    public AlarmsGenerator() {
        alarms = new LinkedList<>();
        faker = new Faker(new Locale("en-GB"));
        referenceDate = new Date();
    }

    public List<Alarm> createListOfAlarms(int numberOfAlarms) {
        for (int i = 0; i < numberOfAlarms; i++) {
            alarms.add(
                    new Alarm(
                            faker.numerify("AlarmID:########"),
                            PerceivedSeverity.values()[faker.number().numberBetween(0, 5)],
                            faker.date().past(maxAgeOfAlarm, maxAgeOfAlarmUnit, referenceDate),
                            faker.lorem().characters(maxStringLen),
                            faker.lorem().characters(maxStringLen)
                    )
            );
        }
        return alarms;
    }
}
