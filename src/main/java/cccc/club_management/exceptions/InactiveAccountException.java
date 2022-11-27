package cccc.club_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InactiveAccountException extends Exception{
    public InactiveAccountException() {
        super("Account not active");
    }
}