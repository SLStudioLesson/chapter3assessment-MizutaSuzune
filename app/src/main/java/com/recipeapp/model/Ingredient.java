package com.recipeapp.model;

public class Ingredient {
    // 材料名
    private String name;

    // コンストラクタ
    public Ingredient (String name) {
        this.name = name;
    }

    // 材料名のセッター
    public String getName() {
        return this.name;
    }
}