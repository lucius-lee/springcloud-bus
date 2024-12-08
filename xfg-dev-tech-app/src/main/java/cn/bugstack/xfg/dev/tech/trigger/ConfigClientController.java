package cn.bugstack.xfg.dev.tech.trigger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${hi}")
    private String hello;

    @RequestMapping("/hi")
    public String hi() {
        return this.hello;
    }

}
