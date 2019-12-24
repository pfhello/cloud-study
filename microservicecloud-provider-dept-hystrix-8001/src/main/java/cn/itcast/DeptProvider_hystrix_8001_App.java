package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient //本服务启动后自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker //对hystrix熔断机制进行支持
public class DeptProvider_hystrix_8001_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_hystrix_8001_App.class,args);
    }
}
