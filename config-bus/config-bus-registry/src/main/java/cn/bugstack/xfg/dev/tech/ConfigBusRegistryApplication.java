package cn.bugstack.xfg.dev.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConfigBusRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run( ConfigBusRegistryApplication.class, args );
    }

}
