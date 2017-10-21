package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.coupon.CouponReqData;

public class CouponService extends BaseService {

    public CouponService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.SEND_COUPON_API);
    }

    /**
     * 发放代金券
     *
     * @return API返回的数据
     * @throws Exception
     */
    public String request(CouponReqData couponReqData) throws Exception {

        // --------------------------------------------------------------------
        // 发送HTTPS的Post请求到API地址
        // --------------------------------------------------------------------
        String responseString = sendPost(couponReqData);

        return responseString;
    }
}
