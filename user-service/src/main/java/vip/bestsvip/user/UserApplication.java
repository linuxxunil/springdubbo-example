package vip.bestsvip.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;

@EnableAutoDataSourceProxy
@EnableDubbo
@SpringBootApplication
@ComponentScan("vip.bestsvip.user.*")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
