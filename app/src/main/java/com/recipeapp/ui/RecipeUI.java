package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Recipe;
import com.recipeapp.model.Ingredient;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                /*
                 * 1が選択された場合の処理に、displayRecipesメソッドを呼ぶ処理を追加する
                 */

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }
    /*
     * CSVDataHandlerクラスのreadDataメソッドを呼び、リストを取得する
     * Recipeクラスのメソッドを使い、リストから１行ずつ取得し表示する
     * 材料リストはさらに繰り返し処理を使ってリストの中身を表示する
     */
    private void displayRecipes() {
        try{
            ArrayList<Recipe> recipe = new ArrayList<>();
            recipe = dataHandler.readData();
            if (!(recipe.size() == 0)) {
                System.out.println("Recipes:");
                recipe.forEach(re -> {
                    System.out.println("-----------------------------------");
                    System.out.println("Recipe Name: " + re.getName());
                    System.out.print("Main Ingredients: ");
                    ArrayList<Ingredient> ingarry = re.getIngredients();
                    for(int i = 0; i < ingarry.size(); i++) {
                            System.out.print(ingarry.get(i).getName());
                            if(!(i == ingarry.size() -1)) {
                                System.out.print(",");
                            }
                    }
                    System.out.println();
                    System.out.println("-----------------------------------");
                });
            } else {
                System.out.println("No recipes available.");
            }
        } catch(IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
        }
    }
}
