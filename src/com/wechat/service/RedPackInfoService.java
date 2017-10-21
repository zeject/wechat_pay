package com.wechat.service;

import com.wechat.config.Configure;
import com.wechat.protocol.sendredpack.redpackinfo.RedPackInfoReqData;

public class RedPackInfoService extends BaseService {

    public RedPackInfoService() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(Configure.GET_READ_PACK_INFO_API);
    }

    /**
     * 查询红包记录服务
     *
     * @param redPackInfoReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(RedPackInfoReqData redPackInfoReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(redPackInfoReqData);

        return responseString;
    }
}
