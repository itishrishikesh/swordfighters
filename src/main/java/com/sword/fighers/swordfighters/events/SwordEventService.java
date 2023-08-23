package com.sword.fighers.swordfighters.events;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Service
public class SwordEventService {
    private static final List<SwordEvent> SWORD_EVENTS = new ArrayList<>();
    static {
        SWORD_EVENTS.add(new SwordEvent(SWORD_EVENTS.size() + 1, "Jerry", "Tom", "Jerry is fighting Tom", "admin", LocalDate.now().plusDays(10), false));
        SWORD_EVENTS.add(new SwordEvent(SWORD_EVENTS.size() + 1, "Tom", "Jerry", "Tom is fighting Jerry", "admin", LocalDate.now().plusDays(20), false));
        SWORD_EVENTS.add(new SwordEvent(SWORD_EVENTS.size() + 1, "Jerry", "Tom", "Jerry is fighting Tom", "admin", LocalDate.now().plusDays(30), false));
    }

    public List<SwordEvent> getSwordEvents() {
        System.out.println("SwordEventService.getSwordEvents: " + SWORD_EVENTS);
        return Collections.unmodifiableList(SWORD_EVENTS);
    }

    public void addSwordEvent(String defender, String challenger, String description, String username, LocalDate date, boolean done) {
        SwordEvent swordEvent = new SwordEvent(SWORD_EVENTS.size() + 1, defender, challenger, description, username, date, done);
        SWORD_EVENTS.add(swordEvent);
    }

    public void deleteSwordEvent(int id) {
        Predicate<? super SwordEvent> predicate = (swordEvent) -> swordEvent.getId() == id;
        SWORD_EVENTS.removeIf(predicate);
    }

    public SwordEvent updateSwordEvent(int id) {
        return SWORD_EVENTS.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public void updateSwordEvent(int id, @Valid SwordEvent event) {
        deleteSwordEvent(id);
        SWORD_EVENTS.add(event);
    }
}

