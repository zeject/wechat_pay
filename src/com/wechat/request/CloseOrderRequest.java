package com.wechat.request;

import com.wechat.protocol.closeorder.CloseOrderReqData;
import com.wechat.protocol.closeorder.CloseOrderResData;
import com.wechat.service.CloseOrderService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class CloseOrderRequest {

    // 打log用
    private static Log log = new Log(CloseOrderRequest.class);

    private CloseOrderService closeOrderService;

    public CloseOrderRequest() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        closeOrderService = new CloseOrderService();
    }

    /**
     * 关闭订单操作
     *
     * @param outTradeNo 商户系统内部的订单号,32个字符内可包含字母, [确保在商户系统唯一]
     * @return 该订单是否支付成功
     * @throws Exception
     */
    public boolean run(String outTradeNo) throws Exception {

        String payQueryServiceResponseString;

        CloseOrderReqData closeOrderReqData = new CloseOrderReqData(outTradeNo);
        payQueryServiceResponseString = closeOrderService.request(closeOrderReqData);

        log.info("订单关闭API返回的数据如下：");
        log.info(payQueryServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        CloseOrderResData closeOrderResData = (CloseOrderResData) Util.getObjectFromXML(payQueryServiceResponseString,
                CloseOrderResData.class);
        if (closeOrderResData == null || closeOrderResData.getReturn_code() == null) {
            log.info("支付订单关闭请求逻辑错误，请仔细检测传过去的每一个参数是否合法");
            return false;
        }

        if (closeOrderResData.getReturn_code().equals("FAIL")) {
            // 注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.info("支付订单关闭API系统返回失败，失败信息为：" + closeOrderResData.getReturn_msg());
            return false;
        } else {
            if (closeOrderResData.getReturn_code().equals("SUCCESS")) {// 业务层成功
                // 表示查单结果为关闭成功
                log.info("订单关闭成功");
                return true;
            } else {
                log.info("关闭出错，错误码：" + closeOrderResData.getErr_code() + "     错误信息：" + closeOrderResData.getErr_code_des());
                return false;
            }
        }
    }

    public void setCloseOrderService(CloseOrderService closeOrderService) {
        this.closeOrderService = closeOrderService;
    }
}
