package com.mycj.protocol.util;

import java.text.DecimalFormat;

/**
 * 数据转换工具类
 * 
 * @author Administrator
 * 
 */
public class DataUtil {

	public static DecimalFormat df = new DecimalFormat("0.00");
	public static DecimalFormat df2 = new DecimalFormat("0.0");

	/**
	 * byte[]转变为16进制String字符, 每个字节2位, 不足补0
	 */
	public static String byteToHexString(byte[] bytes) {
		String result = null;
		String hex = null;
		if (bytes != null && bytes.length > 0) {
			final StringBuilder stringBuilder = new StringBuilder(bytes.length);
			for (byte byteChar : bytes) {
				hex = Integer.toHexString(byteChar & 0xFF);
				if (hex.length() == 1) {
					hex = '0' + hex;
				}
				stringBuilder.append(hex.toUpperCase());
			}
			result = stringBuilder.toString();
		}
		return result;
	}

	/**
	 * 十进制String--->十六进制String, 每个字节2位, 不足补0
	 */
	public static String toHexStringByString(String value) {
		String hex = Integer.toHexString(Integer.valueOf(value));
		StringBuilder stringBuilder = new StringBuilder();
		if (hex.length() == 1) {
			hex = '0' + hex;
		}
		stringBuilder.append(hex);
		return stringBuilder.toString();
		
	}

	/**
	 * 把16进制String字符转变为byte[]
	 */
	public static byte[] hexStringToByte(String data) {
		byte[] bytes = null;
		if (data != null) {
			data = data.toUpperCase();
			int length = data.length() / 2;
			char[] dataChars = data.toCharArray();
			bytes = new byte[length];
			for (int i = 0; i < length; i++) {
				int pos = i * 2;
				bytes[i] = (byte) (charToByte(dataChars[pos]) << 4 | charToByte(dataChars[pos + 1]));
			}
		}
		return bytes;
	}

	
	/**
	 * 取得在16进制字符串中各char所代表的16进制数
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
	/**
	 * 十进制int ---->十六进制String 不足补0
	 * @param i
	 * @return
	 */
	public static String toHexString(int i) {
		String value = Integer.toHexString(i);
		if (value.length() == 1) {
			value = "0" + value;
		}
		return value;
	}

	

	/**
	 * 根据传入的2个字节2位16进制字符比如FFFF, 计算返回int类型的绝对值
	 */
	public static int hexStringToInt(String hexString) {
		return binaryString2int(hexString2binaryString(hexString));
	}

	/**
	 * 16进制转换为2进制
	 */
	public static String hexString2binaryString(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0) {
			return null;
		}
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++) {
			tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}

	/**
	 * 二进制转为10进制 返回int
	 */
	public static int binaryString2int(String binarysString) {
		if (binarysString == null || binarysString.length() % 8 != 0) {
			return 0;
		}
		int result = Integer.valueOf(binarysString, 2);
		if ("1".equals(binarysString.substring(0, 1))) {
			System.out.println("这是个负数");
			char[] values = binarysString.toCharArray();
			for (int i = 0; i < values.length; i++) {
				if (values[i] == '1') {
					values[i] = '0';
				} else {
					values[i] = '1';
				}
			}
			binarysString = String.valueOf(values);
			result = Integer.valueOf(binarysString, 2) + 1;
		}

		return result;
	}

	// 二进制转十六进制
	public static String binaryToHex(String s) {
		return Long.toHexString(Long.parseLong(s, 2));
	}
	// 十六进制String --> 转int
	public static int hexToInt(String hex) {
		return Integer.parseInt(hex,16);
	}

	// 十六进制转二进制
	public static String HexToBinary(String s) {
		return Long.toBinaryString(Long.parseLong(s, 16));
	}

	/**
	 * 根据步数得到卡洛里 并且格式化
	 * 
	 * @param step
	 * @return
	 */
	public static String getKal(int step) {
		DecimalFormat df = new DecimalFormat("0.00");
		String kael = df.format(((step / 1000) * 18.842));
		return kael;

	}

	/**
	 * 根据步数得到距离 并且格式化
	 * 
	 * @param step
	 * @return
	 */
	public static String getDistance(int step) {
		DecimalFormat df = new DecimalFormat("0.00");
		String km = df.format((step / 1000) * 0.416);
		return km;
	}

	/**
	 * 根据完成步数/目标步数 得到百分比
	 * 
	 * @param b
	 * @return
	 */
	public static String getPercent(int x, int total) {
		// NumberFormat num = NumberFormat.getPercentInstance();
		// NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
		// nf .setMaximumIntegerDigits(2);
		// nf .setMaximumFractionDigits(2);
		// return nf.format(b);

		String result = "";// 接受百分比的值
		double x_double = x * 1.0;
		double tempresult = x_double / total;
		// NumberFormat nf = NumberFormat.getPercentInstance(); 注释掉的也是一种方法
		// nf.setMinimumFractionDigits( 2 ); 保留到小数点后几位
		DecimalFormat df1 = new DecimalFormat("0.00%"); // ##.00%
														// 百分比格式，后面不足2位的用0补齐
		// result=nf.format(tempresult);
		result = df1.format(tempresult);
		return result;
	}

	/**
	 * 十进制的字符串 --> 十六进制的字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String getHexFormOctString(String value) {
		return Integer.toHexString(Integer.valueOf(value));
	}

	/**
	 * int n1 = 14; //十进制转成十六进制： Integer.toHexString(n1); //十进制转成八进制
	 * Integer.toOctalString(n1); //十进制转成二进制 Integer.toBinaryString(12);
	 * 
	 * //十六进制转成十进制 Integer.valueOf("FFFF",16).toString(); //十六进制转成二进制
	 * Integer.toBinaryString(Integer.valueOf("FFFF",16)); //十六进制转成八进制
	 * Integer.toOctalString(Integer.valueOf("FFFF",16));
	 * 
	 * //八进制转成十进制 Integer.valueOf("576",8).toString(); //八进制转成二进制
	 * Integer.toBinaryString(Integer.valueOf("23",8)); //八进制转成十六进制
	 * Integer.toHexString(Integer.valueOf("23",8));
	 * 
	 * 
	 * //二进制转十进制 Integer.valueOf("0101",2).toString(); //二进制转八进制
	 * Integer.toOctalString(Integer.parseInt("0101", 2)); //二进制转十六进制
	 * Integer.toHexString(Integer.parseInt("0101", 2));
	 */

	public static String format(float value) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(value);

	}

}
