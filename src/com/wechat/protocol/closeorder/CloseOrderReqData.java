package com.wechat.protocol.closeorder;


import com.wechat.config.Configure;
import com.wechat.util.RandomStringGenerator;
import com.wechat.util.Signature;
import com.wechat.util.Util;

public class CloseOrderReqData {

    // 每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String out_trade_no = "";
    private String nonce_str = "";
    private String sign = "";

    /**
     * 请求支付查询服务
     *
     * @param outTradeNo 商户系统内部的订单号,transaction_id 、out_trade_no
     *                   二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @return API返回的XML数据
     * @throws Exception
     */
    public CloseOrderReqData(String outTradeNo) {

        // --------------------------------------------------------------------
        // 以下是测试数据，请商户按照自己的实际情况填写具体的值进去
        // --------------------------------------------------------------------

        // 微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(Configure.getAppid());

        // 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(Configure.getMchid());

        // 商户系统自己生成的唯一的订单号
        setOut_trade_no(outTradeNo);

        // 随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        build();
    }

    public CloseOrderReqData build() {
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

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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
}
