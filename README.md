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

```
// 实例化请求
XxxRequest xxxPayRequest = new XxxRequest();
// 创建请求体
XxxReqData xxxReqData = new XxxReqData(params...);
// 得到返回数据
XxxResData xxxResData = xxxPayRequest.run(xxxReqData);
```