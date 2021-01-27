package com.whut.basiccentre.modules.utils.swagger;

/**
 * @author kco1989
 * @email kco1989@qq.com
 * @date 2019-05-13 10:52
 */
public final class UserSwaggerNotes {

    public static final String USRE_REGIST = "注册操作\n" +
            "- 请求参数\n" +
            "    - code: 短信验证码\n" +
            "    - imageCode: 图形码\n" +
            "    - mobilePhone: 手机号\n" +
            "    - uuid: 发送短信码时的uuid\n" +
            "    - province: 省名称\n" +
            "    - provinceCode: 省编码\n" +
            "    - city: 市名称\n" +
            "    - cityCode: 市市编码\n" +
            "    - district: 区\n" +
            "    - districtCode: 区编码\n" +
            "    - address: 详细地址\n" +
            "       - 公钥: MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJ9s1qlOyv9qpuaTqauW6fUftzE50rVk3yVPZwv1aO1Ch/XSEz76xCwkyvqpaqceRXrPpdBmO5+ruJ+I8osOHo7L5GWEOcMOO+8izp9hXKBBrmRMD4Egpn00k9DhVIEKp/vyddZPS/doxB8onhN6poTJDLdFLFVEicMf52caN9GQIDAQAB\n" +
            "    - agentOem: 代理商oem值\n" +
            "- 返回参数\n" +
            "    - userId 用户id\n" +
            "    - agentNo 代理商编号\n" +
            "    - manage 是否管理员:1管理员0销售员2.店员\n" +
            "    - loginToken 登陆token\n" +
            "       - **注意** 之后其他的所有接口必须上传参数LOGIN_TOKEN" +
            "       该参数可以放在请求参数(request param)中,或者请求头中,或者cookie中\n" +
            "- 例子\n" +
            "{\n" +
            "\"userName\": \"13888888888\",\n" +
            "\"agentOem\": \"200100\",\n" +
            "\"password\": \"fgaS0lu4Wp4Ra1UjOIdqvzlurWVXwVyHGpZItzwABQp20WHKaNc3dEn2JGu3q0qra0d8nxkt5xbNJobcQQg+XMrGV5/sbVbAHIM9nD+4EH816liIVUDaQAFO1epPvy9HPzp+9Gdtkgv4sRJ61tM9gtLJGQtF0Mzn8IfXd4dfJUM=\"\n" +
            "}\n\n" +
            "如果timestamp为1557993954511, 则签名参数为agentOem=200100&password=fgaS0lu4Wp4Ra1UjOIdqvzlurWVXwVyHGpZItzwABQp20WHKaNc3dEn2JGu3q0qra0d8nxkt5xbNJobcQQg+XMrGV5/sbVbAHIM9nD+4EH816liIVUDaQAFO1epPvy9HPzp+9Gdtkgv4sRJ61tM9gtLJGQtF0Mzn8IfXd4dfJUM=&timestamp=1557993954511&userName=13888888888&key=46940880d9f79f27bb7f85ca67102bfdylkj@@ysbAgentApi#$$^&pretty\n\n" +
            "md5之前签名值a16899c984018a1c3da7a71d9fca87e5,将该值放在公共参数中";

}