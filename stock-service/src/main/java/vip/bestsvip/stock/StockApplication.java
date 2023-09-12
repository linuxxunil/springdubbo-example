package vip.bestsvip.stock;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;

@EnableAutoDataSourceProxy
@EnableDubbo
@SpringBootApplication
@ComponentScan("vip.bestsvip.stock.*")
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
