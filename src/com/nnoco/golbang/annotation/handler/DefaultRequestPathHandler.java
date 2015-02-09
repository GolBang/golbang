package com.nnoco.golbang.annotation.handler;

import java.lang.annotation.Annotation;

import com.nnoco.golbang.annotation.RequestPath;
import com.nnoco.golbang.request.RequestMessage;

public class DefaultRequestPathHandler implements
		ParamAnnotationHandler<RequestPath> {

	@Override
	public void handle(Annotation annotation, RequestMessage message, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
