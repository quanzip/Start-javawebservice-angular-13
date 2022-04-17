package com.example.backend.service.event_publisher;

import com.example.backend.entity.GoFishingEvt;
import com.example.backend.entity.Soccer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Publisher {

    public Publisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        System.out.println("Start publishing events...");
    }

    private ApplicationEventPublisher applicationEventPublisher;

    public void goFishingPublisher() {
        System.out.println("\n******" + "publisher: Asking anyone go fishing...");
        applicationEventPublisher.publishEvent(new GoFishingEvt(this, 5, "Quanaqt"));
    }

    public void playSoccerPublisher(Soccer soccer, LocalDateTime localDateTime) {
        System.out.println("\n******" +  "publisher: Asking anyone go to play soccer at " + localDateTime);
        applicationEventPublisher.publishEvent(soccer);
    }
}
