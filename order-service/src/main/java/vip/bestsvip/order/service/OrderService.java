package vip.bestsvip.order.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;

import vip.bestsvip.api.dto.UserDto;
import vip.bestsvip.api.service.UserService;
import vip.bestsvip.order.entity.Orders;
import vip.bestsvip.order.repository.OrdersRepository;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

   @DubboReference
    private UserService userService;

    public Orders queryOrderById(Long orderId) {
        // 1.查询订单
        Orders order = ordersRepository.findById(orderId).get();
        // 2.調用Dubbo
        UserDto userDto = userService.queryById(order.getUserId());
        // 3.封装user到Order
        order.setUser(userDto);
        // 4.返回
        return order;
    }

    /*@Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.利用RestTemplate发起http请求，查询用户
        // 2.1.url路径
        String url = "http://userservice/user/" + order.getUserId();
        // 2.2.发送http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }*/
}
