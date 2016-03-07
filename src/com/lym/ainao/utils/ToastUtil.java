package com.lym.ainao.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast������
 * <p>
 * �ڵ��Խ׶οɽ�isDebug����Ϊtrue,�����е�toast������ʾ
 * </p>
 * <p>
 * ����isDebug����Ϊfalse,��ֻ��������show=true�ĲŻᱻ��ʾ
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

	/** ���� */
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
