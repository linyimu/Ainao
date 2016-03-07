package com.lym.ainao.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.lym.ainao.AppConfig;
import com.lym.ainao.Constact;
import com.lym.ainao.R;

public class SplashActivity extends BaseActivity {
	/** �Ѿ���½ */
	private static final int MSG_LOGINED = 0;
	/** ��½���� */
	private static final int MSG_LOGIN_OUTTIME = 1;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Intent intent;
			switch (msg.what) {
			case MSG_LOGINED:
				intent = new Intent(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();
				break;
			case MSG_LOGIN_OUTTIME:
				intent = new Intent(SplashActivity.this, LoginActivity.class);
				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		new Thread() {
			public void run() {
				long startTime = System.currentTimeMillis();
				boolean isLogined = isLogined();
				long endTime = System.currentTimeMillis();
				long timeDx = endTime - startTime;
				if (timeDx - 2000 > 0) {
					try {
						Thread.sleep(timeDx);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (isLogined) {
					handler.sendEmptyMessage(MSG_LOGINED);
				} else {
					handler.sendEmptyMessage(MSG_LOGIN_OUTTIME);
				}
			};
		}.start();
	}

	/**
	 * ����Ƿ��Ѿ���½
	 * 
	 * @return
	 */
	private boolean isLogined() {
		// �û��Ƿ��½
		boolean userLogined = sp.getBoolean(Constact.SP_USER_LOGINED, false);
		if (!userLogined) {
			return false;
		}
		Long loginTime = sp.getLong(Constact.SP_USER_LOGIN_TIME, 0l);
		// �����ڵ�ʱ��-��½��ʱ�䣬���������ĵ�½ʱ�䣬�򷵻�false
		int dayDx = (int) ((System.currentTimeMillis() - loginTime) / 1000 / 60 / 60 / 24);
		if (dayDx < AppConfig.user_max_login_day) {
			return false;
		}
		return true;
	}

}
