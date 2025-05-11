package com.dailycode.Springboot.tutorial.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id ="features")
public class FeatureEndpoint {

    private  final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

    public FeatureEndpoint() {
       // featureMap.put("Department" , new Feature(isEnabled:true));
       // featureMap.put("user" , new Feature(isEnabled:false));
        featureMap.put("Department", new Feature(true));
        featureMap.put("user", new Feature(false));

    }
    @ReadOperation
    public Map<String,Feature> features (){
        return featureMap;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature{
        private boolean isEnabled;
    }


}
