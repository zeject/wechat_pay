package com.wechat.protocol.transfers.transferinfo;

import com.wechat.config.Configure;
import com.wechat.util.RandomStringGenerator;
import com.wechat.util.Signature;
import com.wechat.util.Util;

public class PromotionTransfersInfoReqData {

    private String nonce_str = "";
    private String sign = "";
    private String partner_trade_no = "";
    private String mch_id = "";
    private String appid = "";

    /**
     * 查询企业付款
     *
     * @param partner_trade_no 商户订单号
     */
    public PromotionTransfersInfoReqData(String partner_trade_no) {
        setAppid(Configure.getAppid());
        setMch_id(Configure.getMchid());

        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        setPartner_trade_no(partner_trade_no);

        build();

    }

    public PromotionTransfersInfoReqData build() {
        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(Util.objectToMap(this));
        setSign(sign);// 把签名数据设置到Sign这个属性中
        return this;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

}
