package com.lino.hr_payroll.controllers;

import com.lino.hr_payroll.entities.Payment;
import com.lino.hr_payroll.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private Environment env;

    @Autowired
    private PaymentServices services;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        logger.info("PORT = "+env.getProperty("local.server.port"));

        Payment payment = services.getPayment(workerId, days);
        return ResponseEntity.ok(payment);

    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {


        Payment payment = new Payment("Bran", 400.0,days);
        return ResponseEntity.ok(payment);

    }
}
