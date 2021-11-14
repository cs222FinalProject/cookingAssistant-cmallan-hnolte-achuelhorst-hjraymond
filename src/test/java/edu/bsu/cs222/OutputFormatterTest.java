package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class OutputFormatterTest {

    private final ArrayList<Recipe> testRecipeList = new ArrayList<>();
    private final OutputFormatter formatter = new OutputFormatter();

    @Test
    public void testFormatRecipe() throws MalformedURLException {
        URL url = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");
        Recipe recipe = new Recipe.Builder().withTitle("Peanut Butter Muffins").andSource(url);
        testRecipeList.add(recipe);
        String expectedFormat = String.format("Title: %s\nSource: %s\n\n", recipe.getTitle(), recipe.getSource());
        String actualFormat = formatter.format(testRecipeList);
        Assertions.assertEquals(expectedFormat, actualFormat);
    }

}
