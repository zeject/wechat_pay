package com.wechat.protocol.unifiedorder;

import java.util.Map;

public class SceneInfoWap extends BaseSceneInfo {

    private String wap_url = "";

    private String wap_name = "";

    /**
     * @param wap_url  WAP网站URL地址
     * @param wap_name WAP 网站名
     */
    public SceneInfoWap(String wap_url, String wap_name) {
        super("Wap");
        Map dataMap = getDataMap();
        dataMap.put("wap_url", wap_url);
        dataMap.put("wap_name", wap_name);
    }

    public String getWap_url() {
        return wap_url;
    }

    public void setWap_url(String wap_url) {
        this.wap_url = wap_url;
    }

    public String getWap_name() {
        return wap_name;
    }

    public void setWap_name(String wap_name) {
        this.wap_name = wap_name;
    }
}
