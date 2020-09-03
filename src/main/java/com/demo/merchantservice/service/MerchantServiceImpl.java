package com.demo.merchantservice.service;

import com.demo.merchantservice.model.Merchant;
import com.demo.merchantservice.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository repository;

    @Override
    public Merchant addMerchant(Merchant merchant) {
        merchant.setBalance(0L);
        return repository.save(merchant);
    }

    @Override
    public List<Merchant> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Merchant> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Merchant payMerchant(Merchant merchant) {
        final Merchant merchantUpdated = repository.findById(merchant.getId()).orElse(null);
        if (merchantUpdated != null) {
            merchantUpdated.setBalance(merchantUpdated.getBalance() + merchant.getBalance());
            return repository.save(merchantUpdated);
        }
        return null;
    }
}
