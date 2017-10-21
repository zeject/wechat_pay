package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.closeorder.CloseOrderReqData;

public class CloseOrderService extends BaseService {

    public CloseOrderService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.CLOSE_API);
    }

    /**
     * 请求支付服务
     *
     * @return API返回的数据
     * @throws Exception
     */
    public String request(CloseOrderReqData closeOrderReqData) throws Exception {

        // --------------------------------------------------------------------
        // 发送HTTPS的Post请求到API地址
        // --------------------------------------------------------------------
        String responseString = sendPost(closeOrderReqData);

        return responseString;
    }
}
