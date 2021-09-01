package org.med.service;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class AlarmsRepository {

    private static final Logger logger = LoggerFactory.getLogger(AlarmsRepository.class);

    private List<Alarm> alarms;
    private final AlarmsGenerator generator;
    private final ScheduledExecutorService scheduledExecutorService;

    String initNumberOfAlarms = ConfigProvider.getConfig().getValue("initial.size.of.alarms", String.class);

    public AlarmsRepository() {
        scheduledExecutorService = Executors.newScheduledThreadPool(3); // number of scheduled actions
        generator = new AlarmsGenerator();
        alarms = generator.createListOfAlarms(Integer.parseInt(initNumberOfAlarms));
    }

    public List<Alarm> getAllAlarms() {
        return alarms;
    }

    private Runnable writeSnapshot() {
        return () -> {
            Alarms wrappedAlarms = new Alarms();
            wrappedAlarms.setAlarms(alarms);
            AlarmsXML.writer("alarms_cache.xml", wrappedAlarms);
            logger.info("writeSnapshot method called");
        };
    }

    private Runnable createAlarmPeriodically() {
        return () -> {
            alarms = generator.createListOfAlarms(1);
            logger.info("createAlarmPeriodically method called");
        };

    }

    private Runnable terminateAlarmPeriodically() {
        return () -> {
            int noOfAlarms = alarms.size();
            if (noOfAlarms > 1) {
                int listIndex = new Random().nextInt(noOfAlarms);
                alarms.remove(listIndex);
                logger.info("terminateAlarmPeriodically method called");
            }
        };
    }

    void onStart(@Observes StartupEvent ev) throws InterruptedException {

        String creationInterval = ConfigProvider.getConfig().getValue("alarms.creation.interval", String.class);
        String terminationInterval = ConfigProvider.getConfig().getValue("alarms.termination.interval", String.class);
        String dumpingInterval = ConfigProvider.getConfig().getValue("alarms.snapshot.interval", String.class);
        String simulationPeriod = ConfigProvider.getConfig().getValue("simulation.lifecycle.period", String.class);

        scheduledExecutorService.scheduleWithFixedDelay(createAlarmPeriodically(), 60,
                Integer.parseInt(creationInterval), TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(terminateAlarmPeriodically(), 30,
                Integer.parseInt(terminationInterval), TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(writeSnapshot(), 10,
                Integer.parseInt(dumpingInterval), TimeUnit.SECONDS);

        Thread.sleep(Integer.parseInt(simulationPeriod) * 1000 * 60);
        scheduledExecutorService.shutdown();
        scheduledExecutorService.awaitTermination(5 * 1000, TimeUnit.SECONDS);
    }
}
