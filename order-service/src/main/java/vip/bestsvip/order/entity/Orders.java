package vip.bestsvip.order.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import vip.bestsvip.api.dto.StockDto;
import vip.bestsvip.api.dto.UserDto;


@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    private Long stockId;
    private Long amount;

    @JsonIgnore
    
    private Long userId;

    @Transient
    private UserDto userDto;

    @Transient
    private StockDto stockDto;
}