package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启zuul
public class Zuul_Gateway_App {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_Gateway_App.class,args);
    }
}
