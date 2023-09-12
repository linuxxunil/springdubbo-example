package vip.bestsvip.order.service;

import vip.bestsvip.api.service.GlobalOrderService;
import vip.bestsvip.order.entity.Orders;

public interface OrderService extends GlobalOrderService{
    Orders queryOrderById(Long orderId);
    Orders createOrder(Long userId, Long stockId, Long amount);
}
