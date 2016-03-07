package com.lym.ainao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.lym.ainao.Constact;
import com.lym.ainao.R;
import com.lym.ainao.utils.MD5Tool;

public class LoginActivity extends BaseActivity implements OnClickListener {
	private String userName;
	private String userPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	private void initView() {
		Button btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(this);
		
		System.out.println("initView");

	}

	public void login() {
		EditText et_username = (EditText) findViewById(R.id.et_username);
		EditText et_password = (EditText) findViewById(R.id.et_password);

		userName = et_username.getText().toString().trim();
		userPassword = et_password.getText().toString().trim();
		if (TextUtils.isEmpty(userName)) {
			showToast("用户名不能为空");
			return;
		}
		if (TextUtils.isEmpty(userPassword)) {
			showToast("密码不能为空");
			return;
		}
		userPassword = MD5Tool.MD5(userPassword);
		asyncLogin(userName, userPassword);
	}

	private void asyncLogin(String userName, String password) {
		new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						onLoginSuccess();
					}
				});
			};
		}.start();
	}

	private void onLoginSuccess() {
		// 将信息保存到sp文件中
		sp.put(Constact.SP_USER_NAME, userName);
		sp.put(Constact.SP_USER_PASSWORD, userPassword);
		sp.put(Constact.SP_USER_LOGINED, true);

		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		this.finish();

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_login:
			System.out.println("login");
			login();
			break;
		}
	}
}
