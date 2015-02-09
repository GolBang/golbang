package com.nnoco.test;

import java.util.Map;

import com.nnoco.golbang.annotation.IsAsyncRequest;
import com.nnoco.golbang.annotation.Config;
import com.nnoco.golbang.annotation.Header;
import com.nnoco.golbang.annotation.PathVariable;
import com.nnoco.golbang.annotation.QueryString;
import com.nnoco.golbang.annotation.Request;
import com.nnoco.golbang.annotation.RequestBody;
import com.nnoco.golbang.annotation.RequestPath;
import com.nnoco.golbang.request.HttpMethod;
import com.nnoco.golbang.util.KeyValue;

@Config(server="https://www.nnoco.com/api",
		header={"Content-Type=application/json", "Accept=application/json"},
		async=true)
public interface ExampleTemplate {
	@Request(value="/user", 
			method=HttpMethod.GET,
			server="http://www.nnoco.com/v2/api", // 서버 오버라이드
			header = "")
	@IsAsyncRequest(false)
	public String getUserInformation(@Header KeyValue<String, String> header,
			@Header("headerKey") String stringTypeHeader,
			@Header Map<String, String> headerGroup,
			@RequestBody Student student,
			@RequestPath("/user/{id}") String path, // 동적으로 요청 Path를 지정하고 싶을 때. 메서드를 오버라이딩 함
			@PathVariable("id") String pathVariable,
			@QueryString KeyValue<String, String> q1, // 또는 QueryString Factory?
			@QueryString("q2") String q2, // 또는 배열
			@QueryString Map<String, String> queries);
	
	//@Hash #..
	// 콜백은 어디에?
	// 비동기 호출의 경우 리턴타입을 void로?
	/**
	@IgnoreConfig
	
	 */
}
