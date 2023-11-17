package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Payments;
import com.demo.services.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/makePayment")
    public ResponseEntity<String> savePayment(@Valid @RequestBody Payments payments, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid payment details");
        }

        Payments savedPayment = paymentService.savePayments(payments);
        if (savedPayment != null) {
            return ResponseEntity.ok("Payment successfully saved");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save payment");
        }
    }

    @GetMapping("/details/{payerName}")
    public ResponseEntity<Payments> getPaymentDetails(@PathVariable String payerName) {
        Payments payment = paymentService.showPaymentDetails(payerName);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
