package com.lym.ainao.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * SharedPreferences ������
 * 
 * @author xuyao
 * 
 */
public class SPUtil {
	private SharedPreferences sp;
	public static String filename = "";
	private static SPUtil instance;

	private SPUtil() {
	}

	/**
	 * ��SharedPreferences
	 * 
	 * @param context
	 * @param filename
	 * @return
	 */
	public static SPUtil open(Context context, String filename) {
		// System.out.println("context;" +context +"," + filename);
		SharedPreferences sp = context.getSharedPreferences(filename,
				Context.MODE_PRIVATE);
		instance = new SPUtil();
		instance.sp = sp;
		return instance;
	}

	/**
	 * �������ݵķ�����������Ҫ�õ��������ݵľ������ͣ�Ȼ��������͵��ò�ͬ�ı��淽��
	 * 
	 * @param context
	 * @param key
	 * @param object
	 */
	public void putObject(String key, Object object) {
		SharedPreferences.Editor editor = sp.edit();

		if (object instanceof String) {
			editor.putString(key, (String) object);
		} else if (object instanceof Integer) {
			editor.putInt(key, (Integer) object);
		} else if (object instanceof Boolean) {
			editor.putBoolean(key, (Boolean) object);
		} else if (object instanceof Float) {
			editor.putFloat(key, (Float) object);
		} else if (object instanceof Long) {
			editor.putLong(key, (Long) object);
		} else {
			editor.putString(key, object.toString());
		}
		SharedPreferencesCompat.apply(editor);
	}

	public void put(String key, String value) {
		putObject(key, value);
	}

	public void put(String key, Integer value) {
		putObject(key, value);
	}

	public void put(String key, Boolean value) {
		putObject(key, value);
	}

	public void put(String key, Float value) {
		putObject(key, value);
	}

	public void put(String key, Long value) {
		putObject(key, value);
	}

	/**
	 * �õ��������ݵķ��������Ǹ���Ĭ��ֵ�õ���������ݵľ������ͣ�Ȼ���������ڵķ�����ȡֵ
	 * 
	 * @param context
	 * @param key
	 * @param defaultObject
	 * @return
	 */
	public Object get(String key, Object defaultObject) {
		if (defaultObject instanceof String || defaultObject == null) {
			return sp.getString(key, (String) defaultObject);
		} else if (defaultObject instanceof Integer) {
			return sp.getInt(key, (Integer) defaultObject);
		} else if (defaultObject instanceof Boolean) {
			return sp.getBoolean(key, (Boolean) defaultObject);
		} else if (defaultObject instanceof Float) {
			return sp.getFloat(key, (Float) defaultObject);
		} else if (defaultObject instanceof Long) {
			return sp.getLong(key, (Long) defaultObject);
		} else {

		}
		return null;
	}

	public String getString(String key, String defaultValue) {
		return (String) get(key, defaultValue);
	}

	public int getInt(String key, int defaultValue) {
		return (Integer) get(key, defaultValue);
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		return (Boolean) get(key, defaultValue);
	}

	public float getFloat(String key, float defaultValue) {
		return (Float) get(key, defaultValue);
	}

	public Double getDouble(String key, double defaultValue) {
		return (Double) get(key, defaultValue);
	}

	public Long getLong(String key, Long defaultValue) {
		return (Long) get(key, defaultValue);
	}

	/**
	 * �Ƴ�ĳ��keyֵ�Ѿ���Ӧ��ֵ
	 * 
	 * @param context
	 * @param key
	 */
	public void remove(String key) {
		SharedPreferences.Editor editor = instance.sp.edit();
		editor.remove(key);
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * �����������
	 * 
	 * @param context
	 */
	public void clear(Context context) {
		SharedPreferences.Editor editor = instance.sp.edit();
		editor.clear();
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * ��ѯĳ��key�Ƿ��Ѿ�����
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public boolean contains(Context context, String key) {
		return instance.sp.contains(key);
	}

	/**
	 * �������еļ�ֵ��
	 * 
	 * @param context
	 * @return
	 */
	public Map<String, ?> getAll(Context context) {
		return instance.sp.getAll();
	}

	/**
	 * ����һ�����SharedPreferencesCompat.apply������һ��������
	 * 
	 * @author zhy
	 * 
	 */
	private static class SharedPreferencesCompat {
		private static final Method sApplyMethod = findApplyMethod();

		/**
		 * �������apply�ķ���
		 * 
		 * @return
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private static Method findApplyMethod() {
			try {
				Class clz = SharedPreferences.Editor.class;
				return clz.getMethod("apply");
			} catch (NoSuchMethodException e) {
			}

			return null;
		}

		/**
		 * ����ҵ���ʹ��applyִ�У�����ʹ��commit
		 * 
		 * @param editor
		 */
		public static void apply(SharedPreferences.Editor editor) {
			try {
				if (sApplyMethod != null) {
					sApplyMethod.invoke(editor);
					return;
				}
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}
			editor.commit();
		}
	}
}
