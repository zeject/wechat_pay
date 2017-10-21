package com.wechat.request;

import com.wechat.protocol.transfers.promotion.PromotionTransfersReqData;
import com.wechat.protocol.transfers.promotion.PromotionTransfersResData;
import com.wechat.service.PromotionTransfersService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class PromotionTransfersRequest {

    // 打log用
    private static Log logger = new Log(PromotionTransfersRequest.class);

    private PromotionTransfersService promotionTransfersService;

    public PromotionTransfersRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        promotionTransfersService = new PromotionTransfersService();
    }

    public PromotionTransfersResData run(PromotionTransfersReqData promotionTransfersReqData) throws Exception {
// --------------------------------------------------------------------
        // 构造请求“企业付款API”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String promotionTransfersServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("企业付款API返回的数据如下：");
        promotionTransfersServiceResponseString = promotionTransfersService.request(promotionTransfersReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(promotionTransfersServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        PromotionTransfersResData promotionTransfersResData = (PromotionTransfersResData) Util.getObjectFromXML(promotionTransfersServiceResponseString,
                PromotionTransfersResData.class);
        return promotionTransfersResData;
    }

    public void setPromotionTransfersService(PromotionTransfersService promotionTransfersService) {
        this.promotionTransfersService = promotionTransfersService;
    }
}
