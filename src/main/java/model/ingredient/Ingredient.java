package model.ingredient;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class Ingredient {

    private int id;

    private String name;

    private LocalDate expirationDate;

    public void validate(){

    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expirationDate);
    }
}
