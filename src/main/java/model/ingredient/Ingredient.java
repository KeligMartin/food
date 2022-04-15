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

    private List<DietaryRegimes> compatibleRegimeList;

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expirationDate);
    }

    public boolean isCompatibleWithRegimeList(List<DietaryRegimes> regimes){
        for (DietaryRegimes regime: regimes) {
            if (!this.getCompatibleRegimeList().contains(regime)){
                return false;
            }
        }
        return true;
    }
}
