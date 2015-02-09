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
@Target(ElementType.TYPE)
public @interface Config {
	/**
	 * 공통 헤더
	 * @return
	 */
	public String[] header();
	
	/**
	 * 공통 서버 주소
	 * 예) http://www.nnoco.com/test/api
	 * @return
	 */
	public String server();
	
	public boolean async();
}
