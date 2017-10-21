package com.wechat.request;

import com.wechat.protocol.coupon.querycouponstock.QueryCouponStockReqData;
import com.wechat.protocol.coupon.querycouponstock.QueryCouponStockResData;
import com.wechat.service.QueryCouponStockService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class QueryCouponStockRequest {

    // 打log用
    private static Log logger = new Log(QueryCouponStockRequest.class);

    private QueryCouponStockService queryCouponStockService;

    public QueryCouponStockRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        queryCouponStockService = new QueryCouponStockService();
    }

    public QueryCouponStockResData run(QueryCouponStockReqData queryCouponStockReqData) throws Exception {
        // --------------------------------------------------------------------
        // 构造请求“查询代金券批次”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String queryCouponStockServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("发送普通红包API返回的数据如下：");
        queryCouponStockServiceResponseString = queryCouponStockService.request(queryCouponStockReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(queryCouponStockServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        QueryCouponStockResData queryCouponStockResData = (QueryCouponStockResData) Util.getObjectFromXML(queryCouponStockServiceResponseString,
                QueryCouponStockResData.class);
        return queryCouponStockResData;
    }

    public void setQueryCouponStockService(QueryCouponStockService queryCouponStockService) {
        this.queryCouponStockService = queryCouponStockService;
    }


}
