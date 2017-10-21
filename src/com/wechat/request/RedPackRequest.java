package com.wechat.request;

import com.wechat.protocol.sendredpack.redpack.RedPackReqData;
import com.wechat.protocol.sendredpack.redpack.RedPackResData;
import com.wechat.service.RedPackService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class RedPackRequest {

    // 打log用
    private static Log logger = new Log(RedPackRequest.class);

    private RedPackService redPackService;

    public RedPackRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        redPackService = new RedPackService();
    }

    public RedPackResData run(RedPackReqData redPackReqData) throws Exception {
        // --------------------------------------------------------------------
        // 构造请求“发送普通红包”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String redPackServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("发送普通红包API返回的数据如下：");
        redPackServiceResponseString = redPackService.request(redPackReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(redPackServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        RedPackResData redPackResData = (RedPackResData) Util.getObjectFromXML(redPackServiceResponseString,
                RedPackResData.class);
        return redPackResData;
    }

    public void setRedPackService(RedPackService redPackService) {
        this.redPackService = redPackService;
    }


}
