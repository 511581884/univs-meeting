package com.whut.basiccentre.modules.controller;

import com.whut.basiccentre.frame.annotation.LoginValid;
import com.whut.basiccentre.frame.annotation.TestSwaggerDeveloped;
import com.whut.basiccentre.frame.bean.ResponseBean;
import com.whut.basiccentre.frame.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ysw
 * @email 1461182123@qq.com
 * @date 2020/11/19 1:40 下午
 * @description
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试模块")
@Slf4j
@Profile({"dev","test"})
public class TestController {

    @TestSwaggerDeveloped
    @ApiOperation(value = "加密")
    @GetMapping("/encrypt")
    @LoginValid(needLogin = false)
    public ResponseBean encrypt(String toEncryptStr, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date createdTime) {
        return ResponseBean.success();
//        return StringUtil.isNotBlank(String.valueOf(createdTime))
//                ? ResponseBean.success(EncryptUtil.encrypt(toEncryptStr, createdTime))
//                : ResponseBean.success(EncryptUtil.encrypt(toEncryptStr));
    }

    @TestSwaggerDeveloped
    @ApiOperation(value = "解密")
    @GetMapping("/decrypt")
    @LoginValid(needLogin = false)
    public ResponseBean decrypt(String toDecryptStr, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date createdTime) {
//        SysSecretService sysSecretService = SpringHolder.getBean(SysSecretService.class);
//        String secret = sysSecretService.list(new SysSecretQueryParam()).stream()
//                .filter(sysSecret -> {
//                    try {
//                        EncryptUtil.decrypt(toDecryptStr, sysSecret.getSecret());
//                        return true;
//                    } catch (Exception e) {
//                        return false;
//                    }
//                })
//                .collect(Collectors.toList())
//                .get(0).getSecret();
//        return ResponseBean.success(EncryptUtil.decrypt(toDecryptStr, secret));

        return StringUtil.isNotBlank(String.valueOf(createdTime))
                ? ResponseBean.success()
                : ResponseBean.success();
    }

}
