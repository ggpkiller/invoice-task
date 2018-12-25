package com.ggp.invoicetask.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class InvoiceTask {

    @Scheduled(fixedRate = 5000)
    public void submitInvoice(){
        System.out.println("发票任务处理中。。。");
    }
}
