package com.wechat.protocol.report.service;

import com.wechat.service.ReportService;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


public class ReportRunable implements Runnable {

    private ReportService reportService;

    ReportRunable(ReportService rs) {
        reportService = rs;
    }

    @Override
    public void run() {
        try {
            reportService.request();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
