package com.whut.basiccentre.frame.utils;

/**
 * @author kco1989
 * @email kco1989@qq.com
 * @date 2019-05-13 09:44
 */
public class Constants {
    /**
     * 登陆密码解密时需要的密钥
     */
    public static final String LOGIN_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAPWZ5xYEswHWydbcnTz08Yr/IgLJZHNeeF5S4gcPvnpL2D1dPRCp5HaXyTwv3jpWdNYubdCa2mRLfZzZ6N9qu9WfOS4mthnIZmK83aGzDP49HHCt6xHyf/w1A4n2G71dVREvbijBEogJCDmkPeWpFUvQwXFb4EkH8Fmf65JQVAwjAgMBAAECgYAW56OFiiqnoUBxqWGArddY/zJM0DtuBwFyyogJ4I4DGc+w6WEojK+h38YEtvIivq1mzC2xpr93WxL77dap/2pE8y1ss2OVN2aPHbSdkGMy/BDQn2USJbtr8CC1DIL1a7NPWWD8dN8yDf3lS0EILin38ZzLkepEyVQS27GigQREAQJBAP9Julqbmba5M4M0YAtsa0l0DCTszEijnPg3A4nychsKWPROovkZlNaksX9/W2rcE+3JmxDBIZI1TvlUCholZNMCQQD2SUIr7JG0CA2J7Hhl632JnSOFZ2wUhILxNjFt1h0TA+PuCoDYPQQRjZ00kCfDfqiod0jxvwp+ElJeBtqHqGlxAkAFDGAzCoCvrFnoblC36Rz2BuV2lXg0t4eTIQNg5vp6rmmz6xot8uOOmxMngk08f72lJid63VbcnVFCfPb2LWchAkEAzr20ZHbT4JKZ+tucPcIuwaQ9OzEUEy0hViat24vPIDU10o7SlbKyhaGhA4y3NG5QWgq4GubJggcTSYbrTtFaoQJBAOZNJRcTrm8AcTv0SBoo8REYXI+CjiwXwVTEJrAxx2Sc4t7zxsYBJTSTrRH9F1bQPEgwtDUnFRrhizZsNrBflOc=";
    public static final String LOGIN_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD1mecWBLMB1snW3J089PGK/yICyWRzXnheUuIHD756S9g9XT0QqeR2l8k8L946VnTWLm3QmtpkS32c2ejfarvVnzkuJrYZyGZivN2hswz+PRxwresR8n/8NQOJ9hu9XVURL24owRKICQg5pD3lqRVL0MFxW+BJB/BZn+uSUFQMIwIDAQAB";
    /**
     * 用于存放loginToken的参数名
     */
    public static final String LOGIN_TOKEN = "LOGIN_TOKEN";
    /**
     * redis key 的前缀
     */
    public static final String REDIS_KEY_PREFIX = "basiccentreapi";

    public static final String CAPTCHA_REDIS_KEY_PREFIX = "CAPTCHA_REDIS_KEY_";

    public static final String TEAM_ID_999 = "999";

    /*阿里云存储boss附件bucket*/
    public static final String ALIYUN_OSS_ATTCH_TUCKET = "agent-attch";

    /*阿里云存储boss附件临时bucket*/
    public static final String ALIYUN_OSS_TEMP_TUCKET = "boss-temp";



    /**
     * 用户登陆相关的redis key
     * occamapi:userInfo:loginToken = 用户信息
     */
    public static final String REDIS_LOGIN_TOKEN_KEY = REDIS_KEY_PREFIX + ":loginToken:%s";


    /**
     * 登陆loginToken的存活时间
     */
    public static final String SYS_CONFIG_LOGIN_TOKEN_TTL = "basiccentreapi_login_token_ttl";

    public static final String TASK_HMAC_KEY = "YFBTASKMGR20180422" ;
    /**
     * 手机号当日发送验证码超过制定条数时需要发送图形验证码
     */
    public static final int NEED_IMAGE_CODE_SENDING_NUM = 2;
}
