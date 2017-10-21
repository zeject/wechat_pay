# wechat_pay
微信支付

### 运行前请先设置你的参数
~~~
/**
 * 初始化SDK依赖的几个关键配置
 *
 * @param key           签名算法需要用到的秘钥
 * @param appID         公众账号ID
 * @param mchID         商户ID
 * @param sdbMchID      子商户ID，受理模式必填
 * @param certLocalPath HTTP证书在服务器中的路径，用来加载证书用
 * @param certPassword  HTTP证书的密码，默认等于MCHID
 */
public static void initSDKConfiguration(String key, String appID, String appSecret,
 String mchID, String sdbMchID,
 String certLocalPath, String certPassword)
~~~

#### 工具在com.wechat.request包
例如:统一下单
```
    UnifiedRequest request = new UnifiedRequest();

    UnifiedReqData unifiedReqData = new UnifiedReqData("body", "abcdefghijklmnopqrstuvwxyz012345",
            1, "188.66.88.123", "aaa").appendNative("1").build();
    UnifiedResData unifiedResData = request.run(unifiedReqData);
```

### 具体使用方法
1. 被扫支付 ScanPayRequest
1. 统一下单 UnifiedRequest
1. 关闭订单操作 CloseOrderRequest
1. 对账单下载 DownloadBillRequest
1. 支付API异步返回 NotifyRequest
1. 进行一次支付订单查询操作 OrderQueryRequest
1. 调用退款业务逻辑 RefundRequest
1. 企业付款查询 PromotionTransfersInfoRequest
1. 企业付款 PromotionTransfersRequest
1. 发放代金券 CouponRequest
1. 查询代金券信息 QueryCouponsInfoRequest
1. 查询代金券批次 QueryCouponStockRequest
1. 查询红包记录 RedPackInfoRequest
1. 发送普通红包 RedPackRequest
1. 发送裂变红包 GroupRedPackRequest


```
// 实例化请求
XxxRequest xxxPayRequest = new XxxRequest();
// 创建请求体
XxxReqData xxxReqData = new XxxReqData(params...);
// 得到返回数据
XxxResData xxxResData = xxxPayRequest.run(xxxReqData);
```