package model.user.customexception;

public class IncompatibleRegimeException extends Exception{
    public IncompatibleRegimeException(String errorMessage) {
        super(errorMessage);
    }
}
