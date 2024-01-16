import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		String shinyaBirthday = "1998/03/19";
		String minamiBirthday = "2000/02/14";
		String furuyamaBirthday = "1998/09/12";
		//改行
		System.out.println("問１");
		//問題1:現在の時刻を出力してください
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		
		System.out.println(date);
		//改行
		System.out.println("問２");
		//問題2:shinyaBirthdayとminamiBirthdayを日付型に変更し条件式で誕生日を比較し早い方の日付を文字列型で出力しなさい。
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date shinyaDate = dateFormat.parse(shinyaBirthday);
			Date minamiDate = dateFormat.parse(minamiBirthday);
			
			if(shinyaDate.before(minamiDate)) {
				System.out.println(shinyaBirthday);
			}else {
				System.out.println(minamiBirthday);
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
		//改行
		System.out.println("問３");
		//問題3:furuyamaBirthdayに５年2ヶ月追加した値を文字列型で表示しなさい
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthday = LocalDate.parse(furuyamaBirthday, formatter);
        LocalDate futureDate = birthday.plusYears(5).plusMonths(2);
        
        System.out.println(futureDate.format(formatter));
	}
}


