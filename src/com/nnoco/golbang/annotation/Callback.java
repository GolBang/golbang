package com.nnoco.golbang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target(ElementType.PARAMETER)
public @interface Callback {
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@Documented
	@Target(ElementType.METHOD)
	public static @interface OnPreRequest { }
	
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@Documented
	@Target(ElementType.METHOD)
	public static @interface OnSuccess { }
	
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@Documented
	@Target(ElementType.METHOD)
	public static @interface OnFailed { }
	
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	@Documented
	@Target(ElementType.METHOD)
	public static @interface OnComplete { }
}
