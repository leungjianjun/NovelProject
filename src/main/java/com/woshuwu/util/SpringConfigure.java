package com.woshuwu.util;

import com.woshuwu.test.schedular.WebSchedular;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 13-2-24
 * Time: 下午4:30
 */

@Configuration
public class SpringConfigure {

    public SpringConfigure(){

    }

    @PostConstruct
    public void contextInitialized(){
        System.out.println("Context Initialised ===========================");
        WebSchedular.startup();
    }

    @PreDestroy
    public void contextdestroyed(){
        System.out.println("Context Destroyed =============================");
    }
}
