package com.mybatis.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.mybatis.core.ServiceException;
import com.mybatis.domain.JsonResult;
import com.mybatis.service.impl.UserServiceImpl;

/**
 * 自定义消息转换器
 * 
 * @author BrokenColor
 * @date 2018年6月14日
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebConfigurer.class);
	/**
	 * 修改自定义消息转换器
	 */
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		// super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
		converter.setSupportedMediaTypes(getSupportedMediaTypes());
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(
				// string null->""
				SerializerFeature.WriteNullStringAsEmpty,
				// number null-> 0
				SerializerFeature.WriteNullNumberAsZero,
				// bollean null->false
				SerializerFeature.WriteNullBooleanAsFalse,
				// 禁止循环引用
				SerializerFeature.DisableCircularReferenceDetect);
		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(converter);
	}

	// A subclass of MimeType that adds support for quality parameters as defined in
	// the HTTP specification.
	private List<MediaType> getSupportedMediaTypes() {
		List<MediaType> supproteMeidaTypes = new ArrayList<>();
		supproteMeidaTypes.add(MediaType.APPLICATION_JSON);
		supproteMeidaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supproteMeidaTypes.add(MediaType.APPLICATION_ATOM_XML);
		supproteMeidaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		supproteMeidaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
		supproteMeidaTypes.add(MediaType.APPLICATION_PDF);
		supproteMeidaTypes.add(MediaType.APPLICATION_RSS_XML);
		supproteMeidaTypes.add(MediaType.APPLICATION_XHTML_XML);
		supproteMeidaTypes.add(MediaType.APPLICATION_XML);
		supproteMeidaTypes.add(MediaType.IMAGE_GIF);
		supproteMeidaTypes.add(MediaType.IMAGE_JPEG);
		supproteMeidaTypes.add(MediaType.IMAGE_PNG);
		supproteMeidaTypes.add(MediaType.TEXT_EVENT_STREAM);
		supproteMeidaTypes.add(MediaType.TEXT_HTML);
		supproteMeidaTypes.add(MediaType.TEXT_MARKDOWN);
		supproteMeidaTypes.add(MediaType.TEXT_XML);
		supproteMeidaTypes.add(MediaType.TEXT_PLAIN);
		return supproteMeidaTypes;
	}

	// Spring Boot自动配置本身不会自动把/swagger-ui.html这个路径映射到对应的目录META-INF/resources/下面。
	//我们加上这个映射即可。
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/META-INF/resources/favicon.ico");
		super.addResourceHandlers(registry);

	}
	
//	@Override
//	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//		// TODO Auto-generated method stub
////		super.configureHandlerExceptionResolvers(exceptionResolvers);
//		exceptionResolvers.add(getHandlerExceptionResolver());
//	}
//	//创建异常处理
//	private HandlerExceptionResolver getHandlerExceptionResolver() {
//		HandlerExceptionResolver exceptionResolver = new HandlerExceptionResolver() {
//			
//			@Override
//			public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handle,
//					Exception e) {
//				// TODO Auto-generated method stub
//				JsonResult result = getJsonResultByHeandleException(request, handle, e);
//				responseResult(response, result);
//				return new ModelAndView();
//			}
//		}; 
//		return exceptionResolver;
//	}
//	//根据异常类型确定返回数据
//	private JsonResult getJsonResultByHeandleException(HttpServletRequest request,Object handler,Exception e) {
//		JsonResult result = new JsonResult();
//		if (handler instanceof ServiceException) {
//			result.setStatus(e.getMessage());
//			result.setResult(null);
//			return result;
//		}else if (e instanceof NoHandlerFoundException) {
//			result.setStatus("接口["+request.getRequestURI()+"]不存在");
//			return result;
//		}
//		result.setStatus("接口["+request.getRequestURI()+"]内部错误");
//		String message;
//		if (handler instanceof HandlerMethod) {
//			HandlerMethod handlerMethod = (HandlerMethod) handler;
//			message = String.format("接口[%s]出现异常，方法%s.%s，异常：%s", request.getRequestURI(),
//					handlerMethod.getBean().getClass().getName(),handlerMethod.getMethod().getName(),e.getMessage());
//		}else {
//			message= e.getMessage();
//		}
//		LOGGER.error(message);
//		return result;
//	}
//	
//	private void responseResult(HttpServletResponse response,JsonResult jsonResult) {
//		response.setCharacterEncoding("UTF-8");
//		response.setHeader("content-type", "application/json;charset=UTF-8");
//		response.setStatus(200);
//		try {
//			response.getWriter().write(JSON.toJSONString(jsonResult,SerializerFeature.WriteMapNullValue));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}