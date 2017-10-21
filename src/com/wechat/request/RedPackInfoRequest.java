package com.wechat.request;

import com.wechat.protocol.sendredpack.redpackinfo.RedPackInfoReqData;
import com.wechat.protocol.sendredpack.redpackinfo.RedPackInfoResData;
import com.wechat.service.RedPackInfoService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class RedPackInfoRequest {

    // 打log用
    private static Log logger = new Log(RedPackInfoRequest.class);

    private RedPackInfoService redPackInfoService;

    public RedPackInfoRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        redPackInfoService = new RedPackInfoService();
    }

    public RedPackInfoResData run(RedPackInfoReqData redPackInfoReqData) throws Exception {
        // --------------------------------------------------------------------
        // 构造请求“查询红包记录”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String redPackInfoServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("查询红包记录API返回的数据如下：");
        redPackInfoServiceResponseString = redPackInfoService.request(redPackInfoReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(redPackInfoServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        RedPackInfoResData redPackResInfoData = (RedPackInfoResData) Util.getObjectFromXML(redPackInfoServiceResponseString,
                RedPackInfoResData.class);
        return redPackResInfoData;
    }

    public void setRedPackInfoService(RedPackInfoService redPackInfoService) {
        this.redPackInfoService = redPackInfoService;
    }


}
