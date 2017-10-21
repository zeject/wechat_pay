package com.wechat.protocol.sendredpack.redpack;

import com.wechat.config.Configure;
import com.wechat.util.RandomStringGenerator;
import com.wechat.util.Signature;
import com.wechat.util.Util;

public class RedPackReqData {

    private String nonce_str = "";
    private String sign = "";
    private String mch_billno = "";
    private String mch_id = "";
    private String wxappid = "";
    private String send_name = "";
    private String re_openid = "";
    private int total_amount = 0;
    private int total_num = 0;
    private String wishing = "";
    private String client_ip = "";
    private String act_name = "";
    private String remark = "";
    private String scene_id = "";
    private String risk_info = "";
    private String consume_mch_id = "";

    /**
     * 发送普通红包
     *
     * @param mch_billno   商户订单号（每个订单号必须唯一。取值范围：0~9，a~z，A~Z）接口根据商户订单号支持重入，如出现超时可再调用。
     * @param send_name    红包发送者名称
     * @param re_openid    接受红包的用户 用户在wxappid下的openid
     * @param total_amount 付款金额，单位分
     * @param wishing      红包祝福语
     * @param client_ip    调用接口的机器Ip地址
     * @param act_name     活动名称
     * @param remark       备注信息
     */
    public RedPackReqData(String mch_billno, String send_name, String re_openid, int total_amount,
                          String wishing, String client_ip, String act_name, String remark) {

        //微信分配的公众号ID（开通公众号之后可以获取到）
        setWxappid(Configure.getAppid());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(Configure.getMchid());

        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        setMch_billno(mch_billno);

        setSend_name(send_name);

        setRe_openid(re_openid);

        setTotal_amount(total_amount);

        setTotal_num(1);

        setWishing(wishing);

        setClient_ip(client_ip);

        setAct_name(act_name);

        setRemark(remark);

        build();
    }

    public RedPackReqData build() {
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

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getSend_name() {
        return send_name;
    }

    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

    public String getRe_openid() {
        return re_openid;
    }

    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getScene_id() {
        return scene_id;
    }

    public void setScene_id(String scene_id) {
        this.scene_id = scene_id;
    }

    public String getRisk_info() {
        return risk_info;
    }

    public void setRisk_info(String risk_info) {
        this.risk_info = risk_info;
    }

    public String getConsume_mch_id() {
        return consume_mch_id;
    }

    public void setConsume_mch_id(String consume_mch_id) {
        this.consume_mch_id = consume_mch_id;
    }
}
