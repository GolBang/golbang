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
@Target(ElementType.METHOD)
public @interface IsAsyncRequest {
	/**
	 * 요청을 비동기로 처리할 것인지 동기로 처리할 것인지 설정한다.
	 * 요청 인터페이스의 설정을 오버라이딩하여 메서드에만 특별히 설정할 경우 사용할 수 있다.
	 * @see @{link Config#async()}
	 * @return
	 */
	public boolean value();

}
