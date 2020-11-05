
package Exceptions;

public class WrongLoginException extends Exception {

    public WrongLoginException() {
    }

    public WrongLoginException(String msg) {
        super(msg);
    }
}
