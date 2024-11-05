package com.lino.hr_payroll.services;

import com.lino.hr_payroll.entities.Payment;
import com.lino.hr_payroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service//Vai esta toda nossa regra de negocio
public class PaymentServices {

    @Value("${hr-worker.host}")
    private String workerHost;
    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));

        Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}",Worker.class, uriVariables);

       return new Payment(worker.getName(), worker.getDailyIncome(),days);
    }
}
