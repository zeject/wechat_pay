package com.wechat.request;

import com.wechat.protocol.transfers.transferinfo.PromotionTransfersInfoReqData;
import com.wechat.protocol.transfers.transferinfo.PromotionTransfersInfoResData;
import com.wechat.service.PromotionTransfersInfoService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class PromotionTransfersInfoRequest {

    // 打log用
    private static Log logger = new Log(PromotionTransfersInfoRequest.class);

    private PromotionTransfersInfoService promotionTransfersInfoService;

    public PromotionTransfersInfoRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        promotionTransfersInfoService = new PromotionTransfersInfoService();
    }

    public PromotionTransfersInfoResData run(PromotionTransfersInfoReqData promotionTransfersInfoReqData) throws Exception {
// --------------------------------------------------------------------
        // 构造请求“企业付款查询”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String promotionTransfersInfoServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("企业付款查询API返回的数据如下：");
        promotionTransfersInfoServiceResponseString = promotionTransfersInfoService.request(promotionTransfersInfoReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(promotionTransfersInfoServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        PromotionTransfersInfoResData promotionTransfersResData = (PromotionTransfersInfoResData) Util.getObjectFromXML(promotionTransfersInfoServiceResponseString,
                PromotionTransfersInfoResData.class);
        return promotionTransfersResData;
    }

    public void setPromotionTransfersInfoService(PromotionTransfersInfoService promotionTransfersInfoService) {
        this.promotionTransfersInfoService = promotionTransfersInfoService;
    }
}
