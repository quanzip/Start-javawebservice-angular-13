package com.example.backend.entity;

import org.springframework.context.ApplicationEvent;

public class GoFishingEvt extends ApplicationEvent {
    private int numberOfPeople;
    private String leader;

    public GoFishingEvt(Object source, int numberOfPeople, String leader) {
        super(source);
        this.numberOfPeople = numberOfPeople;
        this.leader = leader;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return  " Fishing now has: {" +
                "numberOfPeople=" + numberOfPeople +
                ", leader='" + leader + '\'' +
                '}';
    }
}
