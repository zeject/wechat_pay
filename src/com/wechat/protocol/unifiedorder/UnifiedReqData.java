package com.wechat.protocol.unifiedorder;


import com.wechat.config.Configure;
import com.wechat.util.RandomStringGenerator;
import com.wechat.util.Signature;
import com.wechat.util.Util;

public class UnifiedReqData {

    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String body = "";
    private String detail = "";
    private String attach = "";
    private String out_trade_no = "";
    private String fee_type = "";
    private int total_fee = 0;
    private String spbill_create_ip = "";
    private String time_start = "";
    private String time_expire = "";
    private String goods_tag = "";
    private String notify_url = "";
    private String trade_type = "";
    private String product_id = "";
    private String limit_pay = "";
    private String openid = "";
    private String scene_info = "";

//    /**
//     * 扫码支付
//     *
//     * @param body
//     * @param out_trade_no
//     * @param total_fee
//     * @param spbill_create_ip
//     * @param notify_url
//     * @param product_id
//     */
//
//    public UnifiedReqData(String body, String out_trade_no, int total_fee, String spbill_create_ip, String notify_url,
//                          String product_id) {
//        setAppid(Configure.getAppid());
//
//        // 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
//        setMch_id(Configure.getMchid());
//
//        setBody(body);
//
//        setOut_trade_no(out_trade_no);
//
//        setTotal_fee(total_fee);
//
//        setSpbill_create_ip(spbill_create_ip);
//
//        setNotify_url(notify_url);
//
//        setTrade_type("NATIVE");
//
//        setProduct_id(product_id);
//        setScene_info("");
//        // 随机字符串，不长于32 位
//        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
//
//        setLimit_pay("no_credit");
//
//        // 根据API给的签名规则进行签名
//        String sign = Signature.getSign(Util.objectToMap(this));
//        setSign(sign);// 把签名数据设置到Sign这个属性中
//    }
//
//    /**
//     * JSAPI
//     *
//     * @param body
//     * @param out_trade_no
//     * @param total_fee
//     * @param spbill_create_ip
//     * @param notify_url
//     * @param product_id
//     * @param openid
//     */
//
//    public UnifiedReqData(String body, String out_trade_no, int total_fee, String spbill_create_ip, String notify_url,
//                          String product_id, String openid) {
//        setAppid(Configure.getAppid());
//
//        // 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
//        setMch_id(Configure.getMchid());
//
//        setBody(body);
//
//        setOut_trade_no(out_trade_no);
//
//        setTotal_fee(total_fee);
//
//        setSpbill_create_ip(spbill_create_ip);
//
//        setNotify_url(notify_url);
//
//        setTrade_type("JSAPI");
//
//        setProduct_id(product_id);
//
//        // 随机字符串，不长于32 位
//        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
//
//        setLimit_pay("no_credit");
//
//        setOpenid(openid);
//
//        // 根据API给的签名规则进行签名
//        String sign = Signature.getSign(Util.objectToMap(this));
//        setSign(sign);// 把签名数据设置到Sign这个属性中
//    }

    /**
     * 通用
     *
     * @param body
     * @param out_trade_no
     * @param total_fee
     * @param spbill_create_ip
     * @param notify_url
     */
    public UnifiedReqData(String body, String out_trade_no, int total_fee, String spbill_create_ip, String notify_url) {
        // 微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(Configure.getAppid());

        // 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(Configure.getMchid());

        setBody(body);

        setOut_trade_no(out_trade_no);

        setTotal_fee(total_fee);

        setSpbill_create_ip(spbill_create_ip);

        setNotify_url(notify_url);

        // 随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        setLimit_pay("no_credit");

        build();

    }

    /**
     * app下单
     *
     * @return
     */
    public UnifiedReqData appendApp() {
        setTrade_type("APP");
        return this;
    }

    /**
     * 扫码支付下单
     *
     * @param product_id 产品id
     * @return
     */
    public UnifiedReqData appendNative(String product_id) {
        setTrade_type("NATIVE");
        setProduct_id(product_id);
        return this;
    }

    /**
     * 公众号,小程序下单
     *
     * @param openid 用户在此公众号下的openid
     * @return
     */
    public UnifiedReqData appendJsApi(String openid) {
        setTrade_type("JSAPI");
        setOpenid(openid);
        return this;
    }

    /**
     * h5下单
     *
     * @param sceneInfo 下单场景
     * @return
     */
    public UnifiedReqData appendMWeb(BaseSceneInfo sceneInfo) {
        setTrade_type("MWEB");
        setScene_info(sceneInfo.toJson());
        System.out.println(sceneInfo.toJson());
        return this;
    }

    public UnifiedReqData build() {
        // 根据API给的签名规则进行签名
        String sign = Signature.getSign(Util.objectToMap(this));
        setSign(sign);// 把签名数据设置到Sign这个属性中
        return this;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScene_info() {
        return scene_info;
    }

    public void setScene_info(String scene_info) {
        this.scene_info = scene_info;
    }

}
