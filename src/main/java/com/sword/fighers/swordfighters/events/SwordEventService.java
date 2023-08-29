package com.sword.fighers.swordfighters.events;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SwordEventService {
    private static final List<SwordEvent> SWORD_EVENTS = new ArrayList<>();
    static {
        SWORD_EVENTS.add(new SwordEvent(SWORD_EVENTS.size() + 1, "Jerry", "Tom", "Jerry is fighting Tom", "admin", LocalDate.now().plusDays(10), false));
        SWORD_EVENTS.add(new SwordEvent(SWORD_EVENTS.size() + 1, "Tom", "Jerry", "Tom is fighting Jerry", "admin", LocalDate.now().plusDays(20), false));
        SWORD_EVENTS.add(new SwordEvent(SWORD_EVENTS.size() + 1, "Jerry", "Tom", "Jerry is fighting Tom", "admin", LocalDate.now().plusDays(30), false));
    }
    
    @Autowired
    private SwordEventRepository repository;

    public List<SwordEvent> getSwordEvents() {
        return repository.findAll();
    }

    public void addSwordEvent(String defender, String challenger, String description, String username, LocalDate date, boolean done) {
        SwordEvent swordEvent = new SwordEvent(SWORD_EVENTS.size() + 1, defender, challenger, description, username, date, done);
        repository.save(swordEvent);
    }

    public void deleteSwordEvent(int id) {
        repository.deleteById(id);
    }

    public SwordEvent updateSwordEvent(int id) {
        return repository.findById(id).get();
    }

    public void updateSwordEvent(int id, @Valid SwordEvent event) {
        deleteSwordEvent(id);
        repository.save(event);
    }
}

