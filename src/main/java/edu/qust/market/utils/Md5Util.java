package edu.qust.market.utils;

import java.security.MessageDigest;

public class Md5Util {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	public final static String md5calc(String data) {
		// 如果有空则返回""
		String s = data == null ? "" : data;
		try {
			// 将字符串转为字节数组
			byte[] strTemp = s.getBytes();
			// 加密器
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			// 执行加密
			mdTemp.update(strTemp);
			// 加密结果
			byte[] md = mdTemp.digest();
			// return byteArrayToString(md);
			//return HexBinary.encode(md);
			return byteArrayToHexString(md);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static String md5calc(String data,Object salt) {
		// 如果有空则返回""
		String s = data == null ? "" : data;
		try {
			// 将字符串转为字节数组
			byte[] strTemp = s.getBytes();
			// 加密器
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			// 执行加密
			mdTemp.update(strTemp);
			// 加密结果
			byte[] md = mdTemp.digest(mergePasswordAndSalt(data,salt).getBytes("utf-8"));
			// return byteArrayToString(md);
			//return HexBinary.encode(md);
			return byteArrayToHexString(md); 
		} catch (Exception e) {
			return null;
		}
	}
	
	
    private static String mergePasswordAndSalt(String password,Object salt) { 
        if (password == null) { 
            password = ""; 
        } 

        if ((salt == null) || "".equals(salt)) { 
            return password; 
        } else { 
            return password + "{" + salt.toString() + "}"; 
        } 
    } 

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

}
