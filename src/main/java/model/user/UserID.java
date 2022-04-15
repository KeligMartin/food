package model.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class UserID {

    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserID userID = (UserID) o;
        return Objects.equals(id, userID.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
