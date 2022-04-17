package com.example.backend.entity;

import org.springframework.context.ApplicationEvent;

public class Soccer extends ApplicationEvent {
    private String location;
    private int numberOfPlayers;

    public Soccer(Object source, String location, int numberOfPlayers) {
        super(source);
        this.location = location;
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public String toString() {
        return " Soccer now has:" + numberOfPlayers + " people";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
