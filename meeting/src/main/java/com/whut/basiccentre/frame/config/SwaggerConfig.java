package com.whut.basiccentre.frame.config;


import com.whut.basiccentre.frame.annotation.SwaggerDeprecated;
import com.whut.basiccentre.frame.annotation.SwaggerDeveloped;
import com.whut.basiccentre.frame.annotation.TestSwaggerDeveloped;
import com.whut.basiccentre.frame.interceptor.ClientSignValidateInterceptor;
import com.whut.basiccentre.frame.utils.Constants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kco1989
 * @email kco1989@qq.com
 * @date 2019-05-08 14:52
 */
@ConditionalOnProperty(name = "show-api-doc", havingValue = "true")
@Configuration
@ComponentScan(basePackages = {"com.whut.basiccentre.modules"})//配置controller路径
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket testDevelopedApi() {
        String desciption = "默认所有的接口都需要签名\n" +
                "- 签名规则\n" +
                "   1. 获取request body的内容\n" +
                "   2. 如果有loginToken,这加上,否则忽略\n" +
                "   3. user-agent公共参数必须还有当前请求的时间戳(key为timestamp),要参与签名\n" +
                "   4. 把上面的参数按字典值正序排序\n" +
                "   5. 然后使用key=value&方式拼接起来\n" +
                "   6. 再拼接的字符串后加上key=" + ClientSignValidateInterceptor.DEFAULT_SIGN_KEY + "\n" +
                "   7. 最后对拼接完成的字符串进行md5签名,然后以sign为key放在公共参数中\n" +
                "   8. [注意]参数值为空的话忽略\n" +
                "   9. 参考登陆接口的api文档说明\n";
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(TestSwaggerDeveloped.class))
                .build()
                .groupName("1.开发过程中后端用于测试自己的接口（不确保能联调成功）")
                .pathMapping("/")
                .apiInfo(apiInfo("开发过程中后端用于测试自己的接口（不确保能联调成功）", desciption, "1.0"))
                .securitySchemes(securitySchemes());
    }

    @Bean
    public Docket developedApi() {
        String desciption = "默认所有的接口都需要签名\n" +
                "- 签名规则\n" +
                "   1. 获取request body的内容\n" +
                "   2. 如果有loginToken,这加上,否则忽略\n" +
                "   3. user-agent公共参数必须还有当前请求的时间戳(key为timestamp),要参与签名\n" +
                "   4. 把上面的参数按字典值正序排序\n" +
                "   5. 然后使用key=value&方式拼接起来\n" +
                "   6. 再拼接的字符串后加上key=" + ClientSignValidateInterceptor.DEFAULT_SIGN_KEY + "\n" +
                "   7. 最后对拼接完成的字符串进行md5签名,然后以sign为key放在公共参数中\n" +
                "   8. [注意]参数值为空的话忽略\n" +
                "   9. 参考登陆接口的api文档说明\n";
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(SwaggerDeveloped.class))
                .build()
                .groupName("2. 开发完成的接口（可联调）")
                .pathMapping("/")
                .apiInfo(apiInfo("开发完成的接口（可联调）", desciption, "1.0"))
                .securitySchemes(securitySchemes());
    }

    @Bean
    public Docket deprectaedApi() {
        String desciption = "默认所有的接口都需要签名\n" +
                "- 签名规则\n" +
                "   1. 获取request body的内容\n" +
                "   2. 如果有loginToken,这加上,否则忽略\n" +
                "   3. user-agent公共参数必须还有当前请求的时间戳(key为timestamp),要参与签名\n" +
                "   4. 把上面的参数按字典值正序排序\n" +
                "   5. 然后使用key=value&方式拼接起来\n" +
                "   6. 再拼接的字符串后加上key=" + ClientSignValidateInterceptor.DEFAULT_SIGN_KEY + "\n" +
                "   7. 最后对拼接完成的字符串进行md5签名,然后以sign为key放在公共参数中\n" +
                "   8. [注意]参数值为空的话忽略\n" +
                "   9. 参考登陆接口的api文档说明\n";
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(SwaggerDeprecated.class))
                .build()
                .groupName("3. 过时的接口")
                .pathMapping("/")
                .apiInfo(apiInfo("过时的接口", desciption, "1.0"))
                .securitySchemes(securitySchemes());
    }

    @Bean
    public Docket allApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.whut.basiccentre.modules"))
                .build()
                .groupName("4. 所有接口")
                .pathMapping("/")
                .apiInfo(apiInfo("所有接口", "所有接口", "1.0"))
                .securitySchemes(securitySchemes());
    }


    /**
     * 安全模式，这里指定token通过Authorization头请求头传递
     */
    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey(Constants.LOGIN_TOKEN, Constants.LOGIN_TOKEN, "header"));
        apiKeyList.add(new ApiKey("app-info", "app-info", "header"));
        return apiKeyList;
    }

    private ApiInfo apiInfo(String name, String description, String version) {
        return new ApiInfoBuilder()
                .title(name)
                .description(description)
                .version(version).build();
    }
}
