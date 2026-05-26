package com.campus.trade.controller;

import com.campus.trade.entity.Order;
import com.campus.trade.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String,Object> body) {
        Order order = new Order();
        order.setBuyerId(Long.valueOf(body.get("buyerId").toString()));
        order.setBuyerName((String) body.get("buyerName"));
        order.setItemList((String) body.get("itemList"));
        order.setTotal(new BigDecimal(body.get("total").toString()));
        return ResponseEntity.ok(toMap(orderService.create(order)));
    }

    @GetMapping
    public List<Map<String,Object>> listByBuyer(@RequestParam Long buyerId) {
        List<Map<String,Object>> result = new ArrayList<>();
        for (Order order : orderService.listByBuyer(buyerId)) {
            result.add(toMap(order));
        }
        return result;
    }

    @PutMapping("/{id}/pay")
    public ResponseEntity<?> pay(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(toMap(orderService.pay(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{id}/ship")
    public ResponseEntity<?> ship(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(toMap(orderService.ship(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<?> confirm(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(toMap(orderService.confirm(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return orderService.findById(id)
                .map(o -> ResponseEntity.ok((Object) toMap(o)))
                .orElse(ResponseEntity.notFound().build());
    }

    private Map<String,Object> toMap(Order order) {
        Map<String,Object> m = new LinkedHashMap<>();
        m.put("id", order.getId());
        m.put("orderNo", order.getOrderNo());
        m.put("buyerId", order.getBuyerId());
        m.put("buyerName", order.getBuyerName());
        m.put("itemList", order.getItemList());
        m.put("total", order.getTotal());
        m.put("status", order.getStatus());
        m.put("createdAt", order.getCreatedAt().toString());
        return m;
    }
}
