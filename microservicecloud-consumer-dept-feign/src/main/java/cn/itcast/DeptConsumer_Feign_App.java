package cn.itcast;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //服务启动后自动注册进eureka
@EnableFeignClients(basePackages = "cn.itcast")
public class DeptConsumer_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign_App.class,args);
    }
}
