package com.demo.merchantservice.validator;

import com.demo.merchantservice.common.ErrorMessage;
import com.demo.merchantservice.model.Merchant;
import com.demo.merchantservice.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantValidator {

    @Autowired
    private MerchantRepository repository;

    public List<ErrorMessage> validateMerchant(Merchant merchant) {
        final List<ErrorMessage> errorMessages = new ArrayList<>();

        final Merchant merchantByName = repository.findByName(merchant.getName());

        if (merchantByName == null ){
            errorMessages.add(new ErrorMessage("Name", "Merchant name already in use"));
        }
        return errorMessages;
    }

    public List<ErrorMessage> validateMerchantIdExist(Merchant merchant) {
        final List<ErrorMessage> errorMessages = new ArrayList<>();

        final Merchant merchantById = repository.findById(merchant.getId()).orElse(null);

        if (merchantById == null ){
            errorMessages.add(new ErrorMessage("Merchant Id", "Merchant not found"));
        }
        return errorMessages;
    }
}
