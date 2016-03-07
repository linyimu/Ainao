package com.lym.ainao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lym.ainao.R;

public class MainActivity extends BaseActivity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mian);
		initView();
	}

	private void initView() {
		Button btn_login = (Button) findViewById(R.id.btn_add_clock);
		btn_login.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_add_clock:
			// 跳转到新建闹钟
			Intent intent = new Intent(this, EditAlarmClockActivity.class);
			startActivity(intent);
			break;
		}
	}
}
