import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test1 {
    private static final Logger logger = Logger.getLogger("middleskill log");

    public static void main(String[] args) {
        System.out.println("問１");

        try {
            // 条件１: 例外でヌルポが発生させヌルポをキャッチした場合のみログ出力がされる
            throw new NullPointerException("ヌルポが発生しました。");
        } catch (NullPointerException e) {
            // 条件４: ログの内容はコンソールに出ている赤文字と同じ内容のものが表示される
            logger.log(Level.INFO, "ミドルスキルログが発生しました。", e);
            e.printStackTrace(); // コンソールに赤文字で例外情報を表示
        }
    }

    static {
        try {
            // 条件２: "middleskill log"という名前のログのインスタンスを生成
            // 条件３: srcディレクトリ内に"middleskill.log"としてログ出力される設定
            FileHandler fileHandler = new FileHandler("src/middleskill.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
