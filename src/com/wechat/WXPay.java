package com.wechat;


import com.wechat.config.Configure;

/**
 * SDK总入口
 */
public class WXPay {

    /**
     * 初始化SDK依赖的几个关键配置
     *
     * @param key           签名算法需要用到的秘钥
     * @param appID         公众账号ID
     * @param mchID         商户ID
     * @param sdbMchID      子商户ID，受理模式必填
     * @param certLocalPath HTTP证书在服务器中的路径，用来加载证书用
     * @param certPassword  HTTP证书的密码，默认等于MCHID
     */
    public static void initSDKConfiguration(String key, String appID, String appSecret, String mchID, String sdbMchID,
                                            String certLocalPath, String certPassword) {
        Configure.setKey(key);
        Configure.setAppID(appID);
        Configure.setAppSecret(appSecret);
        Configure.setMchID(mchID);
        Configure.setSubMchID(sdbMchID);
        Configure.setCertLocalPath(certLocalPath);
        Configure.setCertPassword(certPassword);
    }

}
