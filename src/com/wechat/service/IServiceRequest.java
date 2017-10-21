package com.wechat.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public interface IServiceRequest {

    //Service依赖的底层https请求器必须实现这么一个接口
    String sendPost(String api_url, Object xmlObj) throws UnrecoverableKeyException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException;

}
