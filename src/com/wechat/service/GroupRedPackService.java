package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.sendredpack.groupredpack.GroupRedPackReqData;

public class GroupRedPackService extends BaseService {

    public GroupRedPackService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.SEND_GROUP_READ_PACK_API);
    }

    /**
     * 发送裂变红包服务
     *
     * @param groupRedPackReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(GroupRedPackReqData groupRedPackReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(groupRedPackReqData);

        return responseString;
    }
}
