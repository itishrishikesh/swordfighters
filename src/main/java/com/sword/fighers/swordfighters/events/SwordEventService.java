package com.sword.fighers.swordfighters.events;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SwordEventService {
    private static final List<SwordEvents> swordEvents = new ArrayList<>();
    static {
        swordEvents.add(new SwordEvents(swordEvents.size() + 1, "Jerry", "Tom", "Jerry is fighting Tom", "admin", LocalDate.now().plusDays(10), false));
        swordEvents.add(new SwordEvents(swordEvents.size() + 1, "Tom", "Jerry", "Tom is fighting Jerry", "admin", LocalDate.now().plusDays(20), false));
        swordEvents.add(new SwordEvents(swordEvents.size() + 1, "Jerry", "Tom", "Jerry is fighting Tom", "admin", LocalDate.now().plusDays(30), false));
    }

    public List<SwordEvents> getSwordEvents() {
        System.out.println("SwordEventService.getSwordEvents: " + swordEvents);
        return Collections.unmodifiableList(swordEvents);
    }

    public void addSwordEvent(String defender, String challenger, String description, String username, LocalDate date, boolean completed) {
        SwordEvents swordEvent = new SwordEvents(swordEvents.size() + 1, defender, challenger, description, username, date, completed);
        swordEvents.add(swordEvent);
    }
}

