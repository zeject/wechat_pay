package com.wechat.protocol.transfers.promotion;

import com.wechat.config.Configure;
import com.wechat.util.RandomStringGenerator;
import com.wechat.util.Signature;
import com.wechat.util.Util;

public class PromotionTransfersReqData {

    private String mch_appid = "";
    private String mchid = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String partner_trade_no = "";
    private String openid = "";
    private String check_name = "";
    private String re_user_name = "";
    private int amount = 0;
    private String desc = "";
    private String spbill_create_ip = "";

    /**
     * 企业付款
     *
     * @param partner_trade_no 商户订单号
     * @param openid           用户openid
     * @param re_user_name     收款用户姓名
     * @param amount           金额
     * @param desc             企业付款描述信息
     * @param spbill_create_ip Ip地址
     */
    public PromotionTransfersReqData(String partner_trade_no, String openid,
                                     String re_user_name, int amount, String desc,
                                     String spbill_create_ip) {
        setMch_appid(Configure.getAppid());
        setMchid(Configure.getMchid());

        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        setPartner_trade_no(partner_trade_no);

        setOpenid(openid);

        // NO_CHECK：不校验真实姓名
        // FORCE_CHECK：强校验真实姓名
        setCheck_name("FORCE_CHECK");

        setRe_user_name(re_user_name);
        setAmount(amount);
        setDesc(desc);
        setSpbill_create_ip(spbill_create_ip);

        build();
    }

    public PromotionTransfersReqData build() {
        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(Util.objectToMap(this));
        setSign(sign);// 把签名数据设置到Sign这个属性中
        return this;
    }

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCheck_name() {
        return check_name;
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public String getRe_user_name() {
        return re_user_name;
    }

    public void setRe_user_name(String re_user_name) {
        this.re_user_name = re_user_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }
}
