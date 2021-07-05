package tkstudy.starterproject.base.error.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.management.RuntimeErrorException;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Username is already exists")
public class RoleIsNotExistsException extends RuntimeException {

    public RoleIsNotExistsException() {
        super();
    }

    public RoleIsNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleIsNotExistsException(String message) {
        super(message);
    }

    public RoleIsNotExistsException(Throwable cause) {
        super(cause);
    }
}
