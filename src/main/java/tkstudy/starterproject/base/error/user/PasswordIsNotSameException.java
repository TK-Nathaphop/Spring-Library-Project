package tkstudy.starterproject.base.error.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.management.RuntimeErrorException;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Password and confirmation password are not same")
public class PasswordIsNotSameException extends RuntimeException {

    public PasswordIsNotSameException() {
        super();
    }

    public PasswordIsNotSameException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordIsNotSameException(String message) {
        super(message);
    }

    public PasswordIsNotSameException(Throwable cause) {
        super(cause);
    }
}
