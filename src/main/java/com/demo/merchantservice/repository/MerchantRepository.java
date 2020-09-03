package com.demo.merchantservice.repository;

import com.demo.merchantservice.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    @Query("SELECT m from Merchant m WHERE m.name = :name ")
    Merchant findByName(@Param("name") String name);
}
