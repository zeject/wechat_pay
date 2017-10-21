package com.wechat.protocol.coupon;

import com.wechat.config.Configure;
import com.wechat.util.RandomStringGenerator;
import com.wechat.util.Signature;
import com.wechat.util.Util;

public class CouponReqData {

    private String coupon_stock_id = "";
    private int openid_count = 0;
    private String partner_trade_no = "";
    private String openid = "";
    private String appid = "";
    private String mch_id = "";
    private String op_user_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String version = "";
    private String type = "";

    /**
     * 发放代金券
     *
     * @param coupon_stock_id  代金券批次id
     * @param partner_trade_no 商户单据号
     * @param openid           用户openid
     */
    public CouponReqData(String coupon_stock_id, String partner_trade_no, String openid) {
        setAppid(Configure.getAppid());
        setMch_id(Configure.getMchid());
        setCoupon_stock_id(coupon_stock_id);
        setOpenid_count(1);
        setPartner_trade_no(partner_trade_no);
        setOpenid(openid);
        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
        build();
    }

    public CouponReqData build() {
        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(Util.objectToMap(this));
        setSign(sign);// 把签名数据设置到Sign这个属性中
        return this;
    }

    public String getCoupon_stock_id() {
        return coupon_stock_id;
    }

    public void setCoupon_stock_id(String coupon_stock_id) {
        this.coupon_stock_id = coupon_stock_id;
    }

    public int getOpenid_count() {
        return openid_count;
    }

    public void setOpenid_count(int openid_count) {
        this.openid_count = openid_count;
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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getOp_user_id() {
        return op_user_id;
    }

    public void setOp_user_id(String op_user_id) {
        this.op_user_id = op_user_id;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
