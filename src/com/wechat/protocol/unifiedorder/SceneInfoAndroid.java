package com.wechat.protocol.unifiedorder;

import java.util.Map;

public class SceneInfoAndroid extends BaseSceneInfo {

    // 应用名
    private String app_name = "";
    // 包名
    private String package_name = "";

    /**
     * @param app_name     应用名
     * @param package_name 包名
     */
    public SceneInfoAndroid(String app_name, String package_name) {
        super("Android");
        Map dataMap = getDataMap();
        dataMap.put("app_name", app_name);
        dataMap.put("package_name", package_name);
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }
}
