package maids.cc.quiz2.errors.products;

public class FailedToSaveProductException extends Exception{
    public FailedToSaveProductException(String message) {
        super(message);
    }
}
