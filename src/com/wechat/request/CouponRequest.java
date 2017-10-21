package com.wechat.request;

import com.wechat.protocol.coupon.CouponReqData;
import com.wechat.protocol.coupon.CouponResData;
import com.wechat.service.CouponService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class CouponRequest {

    // 打log用
    private static Log logger = new Log(CouponRequest.class);

    private CouponService couponService;

    public CouponRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        couponService = new CouponService();
    }

    public CouponResData run(CouponReqData couponReqData) throws Exception {
        // --------------------------------------------------------------------
        // 构造请求“发放代金券”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String couponServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("发送普通红包API返回的数据如下：");
        couponServiceResponseString = couponService.request(couponReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(couponServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        CouponResData couponResData = (CouponResData) Util.getObjectFromXML(couponServiceResponseString,
                CouponResData.class);
        return couponResData;
    }

    public void setCouponService(CouponService couponService) {
        this.couponService = couponService;
    }


}
