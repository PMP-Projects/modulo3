package br.com.fatec.modulo_lambda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@ActiveProfiles("test")
class ModuloLambdaApplicationTests {

    @Test
    void deveExecutarMetodoMainSemErros() {
        assertDoesNotThrow(() -> ModuloLambdaApplication.main(new String[]{}));
    }
}
