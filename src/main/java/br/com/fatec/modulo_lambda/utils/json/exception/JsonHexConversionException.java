package br.com.fatec.modulo_lambda.utils.json.exception;

public class JsonHexConversionException extends RuntimeException {

    public JsonHexConversionException(String message) {
        super(message);
    }

    public JsonHexConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
