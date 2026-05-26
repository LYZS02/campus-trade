package com.campus.trade.repository;

import com.campus.trade.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findBySoldFalseOrderByCreatedDateDesc();

    @Query("SELECT i FROM Item i WHERE i.sold = false AND "
         + "(:category IS NULL OR i.category = :category) AND "
         + "(:keyword IS NULL OR i.title LIKE %:keyword% OR i.description LIKE %:keyword%) "
         + "ORDER BY i.createdDate DESC")
    List<Item> search(@Param("category") String category, @Param("keyword") String keyword);

    List<Item> findBySellerId(Long sellerId);
}
