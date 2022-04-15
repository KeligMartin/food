package model.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeID {

    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeID recipeID = (RecipeID) o;
        return Objects.equals(id, recipeID.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
