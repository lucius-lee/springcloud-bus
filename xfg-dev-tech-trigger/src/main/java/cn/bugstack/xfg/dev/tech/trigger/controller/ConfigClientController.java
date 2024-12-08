package cn.bugstack.xfg.dev.tech.trigger.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${hello}")
    private String hello;

    @RequestMapping("/hello")
    public String hello() {
        return this.hello;
    }

}
