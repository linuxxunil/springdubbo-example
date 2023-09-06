package vip.bestsvip.order.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import vip.bestsvip.api.dto.UserDto;


@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private long userId;

    @Transient
    private UserDto user;
}