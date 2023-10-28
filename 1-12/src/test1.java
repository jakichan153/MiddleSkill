public class test1 {
	public static void main(String[] args) {
		//改行
		System.out.println("問１");
		//問題1:下記の条件を満たすようにif文を3つネストして条件式を作成してください。
		//
		//変数x,y,zは正の整数であれば下の条件に続く。それ以外は”正の整数：NG”と表示する
		//xの値が10の倍数であれば下の条件に続く。それ以外は”10の倍数：NG”と表示する
		//x + y + z = 100であれば”プラス100：OK”それ以外は”プラス100：NG”と表示する
		
		int x = 10;
		int y = 80;
		int z = 15;
		
		if (x > 0 && y > 0 && z > 0) {
		    if (x % 10 == 0) {
		        if (x + y + z == 100) {
		            System.out.println("プラス100：OK");
		        } else {
		            System.out.println("プラス100：NG");
		        }
		    } else {
		        System.out.println("10の倍数：NG");
		    }
		} else {
		    System.out.println("正の整数：NG");
		}//まず、ｘ,y,zが整数かどうかチェックしないと、そもそも次の条件であるｘの値が10倍の倍数～をチェックする必要がない
		//条件の順番も大事
		
		//改行
		System.out.println("問２");
		//問題2:問1と同じ内容で三項演算子で条件式を作成しなさい。最後に変数aを出力する。
		String a = (x > 0) ? ((x % 10 == 0) ? ((x + y + z == 100) ? "プラス100：OK" : "プラス100：NG") : "10の倍数：NG") : "正の整数：NG";

System.out.println(a);
	}
}




