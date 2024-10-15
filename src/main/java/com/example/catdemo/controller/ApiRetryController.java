package com.example.catdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import java.lang.reflect.Method;
import java.util.Map;

@RestController
@RequestMapping("/ApiRetryController")
public class ApiRetryController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping("/retry")
    public String retryApi(String url) throws Exception {
        // 查找所有映射到控制器的方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            RequestMappingInfo mappingInfo = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();


            // 检查URL和方法是否匹配
            if (mappingInfo.getPathPatternsCondition().getPatterns().contains(url)) {
                Method methodToInvoke = handlerMethod.getMethod();
                Object controllerInstance = handlerMethod.getBean();
                Object result = methodToInvoke.invoke(controllerInstance);
                return result.toString();
            }
        }

        return "未找到对应的方法";
    }
}
