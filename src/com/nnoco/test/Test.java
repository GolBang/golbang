package com.nnoco.test;

import java.util.HashMap;
import java.util.Map;

import com.nnoco.golbang.GolBang;
import com.nnoco.golbang.util.KeyValue;


public class Test {
	public static void main(String[] args) {
		ExampleTemplate requester = GolBang.get(ExampleTemplate.class);
		Map<String, String> mapHeaderGroup = new HashMap<String, String>();
		mapHeaderGroup.put("Cookie", "Delicious");
		requester.getUserInformation(new KeyValue<String, String>("Gol", "Bang"),
				"String type Header",
				mapHeaderGroup,
				new Student("Junyoung", "0643901"),
				"/ab/c/d/{id}",
				"id is koltwgi",
				new KeyValue<String, String>("query", "String"),
				"쿼리 2 스트림 타입!",
				mapHeaderGroup);
	}
}
