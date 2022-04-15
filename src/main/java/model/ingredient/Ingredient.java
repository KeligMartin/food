package model.ingredient;

import lombok.Builder;
import lombok.Getter;
import model.user.DietaryRegimes;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
public class Ingredient {

    private String id;

    private String name;

    private LocalDate expirationDate;

    private List<DietaryRegimes> compatibleRegimeList;

    private Integer calorie;

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expirationDate);
    }

    public boolean isCompatibleWithRegimeList(List<DietaryRegimes> regimes){
        for (DietaryRegimes regime: regimes) {
            if(this.getCompatibleRegimeList().contains(DietaryRegimes.ALL)){
                return true;
            }
            if (!this.getCompatibleRegimeList().contains(regime)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(compatibleRegimeList, that.compatibleRegimeList) && Objects.equals(calorie, that.calorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, expirationDate, compatibleRegimeList, calorie);
    }
}
