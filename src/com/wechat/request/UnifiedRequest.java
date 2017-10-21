package com.wechat.request;

import com.wechat.protocol.unifiedorder.UnifiedReqData;
import com.wechat.protocol.unifiedorder.UnifiedResData;
import com.wechat.service.UnifiedService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class UnifiedRequest {
    public UnifiedRequest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        unifiedService = new UnifiedService();
    }

    // 打log用
    private static Log logger = new Log(UnifiedRequest.class);

    private UnifiedService unifiedService;

    public UnifiedResData run(UnifiedReqData unifiedReqData) throws Exception {
        // --------------------------------------------------------------------
        // 构造请求“被扫支付API”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String payServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("支付API返回的数据如下：");
        payServiceResponseString = unifiedService.request(unifiedReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(payServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        UnifiedResData unifiedResData = (UnifiedResData) Util.getObjectFromXML(payServiceResponseString,
                UnifiedResData.class);
        return unifiedResData;
    }

    public void setUnifiedService(UnifiedService unifiedService) {
        this.unifiedService = unifiedService;
    }

}