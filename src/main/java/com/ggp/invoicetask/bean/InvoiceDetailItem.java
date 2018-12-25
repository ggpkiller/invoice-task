package com.ggp.invoicetask.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * 发票明细项
 */
@SuppressWarnings("unused")
public class InvoiceDetailItem {
    /**
     * 商品名称
     */
    private String goodsname;

    /**
     * 含税标志：0：不含税；1：含税
     */
    private final String hsbz;

    /**
     * 税率（必须）
     */
    private String taxrate;

    /**
     * 商品编码
     */
//    private String spbm;

    /**
     * 发票行性质(写死)
     */
    private final String fphxz;

    /**
     * 含税金额
     */
    private String taxamt;

    /**
     * 税额
     */
    private String tax;

    /**
     * 不含税金额
     */
    private String taxfreeamt;

    public InvoiceDetailItem() {
        this.hsbz = "1";
        this.fphxz = "0";
    }

    /**
     *
     * @param goodsname
     * @param taxrate
     * @param taxamt
     */
    public InvoiceDetailItem(String goodsname, String taxrate, String taxamt) {
        this();
        this.goodsname = goodsname;
        this.taxrate = taxrate;
//        this.spbm = spbm;
        this.taxamt = taxamt;
        calculateTax();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public String getHsbz() {
        return hsbz;
    }

    public String getTaxrate() {
        return taxrate;
    }

//    public String getSpbm() {
//        return spbm;
//    }

    public String getFphxz() {
        return fphxz;
    }

    public String getTaxamt() {
        return taxamt;
    }

    public String getTax() {
        return tax;
    }

    public String getTaxfreeamt() {
        return taxfreeamt;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
        calculateTax();
    }

    public void setTaxamt(String taxamt) {
        this.taxamt = taxamt;
        calculateTax();
    }


//    public void setSpbm(String spbm) {
//        this.spbm = spbm;
//    }

    /**
     * 计算税额与不含税金额
     */
    private void calculateTax() {
        if (Objects.nonNull(this.taxrate)
                && Objects.nonNull(this.taxamt)
                && Objects.isNull(this.tax)) {
            double rateNum = Double.parseDouble(this.taxrate);
            double amtNum = Double.parseDouble(this.taxamt);

            double taxNum = amtNum * rateNum / (1.0 + rateNum);
            taxNum = new BigDecimal(taxNum).setScale(2, RoundingMode.HALF_UP).doubleValue();

            this.tax = taxNum + "";
            this.taxfreeamt = (amtNum - taxNum) + "";
        }
    }
}
