package vip.bestsvip.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.bestsvip.order.entity.Orders;
import vip.bestsvip.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}")
    public Orders queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }


    @GetMapping("/create")
    public Orders createOrder(@RequestParam("userId") Long userId,@RequestParam("stockId") Long stockId, @RequestParam("amount") Long amount) {
        return orderService.createOrder(userId, stockId, amount);
    }

}
