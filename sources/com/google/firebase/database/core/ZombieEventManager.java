package com.google.firebase.database.core;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ZombieEventManager implements EventRegistrationZombieListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ZombieEventManager defaultInstance = new ZombieEventManager();
    final HashMap<EventRegistration, List<EventRegistration>> globalEventRegistrations = new HashMap<>();

    private ZombieEventManager() {
    }

    @NotNull
    public static ZombieEventManager getInstance() {
        return defaultInstance;
    }

    public void recordEventRegistration(EventRegistration registration) {
        synchronized (this.globalEventRegistrations) {
            List list = (List) this.globalEventRegistrations.get(registration);
            if (list == null) {
                list = new ArrayList();
                this.globalEventRegistrations.put(registration, list);
            }
            list.add(registration);
            if (!registration.getQuerySpec().isDefault()) {
                EventRegistration defaultRegistration = registration.clone(QuerySpec.defaultQueryAtPath(registration.getQuerySpec().getPath()));
                List list2 = (List) this.globalEventRegistrations.get(defaultRegistration);
                if (list2 == null) {
                    list2 = new ArrayList();
                    this.globalEventRegistrations.put(defaultRegistration, list2);
                }
                list2.add(registration);
            }
            registration.setIsUserInitiated(true);
            registration.setOnZombied(this);
        }
    }

    private void unRecordEventRegistration(EventRegistration zombiedRegistration) {
        synchronized (this.globalEventRegistrations) {
            List<EventRegistration> registrationList = (List) this.globalEventRegistrations.get(zombiedRegistration);
            int i = 0;
            if (registrationList != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= registrationList.size()) {
                        break;
                    } else if (registrationList.get(i2) == zombiedRegistration) {
                        registrationList.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (registrationList.isEmpty() != 0) {
                    this.globalEventRegistrations.remove(zombiedRegistration);
                }
            }
            if (!zombiedRegistration.getQuerySpec().isDefault()) {
                EventRegistration defaultRegistration = zombiedRegistration.clone(QuerySpec.defaultQueryAtPath(zombiedRegistration.getQuerySpec().getPath()));
                List list = (List) this.globalEventRegistrations.get(defaultRegistration);
                if (list != null) {
                    while (true) {
                        if (i >= list.size()) {
                            break;
                        } else if (list.get(i) == zombiedRegistration) {
                            list.remove(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (list.isEmpty() != 0) {
                        this.globalEventRegistrations.remove(defaultRegistration);
                    }
                }
            }
        }
    }

    public void zombifyForRemove(EventRegistration registration) {
        synchronized (this.globalEventRegistrations) {
            List<EventRegistration> registrationList = (List) this.globalEventRegistrations.get(registration);
            if (registrationList != null && !registrationList.isEmpty()) {
                if (registration.getQuerySpec().isDefault()) {
                    HashSet<QuerySpec> zombiedQueries = new HashSet<>();
                    for (int i = registrationList.size() - 1; i >= 0; i--) {
                        EventRegistration currentRegistration = (EventRegistration) registrationList.get(i);
                        if (!zombiedQueries.contains(currentRegistration.getQuerySpec())) {
                            zombiedQueries.add(currentRegistration.getQuerySpec());
                            currentRegistration.zombify();
                        }
                    }
                } else {
                    ((EventRegistration) registrationList.get(0)).zombify();
                }
            }
        }
    }

    public void onZombied(EventRegistration zombiedInstance) {
        unRecordEventRegistration(zombiedInstance);
    }
}
