package com.lym.ainao.utils;

import java.security.MessageDigest;

public class MD5Tool {
	// md5加密
	public static String MD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5"); // 拿到MD5加密对象
			messageDigest.reset();
			messageDigest.update(sourceStr.getBytes("UTF-8"));
			byte[] bytes = messageDigest.digest(); // 返回加密后的字节数组
			StringBuffer sb = new StringBuffer();
			String temp = "";
			for (int i = 0; i < bytes.length; i++) {
				temp = Integer.toHexString(0xFF & bytes[i]); // 把字节转换为16字节字符串
				if (temp.length() == 1) {
					sb.append("0").append(temp);
				} else {
					sb.append(temp);
				}
			}
			result = sb.toString();
		} catch (Exception e) {
			throw new RuntimeException("没有这个加密算法。errorCode:" + e.toString());
		}
		return result;
	}
}
