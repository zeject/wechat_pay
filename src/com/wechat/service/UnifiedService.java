package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.unifiedorder.UnifiedReqData;

public class UnifiedService extends BaseService {

    public UnifiedService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.UNIFIED_API);
    }

    /**
     * 请求支付服务
     *
     * @param unifiedReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的数据
     * @throws Exception
     */
    public String request(UnifiedReqData unifiedReqData) throws Exception {

        // --------------------------------------------------------------------
        // 发送HTTPS的Post请求到API地址
        // --------------------------------------------------------------------
        String responseString = sendPost(unifiedReqData);

        return responseString;
    }
}