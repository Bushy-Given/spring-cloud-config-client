package com.bushy.springcloudconfigclient.controller;

import com.bushy.springcloudconfigclient.config.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bushy-Netshidaulu
 * on 5/7/2020
 */
@RestController
@RequestMapping(PropertiesController.BaseURL)
public class PropertiesController {
    public static final String BaseURL= "config-props/";

    @Value("${my.greeting}")
    private String greeting;
    @Value("${my.list.values}")
    private List<String> listOfNumbers;

    @Autowired
    private DbSettings dbSettings;

    public PropertiesController() {
    }

    @GetMapping("greeting")
    public String getGreeting(){
        return greeting;
    }
    @GetMapping("list")
    public List<String> getListOfNumbers(){
        return listOfNumbers;
    }
    @GetMapping("db-connection")
    public String connectionString(){
        return dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort() ;
    }
}
