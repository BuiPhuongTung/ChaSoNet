/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.service.impl;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Payment;
import com.ttp.repository.PaymentRepository;
import com.ttp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getPayments() {
        return this.paymentRepository.getPayments();
    }

    @Override
    public Payment getPaymentById(int payId) {
        return this.paymentRepository.getPaymentById(payId);
    }

    @Override
    public boolean addPayment(Payment payment) {
        return this.paymentRepository.addPayment(payment);
    }
}
