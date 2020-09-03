package com.demo.merchantservice.service;

import com.demo.merchantservice.model.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    Merchant addMerchant(Merchant merchant);

    List<Merchant> findAll();

    Optional<Merchant> findById(Long id);

    Merchant payMerchant(Merchant merchant);
}
