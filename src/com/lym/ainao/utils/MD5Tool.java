package com.lym.ainao.utils;

import java.security.MessageDigest;

public class MD5Tool {
	// md5����
	public static String MD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5"); // �õ�MD5���ܶ���
			messageDigest.reset();
			messageDigest.update(sourceStr.getBytes("UTF-8"));
			byte[] bytes = messageDigest.digest(); // ���ؼ��ܺ���ֽ�����
			StringBuffer sb = new StringBuffer();
			String temp = "";
			for (int i = 0; i < bytes.length; i++) {
				temp = Integer.toHexString(0xFF & bytes[i]); // ���ֽ�ת��Ϊ16�ֽ��ַ���
				if (temp.length() == 1) {
					sb.append("0").append(temp);
				} else {
					sb.append(temp);
				}
			}
			result = sb.toString();
		} catch (Exception e) {
			throw new RuntimeException("û����������㷨��errorCode:" + e.toString());
		}
		return result;
	}
}
