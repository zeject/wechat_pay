package com.wechat.protocol.unifiedorder;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSceneInfo {

    private Map<String, Map<String, String>> infoMap = new HashMap<String, Map<String, String>>();

    public BaseSceneInfo(String type) {
        Map<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("type", type);
        infoMap.put("h5_info", dataMap);
    }

    protected Map getDataMap() {
        return (Map) infoMap.get("h5_info");
    }

    public String toJson() {
        return JSON.toJSONString(infoMap);
    }

}
