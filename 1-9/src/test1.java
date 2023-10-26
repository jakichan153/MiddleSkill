
public class test1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

//      1.数字の5と9の変数を定義し、足した数字を出力しなさい。
		int num1 = 5;
		int num2 = 9;
		
		int sumResult = num1 + num2;
		System.out.println(sumResult);
		
		
//		2.64ビット整数の「1111111111」を定義し2倍した値を出力しなさい。
		
		long Number = 1111111111L;
		
		long Value = Number * 2;
		
		System.out.println(Value);
//		3.boolean型の変数の値に不正な文字列比較を入れてfalseを出力してください。	

		String str1 = "Hello";
		String str2 = "World";
		
		boolean isEqual = str1.equals(str2);
		
		System.out.println(isEqual);
	}

}
