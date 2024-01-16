import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class test1 {
	public static void main(String[] args) {
		//改行
		System.out.println("問１");
		//問題1:下記の条件を使ってfor文と条件文を組み合わせ結果が同じになるよう出力しなさい。for文ネスト3回（3回forを書くこと）
//		例）
//		for() {
//			for() {
//				for() {
//					
//				}
//			}
//		}
		//strArray1でfor文を回し3文字目(k)以降のものをstrArray2に格納する(1個目のfor文)
		//strArray2でfor文を回しkとaとoの物だけでstrArray3に格納する(2個目のfor文)
		//strArray3でfor文を回し「kakao」となるようにstrArray4に格納しstrArray4を出力する。(3個目のfor文)
		List<String> strArray1 = new ArrayList(Arrays.asList("f", "u", "k", "u", "d", "a", "k" , "a" , "n" , "e" , "k" , "o" ));
		List<String> strArray2 = new ArrayList<String>();
		List<String> strArray3 = new ArrayList<String>();
		List<String> strArray4 = new ArrayList<String>();
		

		 // 1st for loop: strArray1でfor文を回し3文字目(k)以降のものをstrArray2に格納する
        for (int i = 2; i < strArray1.size(); i++) {
            strArray2.add(strArray1.get(i));

            // 2nd for loop: strArray2でfor文を回しkとaとoの物だけでstrArray3に格納する
            for (int j = 0; j < strArray2.size();j++) {
            	if (strArray2.get(j).equals("k") || strArray2.get(j).equals("a") || strArray2.get(j).equals("o")) {
                    strArray3.add(strArray2.get(j));
                }

                    // 3rd for loop: strArray3でfor文を回し「kakao」となるようにstrArray4に格納しstrArray4を出力する
            	for (int k = 0; k <= strArray3.size() -5; k++) {

                  // Additional conditions within 3rd for loop
                  if (strArray4.size() == 0 && strArray3.get(k).equals("k")) {
                      strArray4.add(strArray3.get(k));
                  } else if (strArray4.size() == 1 && strArray3.get(k).equals("a")) {
                      strArray4.add(strArray3.get(k));
                  }else if (strArray4.size() == 2 && strArray3.get(k).equals("k")) {
                      strArray4.add(strArray3.get(k));
                      }else if (strArray4.size() == 3 && strArray3.get(k).equals("a")) {
                          strArray4.add(strArray3.get(k));
                          }
       
                        if(strArray4.size() == 4  || strArray3.get(k).equals("o")) {
                        	  strArray4.add(strArray3.get(k));
                          }
                        
                    }
                }
            }
        

        System.out.println(strArray4);
    }
}