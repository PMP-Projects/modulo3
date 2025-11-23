package br.com.fatec.modulo_lambda;

import br.com.fatec.modulo_lambda.utils.json.exception.JsonHexConversionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JsonHexConversionExceptionTest {

    @Test
    void deveCriarExcecaoComMensagem() {
        JsonHexConversionException ex = new JsonHexConversionException("Erro ao converter");
        Assertions.assertEquals("Erro ao converter", ex.getMessage());
    }

    @Test
    void deveCriarExcecaoComMensagemECausa() {
        Throwable causa = new IllegalArgumentException("Causa original");
        JsonHexConversionException ex = new JsonHexConversionException("Falha grave", causa);

        Assertions.assertEquals("Falha grave", ex.getMessage());
        Assertions.assertEquals(causa, ex.getCause());
    }
}
