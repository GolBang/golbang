package com.nnoco.golbang.annotation.handler;

import java.lang.annotation.Annotation;

import com.nnoco.golbang.annotation.RequestBody;
import com.nnoco.golbang.request.RequestMessage;

public class DefaultRequestBodyHandler implements
		ParamAnnotationHandler<RequestBody> {

	@Override
	public void handle(Annotation annotation, RequestMessage message, Object arg) {
		RequestBody requestBody = (RequestBody)annotation;
		System.out.println(arg);
		
	}

}
