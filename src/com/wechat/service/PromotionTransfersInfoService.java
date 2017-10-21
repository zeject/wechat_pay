package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.transfers.transferinfo.PromotionTransfersInfoReqData;


public class PromotionTransfersInfoService extends BaseService {

    public PromotionTransfersInfoService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.GET_PROMOTION_TRANSFERS_INFO_API);
    }

    /**
     * 请求企业付款查询服务
     *
     * @param promotionTransfersInfoReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(PromotionTransfersInfoReqData promotionTransfersInfoReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(promotionTransfersInfoReqData);

        return responseString;
    }

}
