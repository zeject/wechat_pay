package com.wechat.request;

import com.wechat.protocol.sendredpack.groupredpack.GroupRedPackReqData;
import com.wechat.protocol.sendredpack.groupredpack.GroupRedPackResData;
import com.wechat.service.GroupRedPackService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class GroupRedPackRequest {

    // 打log用
    private static Log logger = new Log(GroupRedPackRequest.class);

    private GroupRedPackService groupRedPackService;

    public GroupRedPackRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        groupRedPackService = new GroupRedPackService();
    }

    public GroupRedPackResData run(GroupRedPackReqData groupRedPackReqData) throws Exception {
        // --------------------------------------------------------------------
        // 构造请求“发送裂变红包”所需要提交的数据
        // --------------------------------------------------------------------
        // 接受API返回
        String groupRedPackServiceResponseString;

        long costTimeStart = System.currentTimeMillis();

        logger.info("发送裂变红包API返回的数据如下：");
        groupRedPackServiceResponseString = groupRedPackService.request(groupRedPackReqData);

        long costTimeEnd = System.currentTimeMillis();
        long totalTimeCost = costTimeEnd - costTimeStart;
        logger.info("api请求总耗时：" + totalTimeCost + "ms");

        // 打印回包数据
        logger.info(groupRedPackServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        GroupRedPackResData groupRedPackResData = (GroupRedPackResData) Util.getObjectFromXML(groupRedPackServiceResponseString,
                GroupRedPackResData.class);
        return groupRedPackResData;
    }

    public void setGroupRedPackService(GroupRedPackService groupRedPackService) {
        this.groupRedPackService = groupRedPackService;
    }


}
