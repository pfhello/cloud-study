package cn.itcast;

import cn.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //服务启动后自动注册进eureka
//在启动服务时加载自定义的ribbon配置类,使配置生效(自定义rule)
//MySelfRule类不能在@ComponentScan扫描的包下
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = {MySelfRule.class})
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
