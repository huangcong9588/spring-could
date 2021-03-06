package com.example.sericefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HiController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        //return restTemplate.getForEntity("http://service-hi/hi",String.class,name).toString();
        return schedualServiceHi.sayHiFromClientOne( name );
    }
}
