package com.lino.hr_payroll.services;

import com.lino.hr_payroll.entities.Payment;
import com.lino.hr_payroll.entities.Worker;
import com.lino.hr_payroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service//Vai esta toda nossa regra de negocio
public class PaymentServices {

    @Autowired
    private WorkerFeignClient workerFeignClient;
    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();
       return new Payment(worker.getName(), worker.getDailyIncome(),days);
    }
}
