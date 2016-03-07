package com.lym.ainao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lym.ainao.R;
import com.lym.ainao.bean.AlarmClock;
import com.lym.ainao.bean.AlarmClockTheme;

public class EditAlarmClockActivity extends BaseActivity implements
		OnClickListener {

	private static final int REQUEST_CODE_ADDCLOCKTHEME = 0;
	private AlarmClock alarmClock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editalarmclock);

		initView();

		initData();
	}

	private void initData() {
		alarmClock = new AlarmClock();
	}

	private void initView() {
		Button btn_add_theme = (Button) findViewById(R.id.btn_add_theme);
		btn_add_theme.setOnClickListener(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case REQUEST_CODE_ADDCLOCKTHEME:
				AlarmClockTheme act = (AlarmClockTheme) data
						.getSerializableExtra("result");
				alarmClock.setAlarmClockTheme(act);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_add_theme:
			Intent intent = new Intent(this, AlarmClockThemeActivity.class);
			startActivityForResult(intent, REQUEST_CODE_ADDCLOCKTHEME);
			break;

		default:
			break;
		}
	}

}
