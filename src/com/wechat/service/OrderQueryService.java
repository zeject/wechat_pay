package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.orderquery.OrderPayQueryReqData;

public class OrderQueryService extends BaseService {

    public OrderQueryService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.PAY_QUERY_API);
    }

    /**
     * 请求支付查询服务
     *
     * @param orderPayQueryReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(OrderPayQueryReqData orderPayQueryReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(orderPayQueryReqData);

        return responseString;
    }
}
