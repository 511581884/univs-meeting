package com.whut.basiccentre.frame.enums;

import com.whut.basiccentre.frame.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title：agentApi2
 * @Description：短信验证码模板
 * @Author：zhangly
 * @Date：2019/5/13 11:36
 * @Version：1.0
 */
@AllArgsConstructor
@Getter
public enum SmsTemplate {

    //    SEEK_LOGIN_PWD("SEEK_LOGIN_PWD", "验证码：xxxxxx。您正在找回登录密码，验证码5分钟内有效", true, true, false),
    REGIST("REGIST", "586451", new String[]{"xxxxxx"}, true, true, false),

    VERIFY_RESULT("VERIFY_RESULT","738986",new String[]{"xxxxxx"},true,false,false);

    //模板编码
    private String code;
    //模板编码
    private String smsTemp;
    //模板内容
    private String[] context;
    //是否需要校验手机号合法性
    private boolean isCheckMobileNo;
    //是否需要生成6为随机数字验证码
    private boolean needVerifyCode;
    //模板内容是否有占位符，需要传递参数
    private boolean needParams;

    public static SmsTemplate getTemplateByCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            SmsTemplate[] values = SmsTemplate.values();
            for (SmsTemplate value : values) {
                if (code.equals(value.getCode())) {
                    return value;
                }
            }
        }
        return null;
    }
}