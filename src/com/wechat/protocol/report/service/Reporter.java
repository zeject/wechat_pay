package com.wechat.protocol.report.service;


import com.wechat.protocol.report.ReportReqData;
import com.wechat.service.ReportService;

public class Reporter {

    private ReportRunable r;
    private Thread t;
    private ReportService rs;

    /**
     * 请求统计上报API
     *
     * @param reportReqData 这个数据对象里面包含了API要求提交的各种数据字段
     */
    public Reporter(ReportReqData reportReqData) {
        rs = new ReportService(reportReqData);
    }

    public void run() {
        r = new ReportRunable(rs);
        t = new Thread(r);
        t.setDaemon(true);  //后台线程
        t.start();
    }
}
