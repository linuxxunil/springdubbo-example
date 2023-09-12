package vip.bestsvip.stock.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    private Long id;
    private String name;
    private Long amount;
}