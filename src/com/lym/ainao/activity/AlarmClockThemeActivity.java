package com.lym.ainao.activity;

import com.lym.ainao.R;
import com.lym.ainao.bean.AlarmClockTheme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlarmClockThemeActivity extends BaseActivity implements
		OnClickListener {

	private AlarmClockTheme alarmClockTheme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clocktheme);
		initView();
		initData();
	}

	private void initData() {
		alarmClockTheme = new AlarmClockTheme();

	}

	private void initView() {
		Button btn_add = (Button) findViewById(R.id.btn_add);
		btn_add.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_add:
			alarmClockTheme.setObjectId("kljomlk546165");
			alarmClockTheme.setAnswer("你好");
			alarmClockTheme.setBgUrl("http://***/image/bg.jpg");
			alarmClockTheme.setMessage("你说好么？");
			alarmClockTheme.setMusicUrl("http://***/music/ms.mp3");
			alarmClockTheme.setTitle("测试主题");
			alarmClockTheme.setType(0);
			break;

		default:
			break;
		}

	}

}
