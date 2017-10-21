package com.wechat.service;

import com.wechat.util.Util;

import java.io.IOException;
import java.io.InputStream;

public class NotifyService {

    public String request(InputStream is) throws IOException {
        String responseString = Util.inputStreamToString(is);
        return responseString;
    }

}
