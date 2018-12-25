package com.ggp.invoicetask.service;

import com.ggp.invoicetask.bean.InvoicePacket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class InvoiceServiceTest {
    @Autowired
    private InvoiceService invoiceService;
    @Test
    public void submitInvoice() throws UnsupportedEncodingException {
        InvoicePacket packet = new InvoicePacket();
        packet.setIdentity("93363DCC6064869708F1F3C72A0CE72A713A9D425CD50CDE");
        packet.setSaletaxnum("339901999999142");
        packet.setBuyername("李思然");
        packet.setPhone("13259516732");
        packet.setOrderno(System.currentTimeMillis() + "");
        packet.setClerk("张会计");
        packet.setSalephone("18595157043");
        packet.setSaleaddress("宁夏回族自治区银川市金凤区宝湖中路宝湖福邸");
        packet.setEmail("guogp_pc@126.com");

        packet.addDetailItem("安装费","0.03","2.0");

        invoiceService.submitInvoice(packet);
    }
}