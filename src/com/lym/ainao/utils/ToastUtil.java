package com.lym.ainao.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * <p>
 * 在调试阶段可将isDebug设置为true,则所有的toast都会显示
 * </p>
 * <p>
 * 若将isDebug设置为false,则只有设置了show=true的才会被显示
 * </p>
 * 
 * @author xuyao
 * 
 */
public class ToastUtil {
	private static ToastUtil instance;
	private Context context;
	private Toast toast;

	private ToastUtil() {
	}

	public static ToastUtil getInstance(Context context) {
		if (instance == null) {
			synchronized (ToastUtil.class) {
				if (instance == null) {
					instance = new ToastUtil();
					instance.toast = Toast.makeText(context, "",
							Toast.LENGTH_SHORT);
				}
			}
		}
		return instance;
	}

	/** 调试 */
	public final static boolean isDebug = true;

	public void showToast(String str, boolean... isDebug) {
		if (isDebug.length > 0 && isDebug[0]) {
		} else {
			toast.setText(str);
			toast.show();
		}
	}

	public void showToast(int resId, boolean... isDebug) {
		if (isDebug.length > 0 && isDebug[0]) {
		} else {
			toast.setText(resId);
			toast.show();
		}
	}
}
