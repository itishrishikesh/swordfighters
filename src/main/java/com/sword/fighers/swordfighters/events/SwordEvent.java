package com.sword.fighers.swordfighters.events;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class SwordEvent {

    private int id;
    private String defender;
    private String challenger;
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;
    private String adminUserName;
    private LocalDate scheduledDate;
    private boolean done;

    public SwordEvent(int id, String defender, String challenger, String description, String adminUserName, LocalDate scheduledDate, boolean done) {
        this.id = id;
        this.defender = defender;
        this.challenger = challenger;
        this.description = description;
        this.adminUserName = adminUserName;
        this.scheduledDate = scheduledDate;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDefender() {
        return defender;
    }

    public void setDefender(String defender) {
        this.defender = defender;
    }

    public String getChallenger() {
        return challenger;
    }

    public void setChallenger(String challenger) {
        this.challenger = challenger;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
