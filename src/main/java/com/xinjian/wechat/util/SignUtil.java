package com.xinjian.wechat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author xinjianhou
 *
 * @date Mar 12, 2018
 */
public class SignUtil {

	/**
	 * @Fields TOKEN : TODO
	 */
	private final static String TOKEN = "Monkey";

	/**
	 * <p>Title: byteToHexStr </p>
	 * <p>Description: </p>
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(final byte mByte) {
		final char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		final char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		final String s = new String(tempArr);
		return s;
	}
	/**
	 * <p>Title: byteToStr </p>
	 * <p>Description: </p>
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(final byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	/**
	 * <p>Title: checkSignature </p>
	 * <p>Description: </p>
	 * @param signatrue
	 * @param timestamp
	 * @param noce
	 * @return
	 */
	public static boolean checkSignature(final String signature, final String timestamp, final String noce) {

		final String[] arr = new String[] {TOKEN,timestamp,noce};
		//sort?
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行 sha1 加密
			final byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (final NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		// 将 sha1 加密后的字符串可与 signature 对比，标识该请求来源于微信
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}


}
