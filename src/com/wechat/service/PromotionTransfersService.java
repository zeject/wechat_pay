package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.transfers.promotion.PromotionTransfersReqData;


public class PromotionTransfersService extends BaseService {

    public PromotionTransfersService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.PROMOTION_TRANSFERS_API);
    }

    /**
     * 请求企业付款服务
     *
     * @param promotionTransfersReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(PromotionTransfersReqData promotionTransfersReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(promotionTransfersReqData);

        return responseString;
    }

}
