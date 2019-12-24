package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启服务监控
public class Hystrix_Dashboard_App {

    public static void main(String[] args) {

        SpringApplication.run(Hystrix_Dashboard_App.class,args);
    }
}
