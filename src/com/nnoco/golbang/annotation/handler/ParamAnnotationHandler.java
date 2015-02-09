package com.nnoco.golbang.annotation.handler;

import java.lang.annotation.Annotation;

import com.nnoco.golbang.request.RequestMessage;

public interface ParamAnnotationHandler<T extends Annotation> {

	void handle(Annotation annotation, RequestMessage message, Object arg);

}
