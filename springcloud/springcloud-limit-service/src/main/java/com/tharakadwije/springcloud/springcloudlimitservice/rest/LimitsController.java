package com.tharakadwije.springcloud.springcloudlimitservice.rest;

import com.tharakadwije.springcloud.springcloudlimitservice.config.Configuration;
import com.tharakadwije.springcloud.springcloudlimitservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retriveLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }

}
