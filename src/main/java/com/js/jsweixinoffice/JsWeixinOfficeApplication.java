package com.js.jsweixinoffice;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan("com.js.jsweixinoffice")
@EnableCreateCacheAnnotation
public class JsWeixinOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsWeixinOfficeApplication.class, args);
    }

}
