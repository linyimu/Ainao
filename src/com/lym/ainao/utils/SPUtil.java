package com.lym.ainao.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * SharedPreferences 工具类
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
	 * 打开SharedPreferences
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
	 * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
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
	 * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
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
	 * 移除某个key值已经对应的值
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
	 * 清除所有数据
	 * 
	 * @param context
	 */
	public void clear(Context context) {
		SharedPreferences.Editor editor = instance.sp.edit();
		editor.clear();
		SharedPreferencesCompat.apply(editor);
	}

	/**
	 * 查询某个key是否已经存在
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public boolean contains(Context context, String key) {
		return instance.sp.contains(key);
	}

	/**
	 * 返回所有的键值对
	 * 
	 * @param context
	 * @return
	 */
	public Map<String, ?> getAll(Context context) {
		return instance.sp.getAll();
	}

	/**
	 * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
	 * 
	 * @author zhy
	 * 
	 */
	private static class SharedPreferencesCompat {
		private static final Method sApplyMethod = findApplyMethod();

		/**
		 * 反射查找apply的方法
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
		 * 如果找到则使用apply执行，否则使用commit
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
