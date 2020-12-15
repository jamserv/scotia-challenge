package com.scotia.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author janezmejias.09@gmail.com
 * @version SPRINT-2020A
 * @see 
 */
@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class ScotiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScotiaApplication.class, args);
    }

}
