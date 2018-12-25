package com.ggp.invoicetask.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 发票数据包
 */
@SuppressWarnings("unused")
public class InvoicePacket {


    /**
     * @serial 销方税号（必须）
     * 销方税号（必须）
     */
    private String saletaxnum;

    /**
     * 销方诺诺认证号 （必须)
     */
    @JSONField(serialize = false)
    private String identity;
    /**
     * 购方手机号 (必须)
     */
    private String phone;

    /**
     * 购方抬头
     */
    private String buyername;

    /**
     * 购方地址（企业必须）
     */
    private String address;

    /**
     * 购方银行账号（企业必须）
     */
    private String account;

    /**
     * 订单号 (必须)
     */
    private String orderno;

    /**
     * @var \Carbon\Carbon 单据时间（必须）
     */
    private String invoicedate;


    /**
     * 开票员（必须）
     */
    private String clerk;

    /**
     * 销方电话(必须)
     */
    private String salephone;

    /**
     * 销方地址(必须)
     */
    private String saleaddress;

    /**
     * 开票类型：1.正票；2.红票
     */
    private final String kptype;

    /**
     * 购方电子邮箱
     */
    private String email;


    /**
     * 推送方式(写死，邮箱)
     */
    private final String tsfs;

    /**
     * 电子发票明细
     */
    private List<InvoiceDetailItem> detail;

    public InvoicePacket() {
        this.tsfs = "0";
        this.kptype = "1";
        this.invoicedate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.detail = new ArrayList<>();
    }


    public String getSaletaxnum() {
        return saletaxnum;
    }

    public String getIdentity() {
        return identity;
    }


    public String getBuyername() {
        return buyername;
    }

    public String getAddress() {
        return address;
    }

    public String getAccount() {
        return account;
    }

    public String getOrderno() {
        return orderno;
    }

    public String getInvoicedate() {
        return invoicedate;
    }

    public String getClerk() {
        return clerk;
    }

    public String getSalephone() {
        return salephone;
    }

    public String getSaleaddress() {
        return saleaddress;
    }

    public String getKptype() {
        return kptype;
    }

    public String getEmail() {
        return email;
    }

    public String getTsfs() {
        return tsfs;
    }

    public List<InvoiceDetailItem> getDetail() {
        return detail;
    }


    public void setSaletaxnum(String saletaxnum) {
        this.saletaxnum = saletaxnum;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public void setClerk(String clerk) {
        this.clerk = clerk;
    }

    public void setSalephone(String salephone) {
        this.salephone = salephone;
    }

    public void setSaleaddress(String saleaddress) {
        this.saleaddress = saleaddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDetail(List<InvoiceDetailItem> detail) {
        this.detail = detail;
    }

    /**
     * 添加发票明细项
     * @param goodsname 商品名称
     * @param taxrate 税率
     * @param taxamt 含税价
     */
    public void addDetailItem(String goodsname,String taxrate,String taxamt) {
        this.detail.add(new InvoiceDetailItem(goodsname,taxrate,taxamt));
    }
}


