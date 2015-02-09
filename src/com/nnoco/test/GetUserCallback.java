package com.nnoco.test;

import com.nnoco.golbang.annotation.Callback;

public interface GetUserCallback {
	@Callback.OnPreRequest
	public void onPreRequest();
	
	@Callback.OnSuccess
	public void success(User user);
	
	@Callback.OnFailed
	public void failed(int responseCode);
	
	@Callback.OnComplete
	public void onComplete();
}
