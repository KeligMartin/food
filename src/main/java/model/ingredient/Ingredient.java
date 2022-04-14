package model.ingredient;

import lombok.Builder;
import lombok.Getter;
import model.user.DietaryRegimes;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class Ingredient {

    private int id;

    private String name;

    private LocalDate expirationDate;

    private List<DietaryRegimes> compatibleRegimes;

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expirationDate);
    }
}
