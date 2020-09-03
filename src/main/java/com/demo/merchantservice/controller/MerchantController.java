package com.demo.merchantservice.controller;

import com.demo.merchantservice.common.ErrorMessage;
import com.demo.merchantservice.common.ResponseWrapper;
import com.demo.merchantservice.model.Merchant;
import com.demo.merchantservice.service.MerchantService;
import com.demo.merchantservice.validator.MerchantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class MerchantController {

    private static final String STATUS = "status";
    @Autowired
    private MerchantService service;

    @Autowired
    private MerchantValidator validator;

    @GetMapping("/findById/{id}")
    public Merchant findMerchantById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ResponseWrapper> findAllMerchant() {
        final List<Merchant> merchants = service.findAll();
        return ResponseEntity.ok(new ResponseWrapper(merchants, Collections.singletonMap(STATUS, HttpStatus.OK)));
    }

    @PostMapping("/addMerchant")
    public ResponseEntity<ResponseWrapper> addMerchant(@RequestBody Merchant merchant) {
        final List<ErrorMessage> errorMessages = validator.validateMerchant(merchant);
        if (!errorMessages.isEmpty()) {
            return new ResponseEntity(new ResponseWrapper(Collections.singletonMap(STATUS, HttpStatus.NOT_ACCEPTABLE), errorMessages), HttpStatus.NOT_ACCEPTABLE);
        }
        final Merchant addedMerchant = service.addMerchant(merchant);
        return ResponseEntity.ok(new ResponseWrapper(addedMerchant, Collections.singletonMap(STATUS, HttpStatus.OK)));
    }

    @PostMapping("/payMerchant")
    public ResponseEntity<ResponseWrapper> payMerchant(@RequestBody Merchant merchant) {
        final List<ErrorMessage> errorMessages = validator.validateMerchantIdExist(merchant);
        if (!errorMessages.isEmpty()) {
            return new ResponseEntity(new ResponseWrapper(Collections.singletonMap(STATUS, HttpStatus.NOT_ACCEPTABLE), errorMessages), HttpStatus.NOT_ACCEPTABLE);
        }
        final Merchant payMerchant = service.payMerchant(merchant);
        return ResponseEntity.ok(new ResponseWrapper(payMerchant, Collections.singletonMap(STATUS, HttpStatus.OK)));
    }
}
