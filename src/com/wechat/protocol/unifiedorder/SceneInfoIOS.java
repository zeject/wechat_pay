package com.wechat.protocol.unifiedorder;

import java.util.Map;

public class SceneInfoIOS extends BaseSceneInfo {

    // 应用名
    private String app_name = "";
    // bundle_id
    private String bundle_id = "";

    /**
     * @param app_name  应用名
     * @param bundle_id bundle_id
     */
    public SceneInfoIOS(String app_name, String bundle_id) {
        super("IOS");
        Map dataMap = getDataMap();
        dataMap.put("app_name", app_name);
        dataMap.put("bundle_id", bundle_id);
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getBundle_id() {
        return bundle_id;
    }

    public void setBundle_id(String bundle_id) {
        this.bundle_id = bundle_id;
    }
}
