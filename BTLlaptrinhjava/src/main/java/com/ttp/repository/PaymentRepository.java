/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.repository;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Payment;

import java.util.List;

public interface PaymentRepository {
    List<Payment> getPayments();
    Payment getPaymentById(int payId);
    boolean addPayment(Payment payment);
}
