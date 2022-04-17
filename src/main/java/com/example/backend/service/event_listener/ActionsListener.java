package com.example.backend.service.event_listener;

import com.example.backend.config.QuanaqtConfig;
import com.example.backend.entity.GoFishingEvt;
import com.example.backend.entity.Soccer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ActionsListener {

    @Autowired
    private QuanaqtConfig quanaqtConfig;

    @EventListener
    public void goFishing(GoFishingEvt fishingEvt) {
        System.out.println(Thread.currentThread().getName() + "-" +fishingEvt);
    }

    @Async
    @EventListener
    public void playSoccer(Soccer soccer) {
        System.out.println(Thread.currentThread().getName() + "-" + soccer + " play at " + soccer.getLocation() + " with " + quanaqtConfig);

    }
}
