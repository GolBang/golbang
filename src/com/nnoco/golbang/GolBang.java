package com.nnoco.golbang;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.nnoco.golbang.annotation.Header;
import com.nnoco.golbang.annotation.PathVariable;
import com.nnoco.golbang.annotation.QueryString;
import com.nnoco.golbang.annotation.RequestBody;
import com.nnoco.golbang.annotation.RequestPath;
import com.nnoco.golbang.annotation.handler.DefaultHeaderHandler;
import com.nnoco.golbang.annotation.handler.DefaultPathVariableHandler;
import com.nnoco.golbang.annotation.handler.DefaultQueryStringHandler;
import com.nnoco.golbang.annotation.handler.DefaultRequestBodyHandler;
import com.nnoco.golbang.annotation.handler.DefaultRequestPathHandler;
import com.nnoco.golbang.annotation.handler.ParamAnnotationHandler;

public class GolBang {
	private Map<Class<? extends Annotation>, ParamAnnotationHandler<? extends Annotation>> paramAnnotationHandlers;
	
	private GolBang() {
		paramAnnotationHandlers = new HashMap<Class<? extends Annotation>, ParamAnnotationHandler<? extends Annotation>>();
		
		initParamHandlers();
	}
	

	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(GolBang.class.getClassLoader(),
				new Class<?>[]{clazz}, new RequestInvocationHandler(SingletonHolder.golbang));
	}
	
	ParamAnnotationHandler<? extends Annotation> getHandler(Class<? extends Annotation> type) {
		return paramAnnotationHandlers.get(type);
	}
	
	private static class SingletonHolder {
		static GolBang golbang = new GolBang();
	}
	
	/*default*/ static GolBang getInstance() {
		return SingletonHolder.golbang;
	}
	
	public void setParamAnnoatationHandler(Class<? extends Annotation> type, ParamAnnotationHandler<? extends Annotation> handler) {
		paramAnnotationHandlers.put(type, handler);
	}
	
	private void initParamHandlers() {
		setParamAnnoatationHandler(Header.class, new DefaultHeaderHandler());
		setParamAnnoatationHandler(RequestBody.class, new DefaultRequestBodyHandler());
		setParamAnnoatationHandler(RequestPath.class, new DefaultRequestPathHandler());
		setParamAnnoatationHandler(QueryString.class, new DefaultQueryStringHandler());
		setParamAnnoatationHandler(PathVariable.class, new DefaultPathVariableHandler());
		
	}
}
