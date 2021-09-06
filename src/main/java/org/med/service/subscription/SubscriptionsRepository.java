package org.med.service.subscription;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class SubscriptionsRepository {

    private List<Subscription> subscriptions;

    public SubscriptionsRepository() {
        subscriptions = new ArrayList<>();
    }

    public boolean addSubscription() {
        Subscription s = new Subscription();
        subscriptions.add(s);
        if (subscriptions.contains(s)) {
            return true;
        }
        else {
            return false;
        }
    }
}
