package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public interface DataHandler {
    // 現在のモードを返す
    public String getMode();

    // レシピデータを読み込み、recipeリストを返す
    public ArrayList<Recipe> readData() throws IOException;

    // 指定されたrecipeオブジェクトを追加
    public void writeData(Recipe recipe) throws IOException;

    // 指定されたキーワードでレシピを検索し、一致するrecipeリストを返す
    public ArrayList<Recipe> searchData(String keyword) throws IOException;
}