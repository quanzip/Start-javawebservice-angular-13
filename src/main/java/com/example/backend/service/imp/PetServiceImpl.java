package com.example.backend.service.imp;

import com.example.backend.config.QuanaqtConfig;
import com.example.backend.service.exception.ExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnBean(value = {ExceptionHandler.class, SymptomsServiceImpl.class})
public class PetServiceImpl {
    public PetServiceImpl() {
        System.out.println(this.getClass().getName() + " created because ExceptionHandler existed");
    }

}
