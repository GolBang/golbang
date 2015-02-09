package com.nnoco.golbang.annotation.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.nnoco.golbang.annotation.Callback;
import com.nnoco.golbang.request.RequestMessage;
import com.nnoco.test.GetUserCallback;

public class DefaultCallbackHandler implements
		ParamAnnotationHandler<Callback> {

	@Override
	public void handle(Annotation annotation, RequestMessage message, Object arg) {
		Method[] methods = arg.getClass().getDeclaredMethods();
		Method[] inherited = arg.getClass().getMethods();
		GetUserCallback callback = (GetUserCallback)arg;
		callback.onComplete();
		for (Method method : methods) {
			System.out.println(method.getName());
//			System.out.println("is overrided: " + method.);
			System.out.println(method.getDeclaringClass());
			Callback.OnComplete complete = method.getAnnotation(Callback.OnComplete.class);
			if(null != complete) {
				try {
//					method.setAccessible(true);
					method.invoke(arg, null);
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		for(Method method : inherited) {
			System.out.println(method.getName());
			
			Callback.OnComplete complete = method.getAnnotation(Callback.OnComplete.class);
			if(null != complete) {
				try {
					method.invoke(arg, null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
