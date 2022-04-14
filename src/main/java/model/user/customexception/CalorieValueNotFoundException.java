package model.user.customexception;

public class CalorieValueNotFoundException extends Exception{
    public CalorieValueNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
