package com.demo.services;

import com.demo.entity.Payments;

public interface PaymentService {
    Payments savePayments(Payments payments);
    Payments showPaymentDetails(String payerName);
}
