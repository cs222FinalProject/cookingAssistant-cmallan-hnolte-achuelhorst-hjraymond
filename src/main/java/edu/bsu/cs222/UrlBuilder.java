package edu.bsu.cs222;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UrlBuilder {

    private File file = new File("/Users/abbyhuelhorst/Desktop/CS222/cookingAssistant/src/main/resources/key.txt");
    private Scanner scanner = new Scanner(file);
    private String key = scanner.nextLine();

    public UrlBuilder() throws FileNotFoundException {
    }
    public URL buildIngredientUrl(String ingredients) throws MalformedURLException, UnsupportedEncodingException {
        String queryString = encodeIngredientString(ingredients);
        String urlString = String.format("https://api.spoonacular.com/recipes/findByIngredients?" +
                "apiKey=%s&ingredients=%s&number=1", key, queryString);
        return new URL(urlString);
    }
    public URL buildRecipeUrl(String recipeId) throws MalformedURLException, UnsupportedEncodingException {
        String queryString = encodeIngredientString(recipeId);
        String urlString = String.format("https://api.spoonacular.com/recipes/%s/information?" +
                "apiKey=%s&number=1",queryString, key);
        return new URL(urlString);
    }
    public String encodeIngredientString(String query) throws UnsupportedEncodingException {
        return URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
    }
}
