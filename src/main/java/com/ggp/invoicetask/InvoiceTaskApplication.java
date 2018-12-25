package com.ggp.invoicetask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InvoiceTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvoiceTaskApplication.class, args);
    }
}
