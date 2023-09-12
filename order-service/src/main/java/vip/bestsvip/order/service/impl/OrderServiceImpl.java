package vip.bestsvip.order.service.impl;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.seata.spring.annotation.GlobalTransactional;
import vip.bestsvip.api.dto.StockDto;
import vip.bestsvip.api.dto.UserDto;
import vip.bestsvip.api.service.StockService;
import vip.bestsvip.api.service.UserService;
import vip.bestsvip.order.entity.Orders;
import vip.bestsvip.order.repository.OrdersRepository;
import vip.bestsvip.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @DubboReference
    private StockService stockService;

    @DubboReference
    private UserService userService;

    public Orders queryOrderById(Long orderId) {
        // 1.查询订单
        Orders order = ordersRepository.findById(orderId).get();
        // 2.調用Dubbo
        UserDto userDto = userService.queryById(order.getUserId());
        // 3.封装user到Order
        order.setUserDto(userDto);
        // 4.返回
        return order;
    }

    @Override
    @GlobalTransactional
    public Orders createOrder(Long userId, Long stockId, Long amount) {
        
        StockDto stockDto = stockService.dedcut(stockId, amount);
        UserDto userDto = userService.queryById(userId);
        
        int a = 1/0 ;

        Orders orders = new Orders();
        orders.setStockId(stockId);
        orders.setName(stockDto.getName());
        orders.setAmount(amount);
        orders.setUserId(userId);
        ordersRepository.save(orders);

        orders.setUserDto(userDto);
        orders.setStockDto(stockDto);
        return orders;
       
    }

    /*
     * @Autowired
     * private RestTemplate restTemplate;
     * 
     * public Order queryOrderById(Long orderId) {
     * // 1.查询订单
     * Order order = orderMapper.findById(orderId);
     * // 2.利用RestTemplate发起http请求，查询用户
     * // 2.1.url路径
     * String url = "http://userservice/user/" + order.getUserId();
     * // 2.2.发送http请求，实现远程调用
     * User user = restTemplate.getForObject(url, User.class);
     * // 3.封装user到Order
     * order.setUser(user);
     * // 4.返回
     * return order;
     * }
     */
}
