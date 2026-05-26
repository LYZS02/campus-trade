package com.campus.trade.controller;

import com.campus.trade.entity.Item;
import com.campus.trade.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Map<String,Object>> list(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String keyword) {
        List<Map<String,Object>> result = new ArrayList<>();
        for (Item item : itemService.listAll(category, keyword)) {
            result.add(toMap(item));
        }
        return result;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return itemService.findById(id)
                .map(i -> ResponseEntity.ok((Object) toMap(i)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String,Object> body) {
        Item item = new Item();
        item.setTitle((String) body.get("title"));
        item.setDescription((String) body.getOrDefault("description", ""));
        item.setPrice(new BigDecimal(body.get("price").toString()));
        if (body.get("origPrice") != null) {
            item.setOrigPrice(new BigDecimal(body.get("origPrice").toString()));
        }
        item.setCategory((String) body.get("category"));
        item.setSellerId(Long.valueOf(body.get("sellerId").toString()));
        item.setSellerName((String) body.get("sellerName"));
        item.setImage((String) body.getOrDefault("image", null));
        item.setSold(false);
        item.setCreatedDate(LocalDate.now());
        return ResponseEntity.ok(toMap(itemService.create(item)));
    }

    @GetMapping("/seller/{sellerId}")
    public List<Map<String,Object>> listBySeller(@PathVariable Long sellerId) {
        List<Map<String,Object>> result = new ArrayList<>();
        for (Item item : itemService.findBySeller(sellerId)) {
            result.add(toMap(item));
        }
        return result;
    }

    private Map<String,Object> toMap(Item item) {
        Map<String,Object> m = new LinkedHashMap<>();
        m.put("id", item.getId());
        m.put("title", item.getTitle());
        m.put("description", item.getDescription());
        m.put("price", item.getPrice());
        m.put("origPrice", item.getOrigPrice());
        m.put("category", item.getCategory());
        m.put("sellerId", item.getSellerId());
        m.put("sellerName", item.getSellerName());
        m.put("image", item.getImage());
        m.put("time", item.getCreatedDate().toString());
        m.put("sold", item.getSold());
        return m;
    }
}
