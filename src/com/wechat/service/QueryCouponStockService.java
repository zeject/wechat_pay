package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.coupon.querycouponstock.QueryCouponStockReqData;

public class QueryCouponStockService extends BaseService {

    public QueryCouponStockService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.QUERY_COUPON_STOCK_API);
    }

    /**
     * 查询代金券批次
     *
     * @return API返回的数据
     * @throws Exception
     */
    public String request(QueryCouponStockReqData queryCouponStockReqData) throws Exception {

        // --------------------------------------------------------------------
        // 发送HTTPS的Post请求到API地址
        // --------------------------------------------------------------------
        String responseString = sendPost(queryCouponStockReqData);

        return responseString;
    }
}
