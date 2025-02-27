package com.recipeapp.datahandler;
import java.io.IOException;
import java.util.ArrayList;
import com.recipeapp.model.Recipe;
import com.recipeapp.model.Ingredient;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class CSVDataHandler implements DataHandler {
    // レシピデータを格納するCSVファイルのパス
    private String filePath;

    // コンストラクタ
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        String mode = "CSV";
        return mode;
    }

    @Override
    /*
     * recipes.csv`からレシピデータを読み込み、それをリスト形式で返します。
     * filePathを元にCSVファイルを読み込む
     * CSVファイルの読み込み時にリストに追加を行う(1行ずつリストに設定)
     */
    public ArrayList<Recipe> readData() {
        ArrayList<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while(!((line = reader.readLine()). isEmpty())) {
                String recipeName =line.substring(0,line.indexOf(","));
                String[] ing1 =(line.substring(line.indexOf(",") + 1)).split(",");
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for(String ing : ing1) {
                    ingredients.add(new Ingredient(ing));
                }
                recipes.add(new Recipe(recipeName,ingredients));
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
        return recipes;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {

    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        return null;
    }
}