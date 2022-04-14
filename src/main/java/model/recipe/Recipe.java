package model.recipe;

import lombok.Builder;
import lombok.Getter;
import model.ingredient.Ingredient;

import java.util.List;

@Builder
@Getter
public class Recipe {

    private int id;

    private String name;

    private List<String> steps;

    public List<Ingredient> ingredients;

    public void validate(){

    }
}
