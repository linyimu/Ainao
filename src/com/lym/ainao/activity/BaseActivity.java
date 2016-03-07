package com.lym.ainao.activity;

import com.lym.ainao.AppConfig;
import com.lym.ainao.utils.SPUtil;
import com.lym.ainao.utils.ToastUtil;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class BaseActivity extends Activity {
	public SPUtil sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sp = SPUtil.open(this, AppConfig.SP_FILE_NAME);
	}

	public void showToast(String text) {
		ToastUtil.getInstance(this).showToast(text);
	}
}
