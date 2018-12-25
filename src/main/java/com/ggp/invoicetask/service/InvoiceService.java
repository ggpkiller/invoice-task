package com.ggp.invoicetask.service;

import com.alibaba.fastjson.JSON;
import com.ggp.invoicetask.bean.InvoicePacket;
import com.ggp.invoicetask.util.DESSecurityUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class InvoiceService {
    private final static Log log = LogFactory.getLog(InvoiceService.class);
    @Value("${invoice-service-url}")
    private String invoiceServiceUrl;

    /**
     * @param packet
     * @return
     * @Descript 发送开票请求
     */
    public boolean submitInvoice(InvoicePacket packet) throws UnsupportedEncodingException {
        String identity = packet.getIdentity();
        Map<String, Object> data = new HashMap<>();
        data.put("identity", identity);
        data.put("order", packet);
        String json = JSON.toJSONString(data);
        log.info("处理开票请求：=[ \n" + json + " \n]");
        String diactdest = DESSecurityUtil.encrypt(json);
        String res = this.sendPost("order=" + diactdest);
        System.out.println(res);
        return Objects.nonNull(res);
    }

    /**
     * 发送POST请求
     *
     * @param data
     * @return
     * @throws IOException
     */
    public String sendPost(String data) {
        HttpURLConnection conn = null;
        String result = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            conn = (HttpURLConnection) new URL(this.invoiceServiceUrl).openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Charset", "UTF-8");


            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            out.write(data);
            out.flush();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }
            result = builder.toString();
        } catch (IOException e) {
            try {
                if(Objects.nonNull(conn) && conn.getResponseCode() != HttpURLConnection.HTTP_OK){
                    log.info("开票失败，响应信息："+ conn.getResponseMessage());
                    log.error("开票失败，异常信息:",e);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (Objects.nonNull(in)) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(out)) {
                out.close();
            }
        }
        return result;

    }
}
