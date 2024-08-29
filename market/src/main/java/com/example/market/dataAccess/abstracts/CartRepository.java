package com.example.market.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.market.entities.concretes.Cart;

import jakarta.transaction.Transactional;
public interface CartRepository extends  JpaRepository<Cart,Integer> {
    List<Cart> findByProductId(int productId);
    List<Cart> findByUserId(int userId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Cart c WHERE c.user.id = :userId")
    void deleteAllByUserId(@Param("userId") int userId);
}
