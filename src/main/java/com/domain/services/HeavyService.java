package com.domain.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HeavyService {
    
    @Cacheable("somedata")
    public String getSomeData(){
        simulateSlowProcess();
        return "i get the data!!";
    }

    private void simulateSlowProcess(){
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new IllegalStateException(e);
        }
    }

}
