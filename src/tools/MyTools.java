package tools;

import myexception.TestException;

//我自己的工具类
public class MyTools {

	// 字符串转名字 带空格分割的字符串转换为首字母大写的下划线连接形式，最多三个单词
	public static String strToName(String input) {
		// 注意null和空字符串判断
		if (input == null && "".equals(input)) {
			return input;
		}

		String tmp[] = new String[3];

		// 首先去头尾空格
		input = input.trim();
		// 拆分字符串为单个名字 按空格拆分
		tmp = input.split(" ", 3);

		// 每个单词首字母大写
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = tmp[i].trim();
			tmp[i] = firstUpper(tmp[i]);
		}
		System.out.println(tmp[0]);
		System.out.println(tmp[1]);
		// 然后拼接
		input = "";
		for (int i = 0; i < tmp.length - 1; i++) {
			input += tmp[i] + "_";
		}
		input += tmp[tmp.length - 1];

		return input;
	}

	// 首字母大写工具方法
	public static String firstUpper(String input) {
		// 注意null和空字符串判断
		if (input == null && "".equals(input)) {
			return input;
		}
		input = input.replaceFirst(input.substring(0, 1), input.substring(0, 1).toUpperCase());
		return input;
	}

	// 计算某字符串中子字符串出现的次数
	public static int countSubStr(String input, String substr) throws TestException {
		String tmp = input;
		int cnt = 0;
		
		if (input == null || "".equals(input) || substr == null || "".equals(substr)||"aj".equals(substr)) 
		{
			throw new TestException("传入了错误的字符串，请检查");
		}

		while (tmp.indexOf(substr) >= 0) {
			cnt++;
			if (tmp.indexOf(substr) + 1 >= tmp.length()) {
				break;
			}
			tmp = tmp.substring(tmp.indexOf(substr) + 1);
		}

		return cnt;

	}

}
