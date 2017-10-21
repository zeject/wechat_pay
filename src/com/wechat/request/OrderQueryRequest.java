package com.wechat.request;

import com.wechat.protocol.orderquery.OrderPayQueryReqData;
import com.wechat.protocol.orderquery.OrderPayQueryResData;
import com.wechat.service.OrderQueryService;
import com.wechat.util.Log;
import com.wechat.util.Util;

public class OrderQueryRequest {

    public OrderQueryRequest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        orderQueryService = new OrderQueryService();
    }

    // 打log用
    private static Log log = new Log(OrderQueryRequest.class);

    private OrderQueryService orderQueryService;

    /**
     * 进行一次支付订单查询操作
     *
     * @param outTradeNo 商户系统内部的订单号,32个字符内可包含字母, [确保在商户系统唯一]
     * @return 该订单是否支付成功
     * @throws Exception
     */
    public boolean run(String outTradeNo) throws Exception {

        String payQueryServiceResponseString;

        OrderPayQueryReqData orderPayQueryReqData = new OrderPayQueryReqData("", outTradeNo);
        payQueryServiceResponseString = orderQueryService.request(orderPayQueryReqData);

        log.info("支付订单查询API返回的数据如下：");
        log.info(payQueryServiceResponseString);

        // 将从API返回的XML数据映射到Java对象
        OrderPayQueryResData orderPayQueryResData = (OrderPayQueryResData) Util
                .getObjectFromXML(payQueryServiceResponseString, OrderPayQueryResData.class);
        if (orderPayQueryResData == null || orderPayQueryResData.getReturn_code() == null) {
            log.info("支付订单查询请求逻辑错误，请仔细检测传过去的每一个参数是否合法");
            return false;
        }

        if (orderPayQueryResData.getReturn_code().equals("FAIL")) {
            // 注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
            log.info("支付订单查询API系统返回失败，失败信息为：" + orderPayQueryResData.getReturn_msg());
            return false;
        } else {
            if (orderPayQueryResData.getResult_code().equals("SUCCESS")) {// 业务层成功
                if (orderPayQueryResData.getTrade_state().equals("SUCCESS")) {
                    // 表示查单结果为“支付成功”
                    log.info("查询到订单支付成功");
                    return true;
                } else {
                    // 支付不成功
                    log.info("查询到订单支付不成功");
                    return false;
                }
            } else {
                log.info("查询出错，错误码：" + orderPayQueryResData.getErr_code() + "     错误信息："
                        + orderPayQueryResData.getErr_code_des());
                return false;
            }
        }
    }

    public void setOrderQueryService(OrderQueryService orderQueryService) {
        this.orderQueryService = orderQueryService;
    }

}
