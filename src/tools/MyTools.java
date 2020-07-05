package tools;

import myexception.TestException;

//���Լ��Ĺ�����
public class MyTools {

	// �ַ���ת���� ���ո�ָ���ַ���ת��Ϊ����ĸ��д���»���������ʽ�������������
	public static String strToName(String input) {
		// ע��null�Ϳ��ַ����ж�
		if (input == null && "".equals(input)) {
			return input;
		}

		String tmp[] = new String[3];

		// ����ȥͷβ�ո�
		input = input.trim();
		// ����ַ���Ϊ�������� ���ո���
		tmp = input.split(" ", 3);

		// ÿ����������ĸ��д
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = tmp[i].trim();
			tmp[i] = firstUpper(tmp[i]);
		}
		System.out.println(tmp[0]);
		System.out.println(tmp[1]);
		// Ȼ��ƴ��
		input = "";
		for (int i = 0; i < tmp.length - 1; i++) {
			input += tmp[i] + "_";
		}
		input += tmp[tmp.length - 1];

		return input;
	}

	// ����ĸ��д���߷���
	public static String firstUpper(String input) {
		// ע��null�Ϳ��ַ����ж�
		if (input == null && "".equals(input)) {
			return input;
		}
		input = input.replaceFirst(input.substring(0, 1), input.substring(0, 1).toUpperCase());
		return input;
	}

	// ����ĳ�ַ��������ַ������ֵĴ���
	public static int countSubStr(String input, String substr) throws TestException {
		String tmp = input;
		int cnt = 0;
		
		if (input == null || "".equals(input) || substr == null || "".equals(substr)||"aj".equals(substr)) 
		{
			throw new TestException("�����˴�����ַ���������");
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
