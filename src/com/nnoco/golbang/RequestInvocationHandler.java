package com.nnoco.golbang;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.nnoco.golbang.annotation.Config;
import com.nnoco.golbang.annotation.Request;
import com.nnoco.golbang.annotation.handler.ParamAnnotationHandler;
import com.nnoco.golbang.request.HttpMethod;
import com.nnoco.golbang.request.RequestMessage;

public class RequestInvocationHandler implements InvocationHandler{
	private GolBang golBang;

	public RequestInvocationHandler(GolBang golBang) {
		this.golBang = golBang;
	}
	// TODO Builder 패턴 적용
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		RequestMessage message = new RequestMessage();
		
		// 클래스 Config 가져오기
		// TODO 클래스 Config의 경우 동일하게 사용하는 템플릿이 되므로 Base Request Message를 만들어 Clone하여 사용
		Class<?> clazz = method.getDeclaringClass();
		System.out.println(clazz.getName());
		Config config = clazz.getAnnotation(Config.class);
		
		if(null == config) throw new NoConfigException();
		
		String[] configHeaders = config.header();
		String server = config.server();
		
		for(String h : configHeaders) {
			System.out.println("Header: " + h);
		}
		System.out.println("Server: " + server);
		
		// Method Request 가져오기
		Request request = method.getAnnotation(Request.class);
		String[] headers = request.header();
		HttpMethod httpMethod = request.method();
		String overridedServer = request.server();
		String path = request.value();
		
		System.out.println("Request Headers:");
		for(String h : headers) {
			System.out.println(h);
		}
		
		System.out.println("Http Method: " + httpMethod.name());
		
		System.out.println("Overrided Server: " + overridedServer);
		
		System.out.println("Path: " + path);
		
		// 파라미터 가져오기
		Annotation[][] annotations = method.getParameterAnnotations();
		// 어노테이션에 따라서 인터페이스의 메서드 호출.
		// if(QueryString.class = annotations[i][n].getClass()) QueryStringHandler.handle(...)
		
		for(int i = 0 ; i < annotations.length ; i++) {
			for(int j=0; j < annotations[i].length ; j++) {
				paramHandle(annotations[i][j], args[i], message);
			}
		}
		
		return null;
	}
	
	private void paramHandle(Annotation annotation, Object arg, RequestMessage message) {
		Class<? extends Annotation> type = annotation.annotationType();
		
		System.out.println(type);
		ParamAnnotationHandler<? extends Annotation> handler = golBang.getHandler(type);
		
		if(null == handler) throw new NoParamAnnotationHandlerException();
		
		handler.handle(annotation, message, arg);
	}

}
