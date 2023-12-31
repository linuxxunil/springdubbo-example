package vip.bestsvip.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;

@EnableAutoDataSourceProxy
@SpringBootApplication
@ComponentScan("vip.bestsvip.order.*")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}