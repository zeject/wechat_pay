package com.wechat.config;

public class Configure {

    private static String key = "";

    /**
     * 微信分配的公众号ID（开通公众号之后可以获取到）
     */
    private static String appID = "";

    private static String appSecret = "";

    // 微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
    private static String mchID = "";

    // 受理模式下给子商户分配的子商户号
    private static String subMchID = "";

    // HTTPS证书的本地路径
    private static String certLocalPath = "";

    // HTTPS证书密码，默认密码等于商户号MCHID
    private static String certPassword = "";

    // 是否使用异步线程的方式来上报API测速，默认为异步模式
    private static boolean useThreadToDoReport = true;

    // 机器IP
    private static String ip = "";

    // 以下是几个API的路径：
    // access_token
    public static String ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?";
    // unionID
    public static String UNION_USER_INFO_API = "https://api.weixin.qq.com/cgi-bin/user/info?";

    // 获取code url
    public static String CODE_API = "https://open.weixin.qq.com/connect/oauth2/authorize?";

    public static String OPENID_API = "https://api.weixin.qq.com/sns/oauth2/access_token?";

    public static String REFRESH_TOKEN_API = "https://api.weixin.qq.com/sns/oauth2/refresh_token?";

    public static String USER_INFO_API = "https://api.weixin.qq.com/sns/userinfo?";

    public static String VERIFY_TOKEN_API = "https://api.weixin.qq.com/sns/auth?";

    /**
     * 统一下单url地址
     */
    public static String UNIFIED_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // 订单关闭
    public static String CLOSE_API = "https://api.mch.weixin.qq.com/pay/closeorder";

    // 1）被扫支付API
    public static String PAY_API = "https://api.mch.weixin.qq.com/pay/micropay";

    // 2）被扫支付查询API
    public static String PAY_QUERY_API = "https://api.mch.weixin.qq.com/pay/orderquery";

    // 3）退款API
    public static String REFUND_API = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    // 4）退款查询API
    public static String REFUND_QUERY_API = "https://api.mch.weixin.qq.com/pay/refundquery";

    // 5）撤销API
    public static String REVERSE_API = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

    // 6）下载对账单API
    public static String DOWNLOAD_BILL_API = "https://api.mch.weixin.qq.com/pay/downloadbill";

    // 7) 统计上报API
    public static String REPORT_API = "https://api.mch.weixin.qq.com/payitil/report";

    // 发送普通红包API
    public static String SEND_READ_PACK_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

    // 发送裂变红包API
    public static String SEND_GROUP_READ_PACK_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";

    // 查询红包记录API
    public static String GET_READ_PACK_INFO_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

    // 企业付款API
    public static String PROMOTION_TRANSFERS_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

    // 查询企业付款API
    public static String GET_PROMOTION_TRANSFERS_INFO_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

    // 发放代金券API
    public static String SEND_COUPON_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/send_coupon";

    // 查询代金券批次API
    public static String QUERY_COUPON_STOCK_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/query_coupon_stock";

    // 查询代金券信息API
    public static String QUERY_COUPONS_INFO_API = "https://api.mch.weixin.qq.com/mmpaymkttransfers/querycouponsinfo";

    public static boolean isUseThreadToDoReport() {
        return useThreadToDoReport;
    }

    public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
        Configure.useThreadToDoReport = useThreadToDoReport;
    }

    public static String HttpsRequestClassName = "com.wechat.util.HttpsRequest";

    public static void setKey(String key) {
        Configure.key = key;
    }

    public static void setAppID(String appID) {
        Configure.appID = appID;
    }

    public static void setMchID(String mchID) {
        Configure.mchID = mchID;
    }

    public static void setSubMchID(String subMchID) {
        Configure.subMchID = subMchID;
    }

    public static void setCertLocalPath(String certLocalPath) {
        Configure.certLocalPath = certLocalPath;
    }

    public static void setCertPassword(String certPassword) {
        Configure.certPassword = certPassword;
    }

    public static void setIp(String ip) {
        Configure.ip = ip;
    }

    public static String getKey() {
        return key;
    }

    public static String getAppid() {
        return appID;
    }

    public static String getMchid() {
        return mchID;
    }

    public static String getSubMchid() {
        return subMchID;
    }

    public static String getCertLocalPath() {
        return certLocalPath;
    }

    public static String getCertPassword() {
        return certPassword;
    }

    public static String getIP() {
        return ip;
    }

    public static void setHttpsRequestClassName(String name) {
        HttpsRequestClassName = name;
    }

    public static String getAppSecret() {
        return appSecret;
    }

    public static void setAppSecret(String appSecret) {
        Configure.appSecret = appSecret;
    }

}
