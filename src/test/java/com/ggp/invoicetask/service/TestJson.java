package com.ggp.invoicetask.service;

import com.ggp.invoicetask.util.DESSecurityUtil;
import org.junit.Test;

import java.io.*;

public class TestJson {

    @Test
    public void testJson() throws IOException {
        String json = "{\n" +
                "  \"buyername\": \"李思然\",\n" +
                "  \"clerk\": \"张会计\",\n" +
                "  \"detail\": [\n" +
                "    {\n" +
                "      \"fphxz\": \"0\",\n" +
                "      \"goodsname\": \"停车费\",\n" +
                "      \"hsbz\": \"1\",\n" +
                "      \"spbm\": \"30405020202\",\n" +
                "      \"tax\": \"0.06\",\n" +
                "      \"taxamt\": \"2.0\",\n" +
                "      \"taxfreeamt\": \"1.94\",\n" +
                "      \"taxrate\": \"0.03\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"email\": \"guogp_pc@126.com\",\n" +
                "  \"invoicedate\": \"2018-11-02 10:31:11\",\n" +
                "  \"kptype\": \"1\",\n" +
                "  \"orderno\": \"1541125871188\",\n" +
                "  \"phone\": \"13259516732\",\n" +
                "  \"saleaddress\": \"宁夏回族自治区银川市金凤区宝湖中路宝湖福邸\",\n" +
                "  \"salephone\": \"18595157043\",\n" +
                "  \"saletaxnum\": \"339901999999142\"\n" +
                "}";

        System.out.println(json);

        String dest = DESSecurityUtil.encrypt(json);

        System.out.println(dest);

    }
}
