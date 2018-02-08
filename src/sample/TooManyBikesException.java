package sample;

public class TooManyBikesException extends Exception {

    TooManyBikesException(){
        super("Too many bikes!");
    }
    TooManyBikesException(String msg){
        super(msg);
    }
}
