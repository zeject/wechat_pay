package com.wechat.protocol.report.service;


import com.wechat.protocol.report.ReportReqData;

public class ReporterFactory {

    /**
     * 请求统计上报API
     *
     * @param reportReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return 返回一个Reporter
     */
    public static Reporter getReporter(ReportReqData reportReqData) {
        return new Reporter(reportReqData);
    }

}
