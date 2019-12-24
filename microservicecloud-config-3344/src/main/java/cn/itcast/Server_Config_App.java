package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启config
public class Server_Config_App {

    public static void main(String[] args) {
        SpringApplication.run(Server_Config_App.class,args);
    }
}
