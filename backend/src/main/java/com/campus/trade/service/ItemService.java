package com.campus.trade.service;

import com.campus.trade.entity.Item;
import com.campus.trade.repository.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> listAll(String category, String keyword) {
        if ((category == null || category.isEmpty()) && (keyword == null || keyword.isEmpty())) {
            return itemRepository.findBySoldFalseOrderByCreatedDateDesc();
        }
        return itemRepository.search(
            (category == null || category.isEmpty()) ? null : category,
            (keyword == null || keyword.isEmpty()) ? null : keyword
        );
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findBySeller(Long sellerId) {
        return itemRepository.findBySellerId(sellerId);
    }
}
