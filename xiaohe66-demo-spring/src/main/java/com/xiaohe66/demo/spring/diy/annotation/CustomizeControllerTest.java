package com.xiaohe66.demo.spring.diy.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import javax.servlet.ServletException;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义注解使用示例
 *
 * @author xh
 * @date 2017/10/30
 */
@Configuration
public class CustomizeControllerTest {
    public static void main(String[] args) throws ServletException, IOException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        MockServletContext mockServletContext = new MockServletContext();
        MockServletConfig mockServletConfig = new MockServletConfig(mockServletContext);
        annotationConfigWebApplicationContext.setServletConfig(mockServletConfig);
        annotationConfigWebApplicationContext.register(CustomizeControllerTest.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
        dispatcherServlet.init(mockServletConfig);

        //模拟http请求
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/");
        request.addHeader("Accept","application/json");
        dispatcherServlet.service(request, response);
        System.out.println("response:\n"+response.getContentAsString());

        System.out.println("-----------------------------------------------");

        MockHttpServletResponse response2 = new MockHttpServletResponse();
        MockHttpServletRequest request2 = new MockHttpServletRequest("GET", "/test2");
        request.addHeader("Accept","application/json");
        dispatcherServlet.service(request2, response2);
        System.out.println("response:\n"+response2.getContentAsString());
    }

    @MyController
    public static class IndexController {

        @MyRequestMapping("/")
        @ResponseBody
        public String index() {
            System.out.println("request success!");

            return "result hello world";
        }

        @MyRequestMapping("/test2")
        @ResponseBody
        public String index2() {
            System.out.println("request success2!");

            return "result hello world2222";
        }

    }

    @Configuration
    public static class MyWebMvcConfigurationSupport extends WebMvcConfigurationSupport {

        @Bean
        //@Override
        public RequestMappingHandlerMapping requestMappingHandlerMapping() {
            MyRequestMappingHandlerMapping handlerMapping = new MyRequestMappingHandlerMapping();
            handlerMapping.setOrder(0);
            handlerMapping.setInterceptors(getInterceptors(null,null));
            handlerMapping.setContentNegotiationManager(mvcContentNegotiationManager());
            handlerMapping.setCorsConfigurations(getCorsConfigurations());

            PathMatchConfigurer configurer = getPathMatchConfigurer();
            if (configurer.isUseSuffixPatternMatch() != null) {
                handlerMapping.setUseSuffixPatternMatch(configurer.isUseSuffixPatternMatch());
            }
            if (configurer.isUseRegisteredSuffixPatternMatch() != null) {
                handlerMapping.setUseRegisteredSuffixPatternMatch(configurer.isUseRegisteredSuffixPatternMatch());
            }
            if (configurer.isUseTrailingSlashMatch() != null) {
                handlerMapping.setUseTrailingSlashMatch(configurer.isUseTrailingSlashMatch());
            }
            if (configurer.getPathMatcher() != null) {
                handlerMapping.setPathMatcher(configurer.getPathMatcher());
            }
            if (configurer.getUrlPathHelper() != null) {
                handlerMapping.setUrlPathHelper(configurer.getUrlPathHelper());
            }

            return handlerMapping;
        }

    }

    public static class MyRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

        @Override
        protected boolean isHandler(Class<?> beanType) {
            return ((AnnotationUtils.findAnnotation(beanType, MyController.class) != null) || (
                    AnnotationUtils.findAnnotation(beanType, MyRequestMapping.class) != null));
        }

        private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
            MyRequestMapping requestMapping = AnnotatedElementUtils
                    .findMergedAnnotation(element, MyRequestMapping.class);
            RequestCondition<?> condition = (element instanceof Class<?> ?
                    getCustomTypeCondition((Class<?>) element) :
                    getCustomMethodCondition((Method) element));
            if (requestMapping == null) {
                return null;
            }
            return RequestMappingInfo.paths(resolveEmbeddedValuesInPatterns(requestMapping.value()))
                    .methods(RequestMethod.GET).params(requestMapping.params()).headers(requestMapping.headers())
                    .consumes(requestMapping.consumes()).produces(requestMapping.produces())
                    .mappingName(requestMapping.name()).customCondition(condition).build();
        }

        @Override
        protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
            RequestMappingInfo info = createRequestMappingInfo(method);
            if (info != null) {
                RequestMappingInfo typeInfo = createRequestMappingInfo(handlerType);
                if (typeInfo != null) {
                    info = typeInfo.combine(info);
                }
            }
            return info;
        }

    }
}
