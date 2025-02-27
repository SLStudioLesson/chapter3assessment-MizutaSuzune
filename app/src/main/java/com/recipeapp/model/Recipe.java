package com.recipeapp.model;
import java.util.ArrayList;

public class Recipe {
    // レシピ名
    private String name;
    // 材料リスト
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    // コンストラクタ
    public Recipe (String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    // nameのセッター
    public String getName() {
        return this.name;
    }
    // 材料リストのセッター
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }

}