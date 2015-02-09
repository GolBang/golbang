package com.nnoco.golbang.annotation.handler;

import java.lang.annotation.Annotation;

import com.nnoco.golbang.annotation.Header;
import com.nnoco.golbang.request.RequestMessage;

public class DefaultHeaderHandler implements ParamAnnotationHandler<Header> {

	@Override
	public void handle(Annotation annotation, RequestMessage message, Object arg) {
		Header header = (Header) annotation;
		
		String annotatedKey = header.value();
		
		System.out.println(arg.getClass());
	}

}
