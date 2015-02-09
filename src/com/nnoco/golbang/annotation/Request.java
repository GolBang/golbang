package com.nnoco.golbang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.nnoco.golbang.request.HttpMethod;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target(ElementType.METHOD)
public @interface Request {
	public HttpMethod method() default HttpMethod.GET;
	public String value() default "";
	public String[] header() default "";
	public String server() default "";
}
