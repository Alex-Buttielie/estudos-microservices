package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportMathOperationException extends RuntimeException {
    private static long serialVersionUID = 1L;

    public UnsuportMathOperationException(String exception) {
        super(exception);
    }


}
