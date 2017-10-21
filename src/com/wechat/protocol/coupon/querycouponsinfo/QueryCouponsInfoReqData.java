package com.wechat.protocol.coupon.querycouponsinfo;

import com.wechat.config.Configure;
import com.wechat.util.RandomStringGenerator;
import com.wechat.util.Signature;
import com.wechat.util.Util;

public class QueryCouponsInfoReqData {

    private String coupon_id = "";
    private String openid = "";
    private String appid = "";
    private String mch_id = "";
    private String stock_id = "";
    private String op_user_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String version = "";
    private String type = "";

    /**
     * 查询代金券信息
     *
     * @param coupon_id 代金券id
     * @param openid    Openid信息，用户在appid下的openid。
     * @param stock_id  代金劵对应的批次号
     */
    public QueryCouponsInfoReqData(String coupon_id, String openid, String stock_id) {
        setAppid(Configure.getAppid());
        setMch_id(Configure.getMchid());
        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        setCoupon_id(coupon_id);

        setOpenid(openid);

        setStock_id(stock_id);

        build();
    }

    public QueryCouponsInfoReqData build() {
        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(Util.objectToMap(this));
        setSign(sign);// 把签名数据设置到Sign这个属性中
        return this;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
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

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
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
