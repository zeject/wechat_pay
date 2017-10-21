package com.wechat.request;

import com.wechat.protocol.notify.NotifyResData;
import com.wechat.service.NotifyService;
import com.wechat.util.Log;
import com.wechat.util.Util;

import java.io.IOException;
import java.io.InputStream;

public class NotifyRequest {
    public NotifyRequest() {
        successService = new NotifyService();
    }

    // 打log用
    private static Log log = new Log(NotifyRequest.class);

    private NotifyService successService;

    public NotifyResData run(InputStream is) throws IOException {
        String successServiceResponseString;
        long costTimeStart = System.currentTimeMillis();

        log.info("支付API返回的数据如下：");
        successServiceResponseString = successService.request(is);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        log.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        log.info(successServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        NotifyResData successResData = (NotifyResData) Util.getObjectFromXML(successServiceResponseString,
                NotifyResData.class);
        return successResData;
    }

    public void setNotifyService(NotifyService successService) {
        this.successService = successService;
    }

}
