import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
    /*
     * 画面に選択メニューを表示する
     * インプットされた値条件分岐する 2:JSON 1:CSV それ以外:CSV
     * それぞれのクラスの空インスタンスを作成
     * RecipeUIのインスタンスを作成する際に、入力値を設定する
     * RecipeUIのメソッドを呼び出し、メニューを表示する
     */

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            if(choice.equals("2")) {
                DataHandler dataHandler = new JSONDataHandler();
                RecipeUI recipeui = new RecipeUI(dataHandler);
                recipeui.displayMenu();
            } else {
                DataHandler dataHandler = new CSVDataHandler();
                RecipeUI recipeui = new RecipeUI(dataHandler);
                recipeui.displayMenu();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}