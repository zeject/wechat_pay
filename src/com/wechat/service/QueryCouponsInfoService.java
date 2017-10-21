package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.coupon.querycouponsinfo.QueryCouponsInfoReqData;

public class QueryCouponsInfoService extends BaseService {

    public QueryCouponsInfoService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.QUERY_COUPONS_INFO_API);
    }

    /**
     * 查询代金券信息
     *
     * @return API返回的数据
     * @throws Exception
     */
    public String request(QueryCouponsInfoReqData queryCouponsInfoReqData) throws Exception {

        // --------------------------------------------------------------------
        // 发送HTTPS的Post请求到API地址
        // --------------------------------------------------------------------
        String responseString = sendPost(queryCouponsInfoReqData);

        return responseString;
    }
}
