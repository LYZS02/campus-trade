package com.campus.trade.service;

import com.campus.trade.entity.Order;
import com.campus.trade.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(Order order) {
        order.setOrderNo("O" + System.currentTimeMillis());
        order.setStatus("pending");
        return orderRepository.save(order);
    }

    public List<Order> listByBuyer(Long buyerId) {
        return orderRepository.findByBuyerIdOrderByCreatedAtDesc(buyerId);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order pay(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("订单不存在"));
        if (!"pending".equals(order.getStatus())) {
            throw new RuntimeException("订单状态不允许付款");
        }
        order.setStatus("paid");
        return orderRepository.save(order);
    }

    public Order ship(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("订单不存在"));
        if (!"paid".equals(order.getStatus())) {
            throw new RuntimeException("订单状态不允许发货");
        }
        order.setStatus("shipped");
        return orderRepository.save(order);
    }

    public Order confirm(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("订单不存在"));
        if (!"shipped".equals(order.getStatus())) {
            throw new RuntimeException("订单状态不允许确认收货");
        }
        order.setStatus("done");
        return orderRepository.save(order);
    }
}
