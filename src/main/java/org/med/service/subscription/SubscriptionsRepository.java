package org.med.service.subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@ApplicationScoped
public class SubscriptionsRepository {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionsRepository.class);

    private final List<Subscription> subscriptions;

    public SubscriptionsRepository() {
        subscriptions = new ArrayList<>();
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptions;
    }

    public void create(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void delete(UUID id) {
        subscriptions.removeIf(s -> Objects.equals(s.getId(), id));
    }

    public boolean find(UUID id) {
        return subscriptions.stream()
                .anyMatch(s -> Objects.equals(s.getId(), id));
    }

    public void sendNotification() {
        for (Subscription s : subscriptions) {
            try {
                URL url = new URL("http://" + s.getHost());
                String payload = "An alarm created.";

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
                conn.setRequestProperty("Content-Length", Integer.toString(payload.length()));
                conn.setUseCaches(false);

                try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                    dos.writeBytes(payload);
                }
            } catch (Exception e) {
                logger.info(e.toString());
            }
        }
    }
}
