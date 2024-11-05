package com.lino.hr_payroll.services;

import com.lino.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service//Vai esta toda nossa regra de negocio
public class PaymentServices {

    public Payment getPayment(long workerId, int days){
       return new Payment("Bob", 200.0,days);
    }
}
