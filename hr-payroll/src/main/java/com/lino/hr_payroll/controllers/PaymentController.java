package com.lino.hr_payroll.controllers;

import com.lino.hr_payroll.entities.Payment;
import com.lino.hr_payroll.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentServices services;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {

        Payment payment = services.getPayment(workerId, days);
        return ResponseEntity.ok(payment);

    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {

        Payment payment = new Payment("Bran", 400.0,days);
        return ResponseEntity.ok(payment);

    }
}
