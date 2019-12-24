package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启动eurekaserver
public class EurekaServerConfig7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerConfig7001_App.class,args);
    }
}
