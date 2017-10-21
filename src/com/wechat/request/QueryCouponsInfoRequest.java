package com.wechat.request;

import com.wechat.protocol.coupon.querycouponsinfo.QueryCouponsInfoReqData;
import com.wechat.protocol.coupon.querycouponsinfo.QueryCouponsInfoResData;
import com.wechat.service.QueryCouponsInfoService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class QueryCouponsInfoRequest {

    // 打log用
    private static Log logger = new Log(QueryCouponsInfoRequest.class);

    private QueryCouponsInfoService queryCouponsInfoService;

    public QueryCouponsInfoRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        queryCouponsInfoService = new QueryCouponsInfoService();
    }

    public QueryCouponsInfoResData run(QueryCouponsInfoReqData queryCouponsInfoReqData) throws Exception {
        // --------------------------------------------------------------------
        // 构造请求“查询代金券信息”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String queryCouponsInfoResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("发送普通红包API返回的数据如下：");
        queryCouponsInfoResponseString = queryCouponsInfoService.request(queryCouponsInfoReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(queryCouponsInfoResponseString);

        // 将从API返回的XML数据映射到Java对象
        QueryCouponsInfoResData queryCouponsInfoResData = (QueryCouponsInfoResData) Util.getObjectFromXML(queryCouponsInfoResponseString,
                QueryCouponsInfoResData.class);
        return queryCouponsInfoResData;
    }

    public void setQueryCouponsInfoService(QueryCouponsInfoService queryCouponsInfoService) {
        this.queryCouponsInfoService = queryCouponsInfoService;
    }


}
