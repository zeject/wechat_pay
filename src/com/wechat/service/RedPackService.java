package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.sendredpack.redpack.RedPackReqData;

public class RedPackService extends BaseService {

    public RedPackService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.SEND_READ_PACK_API);
    }

    /**
     * 发送普通红包服务
     *
     * @param redPackReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(RedPackReqData redPackReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(redPackReqData);

        return responseString;
    }
}
